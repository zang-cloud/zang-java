package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.ApplicationClient;
import com.zang.api.domain.list.ApplicationClientsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.ApplicationClientsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;


public class ApplicationClientsConnector extends BaseConnector {

    private ApplicationClientsProxy applicationClientsProxy;

    ApplicationClientsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        applicationClientsProxy = createProxy(ApplicationClientsProxy.class);
    }

    public ApplicationClient viewApplicationClient(String accountSid, String applicationSid, String clientSid) throws ZangException {
        return returnThrows(applicationClientsProxy.viewApplicationClient(accountSid, applicationSid, clientSid), ApplicationClient.class);
    }

    public ApplicationClient viewApplicationClient(String applicationSid, String clientSid) throws ZangException {
        return viewApplicationClient(conf.getSid(), applicationSid, clientSid);
    }

    public ApplicationClientsList listApplicationClients(String accountSid, String applicationSid) throws ZangException {
        return returnThrows(applicationClientsProxy.listApplicationClients(accountSid, applicationSid), ApplicationClientsList.class);
    }

    public ApplicationClientsList listApplicationClients(String applicationSid) throws ZangException {
        return listApplicationClients(conf.getSid(), applicationSid);
    }

    public ApplicationClient createApplicationClient(String accountSid, String applicationSid, String nickname) throws ZangException {
        return returnThrows(applicationClientsProxy.createApplicationClient(accountSid, applicationSid, nickname), ApplicationClient.class);
    }

    public ApplicationClient createApplicationClient(String applicationSid, String nickname) throws ZangException {
        return createApplicationClient(conf.getSid(), applicationSid, nickname);
    }
}
