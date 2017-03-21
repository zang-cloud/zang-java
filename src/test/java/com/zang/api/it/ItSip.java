package com.zang.api.it;

import com.zang.api.connectors.SipCredentialsConnector;
import com.zang.api.domain.Credential;
import com.zang.api.domain.CredentialsList;
import com.zang.api.domain.list.CredentialsListsList;
import com.zang.api.exceptions.ZangException;
import junit.framework.Assert;
import org.junit.Test;

public class ItSip extends BaseIntegrationTest {


    private void deleteCredentials() throws ZangException {

        SipCredentialsConnector scc = connectorFactory.getSipCredentialsConnector();
        CredentialsListsList cls = scc.listCredentialsLists();
        for(CredentialsList clist : cls) {
            if (clist.getFriendlyName().equals("MyCredentialsList") || clist.getFriendlyName().equals("MyCredentialsList2")) {
                scc.deleteCredentialsList(clist.getSid());
            }
        }
    }

    @Test
    public void testSipCredentials() throws ZangException {
        SipCredentialsConnector scc = connectorFactory.getSipCredentialsConnector();

        deleteCredentials();

        CredentialsList cl = scc.createCredentialsList("MyCredentialsList");
        Credential cr = scc.createCredential(cl.getSid(), "testuser123", "34AS3!#$asfe");
        CredentialsList cl2 = scc.viewCredentialsList(cl.getSid());
        Credential cr2 = scc.viewCredential(cl.getSid(), cr.getSid());

        Assert.assertEquals("testuser123", cr2.getUsername());
        Assert.assertEquals("testuser123", cr.getUsername());
        Assert.assertEquals("MyCredentialsList", cl.getFriendlyName());
        Assert.assertEquals("MyCredentialsList", cl2.getFriendlyName());

        scc.updateCredentialsList(cl.getSid(), "MyCredentialsList2");
        CredentialsList cl3 = scc.viewCredentialsList(cl.getSid());
        Assert.assertEquals("MyCredentialsList2", cl3.getFriendlyName());

        com.zang.api.domain.list.CredentialsList credentials = scc.listCredentials(cl.getSid());
        Assert.assertEquals(1, (int)credentials.getTotal());
        for(Credential c : credentials) {
            Assert.assertEquals(c.getUsername(), "testuser123");
        }

        scc.updateCredential(cl.getSid(), cr.getSid(), "34AS3!#$asfa");

        deleteCredentials();
        CredentialsListsList cls = scc.listCredentialsLists();
        for(CredentialsList clist : cls) {
            if (clist.getFriendlyName().equals("MyCredentialsList") || clist.getFriendlyName().equals("MyCredentialsList2")) {
                Assert.fail();
            }
        }

    }
}
