package com.zang.api;

import com.zang.api.connectors.AccountsConnector;
import com.zang.api.domain.Account;
import com.zang.api.exceptions.ZangException;
import org.junit.Assert;
import org.junit.Test;
import org.mockserver.model.Parameter;

import java.io.IOException;

public class AccountsTest extends BaseZangTest {

    @Test
    public void testViewAccount() throws ZangException, IOException {
        createExpectation("GET", "Accounts", null, null,
                "accounts\\account.json");
        AccountsConnector connector = connectorFactory.getAccountsConnector();
        Account account = connector.viewAccount(conf.getSid());
        Assert.assertEquals("friendlyname1", account.getFriendlyName());
    }

    @Test
    public void testUpdateAccount() throws ZangException, IOException {
        createExpectation("POST", "Accounts",
                new Parameter[]{
                        new Parameter("FriendlyName", "friendlyname1")
                }, null, "accounts\\account.json");
        AccountsConnector connector = connectorFactory.getAccountsConnector();
        connector.updateAccount("friendlyname1");
    }

}
