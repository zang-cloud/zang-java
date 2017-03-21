package com.zang.api.unit;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.configuration.ZangConstants;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.testutil.MockConfiguration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.mockserver.integration.ClientAndProxy;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.*;
import org.mockserver.socket.PortFactory;

import java.io.IOException;

public abstract class BaseUnitTest {

    ZangConfiguration conf;
    ZangConnectorFactory connectorFactory;

    static ClientAndProxy proxy;
    ClientAndServer mockServer;

    private int serverPort = 41123;


    public BaseUnitTest() {
        conf = new MockConfiguration(serverPort);
        connectorFactory = new ZangConnectorFactory(conf);

    }

    @BeforeClass
    public static void startProxy() {
        proxy = ClientAndProxy.startClientAndProxy(PortFactory.findFreePort());
    }

    @AfterClass
    public static void stopProxy() {
        proxy.stop();
    }

    @Before
    public void startMockServer() {
        mockServer = ClientAndServer.startClientAndServer(serverPort);
        proxy.reset();
    }

    @After
    public void stopMockServer() {
        mockServer.stop();
    }

    protected void createExpectation(String method, String path,
                                     Parameter[] bodyParams, Parameter[] queryParams,
                                     String responseFile) throws IOException {
        if (path.equals("Accounts")) {
            path = "Accounts/" + conf.getSid() + ".json";
        } else {
            path = "Accounts/" + conf.getSid() + "/" + path;
        }
        if (bodyParams == null) bodyParams = new Parameter[]{};
        if (queryParams == null) queryParams = new Parameter[]{};
        System.out.println(BaseUnitTest.class.getResource(responseFile));
        String responseBody = Resources.toString(BaseUnitTest.class.getResource(responseFile), Charsets.UTF_8);
        mockServer.when(HttpRequest
                .request()
                .withMethod(method)
                .withPath("/" + ZangConstants.API_VERSION + "/" + path)
                .withQueryStringParameters(queryParams)
                .withBody(
                        new ParameterBody(bodyParams)
                )
        )
                .respond(HttpResponse.response()
                        .withHeaders(
                                new Header("Content-Type", "application/json")
                        )
                        .withBody(responseBody));
    }

}
