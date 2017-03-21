package com.zang.api.unit;

import com.zang.api.connectors.ApplicationClientsConnector;
import com.zang.api.domain.ApplicationClient;
import com.zang.api.domain.enums.PresenceStatus;
import com.zang.api.domain.list.ApplicationClientsList;
import com.zang.api.exceptions.ZangException;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.model.Parameter;

import java.io.IOException;


public class ApplicationClientsTest extends BaseUnitTest {

    private ApplicationClientsConnector connector;

    @Before
    public void initConnector() {
        connector = connectorFactory.getApplicationClientsConnector();
    }

    @Test
    public void viewApplicationClient() throws ZangException, IOException {
        createExpectation("GET", "Applications/TestApplicationSid/Clients/TestApplicationClientSid.json", null, null,
                "/applicationclients/applicationclient.json");
        ApplicationClient applicationClient = connector.viewApplicationClient("TestApplicationSid", "TestApplicationClientSid");
        checkApplicationClient(applicationClient);
    }

    @Test
    public void listApplicationClients() throws ZangException, IOException {
        createExpectation("GET", "Applications/TestApplicationSid/Clients.json", null, null,
                "/applicationclients/applicationclientslist.json");

        ApplicationClientsList applicationClients = connector.listApplicationClients("TestAccountSid", "TestApplicationSid");

        Assert.assertEquals(1, (int) applicationClients.getTotal());
        checkApplicationClient(applicationClients.iterator().next());
    }

    @Test
    public void createApplicationClient() throws ZangException, IOException {
        createExpectation("POST", "Applications/TestApplicationSid/Clients/Tokens.json", new Parameter[]{
                new Parameter("Nickname", "MyApplicationClient")
        }, null, "/applicationclients/applicationclient.json");
        ApplicationClient applicationClient = connector.createApplicationClient("TestApplicationSid", "MyApplicationClient");
        checkApplicationClient(applicationClient);
    }


    private void checkApplicationClient(ApplicationClient applicationClient) {
        Assert.assertEquals("TestApplicationClientSid", applicationClient.getSid());
        Assert.assertEquals("MyApplicationClient", applicationClient.getNickname());
        Assert.assertEquals("10.0.0.1", applicationClient.getRemoteIp());
        Assert.assertEquals(PresenceStatus.INIT, applicationClient.getPresenceStatus());
    }

}
