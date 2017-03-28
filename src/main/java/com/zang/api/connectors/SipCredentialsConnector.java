package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.Credential;
import com.zang.api.domain.CredentialsList;
import com.zang.api.domain.list.CredentialsListsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.SipCredentialsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;


/**
 * Used for all forms of communication with the Sip Credentials endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class SipCredentialsConnector extends BaseConnector {

    private SipCredentialsProxy proxy;

    SipCredentialsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(SipCredentialsProxy.class);
    }


    public CredentialsList viewCredentialsList(String accountSid, String credentialsListSid) throws ZangException {
        return returnThrows(proxy.viewCredentialsList(accountSid, credentialsListSid), CredentialsList.class);
    }

    public CredentialsList viewCredentialsList(String credentialsListSid) throws ZangException {
        return viewCredentialsList(conf.getSid(), credentialsListSid);
    }


    public CredentialsListsList listCredentialsLists(String accountSid) throws ZangException {
        return returnThrows(proxy.listCredentialsLists(accountSid), CredentialsListsList.class);
    }

    public CredentialsListsList listCredentialsLists() throws ZangException {
        return listCredentialsLists(conf.getSid());
    }


    public CredentialsList createCredentialsList(String accountSid, String friendlyName) throws ZangException {
        return returnThrows(proxy.createCredentialsList(accountSid, friendlyName), CredentialsList.class);
    }

    public CredentialsList createCredentialsList(String friendlyName) throws ZangException {
        return createCredentialsList(conf.getSid(), friendlyName);
    }


    public CredentialsList updateCredentialsList(String accountSid, String credentialsListSid, String friendlyName) throws ZangException {
        return returnThrows(proxy.updateCredentialsList(accountSid, credentialsListSid, friendlyName), CredentialsList.class);
    }

    public CredentialsList updateCredentialsList(String credentialsListSid, String friendlyName) throws ZangException {
        return updateCredentialsList(conf.getSid(), credentialsListSid, friendlyName);
    }


    public CredentialsList deleteCredentialsList(String accountSid, String credentialsListSid) throws ZangException {
        return returnThrows(proxy.deleteCredentialsList(accountSid, credentialsListSid), CredentialsList.class);
    }

    public CredentialsList deleteCredentialsList(String credentialsListSid) throws ZangException {
        return deleteCredentialsList(conf.getSid(), credentialsListSid);
    }


    public Credential viewCredential(String accountSid, String credentialsListSid, String credentialSid) throws ZangException {
        return returnThrows(proxy.viewCredential(accountSid, credentialsListSid, credentialSid), Credential.class);
    }

    public Credential viewCredential(String credentialsListSid, String credentialSid) throws ZangException {
        return viewCredential(conf.getSid(), credentialsListSid, credentialSid);
    }


    public com.zang.api.domain.list.CredentialsList listCredentials(String accountSid, String credentialsListSid) throws ZangException {
        return returnThrows(proxy.listCredentials(accountSid, credentialsListSid), com.zang.api.domain.list.CredentialsList.class);
    }

    public com.zang.api.domain.list.CredentialsList listCredentials(String credentialsListSid) throws ZangException {
        return listCredentials(conf.getSid(), credentialsListSid);
    }


    public Credential createCredential(String accountSid, String credentialsListSid, String username, String password) throws ZangException {
        return returnThrows(proxy.createCredential(accountSid, credentialsListSid, username, password), Credential.class);
    }

    public Credential createCredential(String credentialsListSid, String username, String password) throws ZangException {
        return createCredential(conf.getSid(), credentialsListSid, username, password);
    }


    public Credential updateCredential(String accountSid, String credentialsListSid, String credentialSid, String password) throws ZangException {
        return returnThrows(proxy.updateCredential(accountSid, credentialsListSid, credentialSid, password), Credential.class);
    }

    public Credential updateCredential(String credentialsListSid, String credentialSid, String password) throws ZangException {
        return updateCredential(conf.getSid(), credentialsListSid, credentialSid, password);
    }


    public Credential deleteCredential(String accountSid, String credentialsListSid, String credentialSid) throws ZangException {
        return returnThrows(proxy.deleteCredential(accountSid, credentialsListSid, credentialSid), Credential.class);
    }

    public Credential deleteCredential(String credentialsListSid, String credentialSid) throws ZangException {
        return deleteCredential(conf.getSid(), credentialsListSid, credentialSid);
    }
}
