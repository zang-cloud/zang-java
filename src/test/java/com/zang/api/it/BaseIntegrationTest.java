package com.zang.api.it;

import com.zang.api.configuration.PropertiesFileZangConfiguration;
import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.testutil.TestParameters;

public abstract class BaseIntegrationTest {

    ZangConfiguration conf;
    TestParameters testParameters;
    ZangConnectorFactory connectorFactory;

    public BaseIntegrationTest() {
        this.testParameters = new TestParameters();
        conf = new PropertiesFileZangConfiguration();
        System.out.println(conf.getSid());
        System.out.println(conf.getAuthToken());
        connectorFactory = new ZangConnectorFactory(conf);

    }
}
