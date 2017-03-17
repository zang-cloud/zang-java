package com.zang.api.examples;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.ApplicationsConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.Application;
import com.zang.api.domain.list.ApplicationsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.ApplicationParams;

public class ApplicationsExample {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        ApplicationsConnector conn = ZangConnectorFactory.getApplicationsConnector(conf);

        try {
            ApplicationsList applications = conn.listApplications();
            Integer total = applications.getTotal();
            System.out.println(total + " applications detected.");
            Application newApplication = conn.createApplication(ApplicationParams.builder()
                    .setFriendlyName("MyApplication")
                    .setStatusCallback("http://mydomain.com/mystatuscallback")
                    .build()
            );

            conn.updateApplication(newApplication.getSid(),
                    ApplicationParams.builder()
                            .setFriendlyName("MyGreatApplication")
                            .build());

            conn.deleteApplication(newApplication.getSid());

        } catch (ZangException e) {
            e.printStackTrace();
        }
    }
}
