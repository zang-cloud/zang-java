package com.zang.api.examples;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.ApplicationClientsConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.ApplicationClient;
import com.zang.api.domain.list.ApplicationClientsList;
import com.zang.api.exceptions.ZangException;

public class ApplicationClientsExample {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        ApplicationClientsConnector conn = ZangConnectorFactory.getApplicationClientsConnector(conf);

        try {
            conn.createApplicationClient("{ApplicationSid}", "MyClient");
            ApplicationClientsList applicationClients = conn.listApplicationClients("{ApplicationSid}");
            String firstClientSid = applicationClients.iterator().next().getSid();
            ApplicationClient firstClient = conn.viewApplicationClient("{ApplicationSid}", firstClientSid);
            System.out.println(firstClient.getRemoteIp());
        } catch (ZangException e) {
            e.printStackTrace();
        }
    }
}
