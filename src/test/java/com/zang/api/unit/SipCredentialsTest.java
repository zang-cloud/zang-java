package com.zang.api.unit;

import com.zang.api.connectors.SipCredentialsConnector;
import com.zang.api.domain.Credential;
import com.zang.api.domain.CredentialsList;
import com.zang.api.exceptions.ZangException;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.model.Parameter;

import java.io.IOException;


public class SipCredentialsTest extends BaseUnitTest {

    private SipCredentialsConnector connector;

    @Before
    public void initConnector() {
        connector = connectorFactory.getSipCredentialsConnector();
    }


    @Test
    public void viewCredentialsList() throws ZangException, IOException {
        createExpectation("GET", "SIP/CredentialLists/TestCredentialsListSid.json", null, null,
                "/sipdomains/credentialslist.json");
        checkCredentialsList(connector.viewCredentialsList("TestCredentialsListSid"));
    }

    @Test
    public void listCredentialsLists() throws ZangException, IOException {
        createExpectation("GET", "SIP/CredentialLists.json", null, null,
                "/sipdomains/credentialslistlist.json");
        connector.listCredentialsLists();
    }


    @Test
    public void createCredentialsList() throws ZangException, IOException {
        createExpectation("POST", "SIP/CredentialLists.json", new Parameter[]{
                        new Parameter("FriendlyName", "MyCredentialsList")
                }, null,
                "/sipdomains/credentialslist.json");
        checkCredentialsList(connector.createCredentialsList("MyCredentialsList"));
    }


    @Test
    public void updateCredentialsList() throws ZangException, IOException {
        createExpectation("POST", "SIP/CredentialLists/TestCredentialsListSid.json", new Parameter[]{
                new Parameter("FriendlyName", "NewCredentialsList")
                }, null,
                "/sipdomains/credentialslist.json");
        checkCredentialsList(connector.updateCredentialsList("TestCredentialsListSid", "NewCredentialsList"));
    }


    @Test
    public void deleteCredentialsList() throws ZangException, IOException {
        createExpectation("DELETE", "SIP/CredentialLists/TestCredentialsListSid.json", null, null,
                "/sipdomains/credentialslist.json");
        checkCredentialsList(connector.deleteCredentialsList("TestCredentialsListSid"));
    }


    @Test
    public void viewCredential() throws ZangException, IOException {
        createExpectation("GET", "SIP/CredentialLists/TestCredentialsListSid/Credentials/TestCredentialSid.json", null, null,
                "/sipdomains/credential.json");
        checkCredential(connector.viewCredential("TestCredentialsListSid", "TestCredentialSid"));
    }


    @Test
    public void listCredentials() throws ZangException, IOException {
        createExpectation("GET", "SIP/CredentialLists/TestCredentialsListSid/Credentials.json", null, null,
                "/sipdomains/listofcredentials.json");
        connector.listCredentials("TestCredentialsListSid");
    }


    @Test
    public void createCredential() throws ZangException, IOException {
        createExpectation("POST", "SIP/CredentialLists/TestCredentialsListSid/Credentials.json", new Parameter[]{
                        new Parameter("Username", "username"),
                        new Parameter("Password", "password")
                }, null,
                "/sipdomains/credential.json");
        checkCredential(connector.createCredential("TestCredentialsListSid", "username", "password"));
    }


    @Test
    public void updateCredential() throws ZangException, IOException {
        createExpectation("POST", "SIP/CredentialLists/TestCredentialsListSid/Credentials/TestCredentialSid.json", new Parameter[]{
                new Parameter("Password", "password")
        }, null, "/sipdomains/credential.json");
        checkCredential(connector.updateCredential("TestCredentialsListSid", "TestCredentialSid", "password"));
    }


    @Test
    public void deleteCredential() throws ZangException, IOException {
        createExpectation("DELETE", "SIP/CredentialLists/TestCredentialsListSid/Credentials/TestCredentialSid.json", null, null,
                "/sipdomains/credential.json");
        checkCredential(connector.deleteCredential("TestCredentialsListSid", "TestCredentialSid"));
    }

    private void checkCredentialsList(CredentialsList cl) {

    }

    private void checkCredential(Credential credential) {

    }

}
