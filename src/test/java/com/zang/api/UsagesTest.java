package com.zang.api;

import com.zang.api.connectors.UsagesConnector;
import com.zang.api.domain.enums.Product;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.ListUsagesParams;
import org.junit.Test;
import org.mockserver.model.Parameter;

import java.io.IOException;

public class UsagesTest extends BaseZangTest {

    @Test
    public void viewUsage() throws ZangException, IOException {
        createExpectation("GET", "Usages/TestUsageSid.json", null, null,
                "/usages/usage.json");
        UsagesConnector connector = connectorFactory.getUsagesConnector();
        connector.viewUsage("TestUsageSid");

    }

    @Test
    public void listUsages() throws ZangException, IOException {
        createExpectation("GET", "Usages.json", null, new Parameter[]{
                new Parameter("Page", "0"),
                new Parameter("PageSize", "25"),
                new Parameter("Product", Product.OUTBOUND_SMS.toString()),
        }, "/usages/usageslist.json");
        UsagesConnector connector = connectorFactory.getUsagesConnector();
        ListUsagesParams ur = ListUsagesParams.builder()
                .setPage(0)
                .setPageSize(25)
                .setProduct(Product.OUTBOUND_SMS)
                .build();
        connector.listUsages(ur);

    }

}
