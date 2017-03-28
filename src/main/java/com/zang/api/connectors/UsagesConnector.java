package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.Usage;
import com.zang.api.domain.enums.Product;
import com.zang.api.domain.list.UsagesList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.ListUsagesParams;
import com.zang.api.restproxies.UsagesProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;

import javax.ws.rs.core.Response;

/**
 * Used for all forms of communication with the Usages endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class UsagesConnector extends BaseConnector {

    private UsagesProxy proxy;

    /**
     * @see BaseConnector, PropertiesFileZangConfiguration,
     * ZangConfiguration
     */
    UsagesConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(UsagesProxy.class);
    }

    public Usage viewUsage(String accountSid, String usageSid) throws ZangException {
        Response response = proxy.getUsage(accountSid, usageSid);
        return returnThrows(response, Usage.class);
    }

    public Usage viewUsage(String usageSid) throws ZangException {
        return viewUsage(conf.getSid(), usageSid);
    }

    public UsagesList listUsages(String accountSid, Integer day, Integer month, Integer year,
                                 Product product, Integer page, Integer pageSize) throws ZangException {
        Integer productCode = null;
        if (product != null && product != Product.UNKNOWN) {
            productCode = Integer.parseInt(product.toString());
        }
        Response usages = proxy.listUsages(accountSid, day, month, year,
                productCode, page, pageSize);
        return returnThrows(usages, UsagesList.class);
    }

    public UsagesList listUsages(Integer day, Integer month, Integer year,
                                 Product product, Integer page, Integer pageSize) throws ZangException {
        return listUsages(conf.getSid(), day, month, year, product, page, pageSize);
    }

    public UsagesList listUsages() throws ZangException {
        return listUsages(conf.getSid(), null, null, null, null, null, null);
    }

    public UsagesList listUsages(ListUsagesParams listUsagesParams) throws ZangException {
        return listUsages(listUsagesParams.getAccountSid() != null ? listUsagesParams.getAccountSid() : conf.getSid(), listUsagesParams.getDay(), listUsagesParams.getMonth(), listUsagesParams.getYear(),
                listUsagesParams.getProduct(), listUsagesParams.getPage(), listUsagesParams.getPageSize());
    }

}
