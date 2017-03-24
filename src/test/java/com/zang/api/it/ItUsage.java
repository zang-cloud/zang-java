package com.zang.api.it;

import com.zang.api.connectors.UsagesConnector;
import com.zang.api.domain.list.UsagesList;
import com.zang.api.exceptions.ZangException;
import org.junit.Test;

public class ItUsage extends BaseIntegrationTest {


    public ItUsage() throws ZangException {
    }

    @Test
    public void usages() throws ZangException {
        UsagesConnector conn = connectorFactory.getUsagesConnector();
        UsagesList usages = conn.listUsages();
        if (usages.getTotal() > 0) {
            conn.viewUsage(usages.iterator().next().getSid());
        }
    }

}
