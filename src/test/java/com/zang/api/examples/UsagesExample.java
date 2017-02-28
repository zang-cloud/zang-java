package com.zang.api.examples;

import com.zang.api.BaseZangTest;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.UsagesConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.Usage;
import com.zang.api.domain.enums.Product;
import com.zang.api.domain.list.UsagesList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.requests.UsagesRequest;

import java.math.BigDecimal;

public class UsagesExample extends BaseZangTest {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        UsagesConnector conn = new ZangConnectorFactory(conf).getUsagesConnector();

        try {
            //get a specific usage
            conn.viewUsage("{UsageSid}");

            UsagesRequest usagesRequest = new UsagesRequest();
            usagesRequest.setProduct(Product.OUTBOUND_SMS);
            usagesRequest.setYear(2017);
            usagesRequest.setMonth(2);
            usagesRequest.setPageSize(100L);

            //get a list of usages
            UsagesList usagesList = conn.listUsages(usagesRequest);

            BigDecimal total = BigDecimal.ZERO;
            for (Usage usage : usagesList) {
                total = total.add(usage.getTotalCost());
            }
            System.out.println(total);
        } catch (ZangException e) {
            e.printStackTrace();
        }
    }

}
