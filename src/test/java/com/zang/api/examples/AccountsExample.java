package com.zang.api.examples;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.AccountsConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.Account;
import com.zang.api.exceptions.ZangException;

public class AccountsExample {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        AccountsConnector conn = new ZangConnectorFactory(conf).getAccountsConnector();

        try {
            Account account = conn.viewAccount("{AccountSid}");
            System.out.println(account.getSid());
        } catch (ZangException e) {
            e.printStackTrace();
        }
    }
}
