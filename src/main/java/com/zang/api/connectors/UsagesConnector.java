package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.Usage;
import com.zang.api.domain.enums.Product;
import com.zang.api.domain.list.UsagesList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.requests.UsagesRequest;
import com.zang.api.restproxies.UsagesProxy;
import org.jboss.resteasy.client.ClientExecutor;
import org.jboss.resteasy.client.ClientResponse;

/**
 * The class used for all forms of communication with the Usage endpoint of the Zang REST API.
 */
public class UsagesConnector extends BaseConnector {

    private UsagesProxy usageProxy;

    /**
     * @see BaseConnector, PropertiesFileZangConfiguration,
     * ZangConfiguration
     */
    UsagesConnector(ZangConfiguration conf, ClientExecutor executor) {
        super(conf, executor);
        usageProxy = createProxy(UsagesProxy.class);
    }

    public Usage viewUsage(String accountSid, String usageSid) throws ZangException {
        ClientResponse<Usage> usage = usageProxy.getUsage(accountSid, usageSid);
        return returnThrows(usage);
    }

    public Usage viewUsage(String usageSid) throws ZangException {
        return viewUsage(conf.getSid(), usageSid);
    }

    public UsagesList listUsages(String accountSid, Integer day, Integer month, Integer year,
                                 Product product, Long page, Long pageSize) throws ZangException {
        Integer productCode = null;
        if (product != null && product != Product.UNKNOWN) {
            productCode = Integer.parseInt(product.toString());
        }
        ClientResponse<UsagesList> usages = usageProxy.listUsages(accountSid, day, month, year,
                productCode, page, pageSize);
        return returnThrows(usages);
    }

    public UsagesList listUsages(Integer day, Integer month, Integer year,
                                 Product product, Long page, Long pageSize) throws ZangException {
        return listUsages(conf.getSid(), day, month, year, product, page, pageSize);
    }

    public UsagesList listUsages(UsagesRequest usagesRequest) throws ZangException {
        String accountSid = usagesRequest.getAccountSid();
        if (accountSid == null) accountSid = conf.getSid();
        return listUsages(accountSid, usagesRequest.getDay(), usagesRequest.getMonth(), usagesRequest.getYear(),
                usagesRequest.getProduct(), usagesRequest.getPage(), usagesRequest.getPageSize());
    }

}
