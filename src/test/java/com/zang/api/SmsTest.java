package com.zang.api;

import com.zang.api.connectors.SmsConnector;
import com.zang.api.domain.SmsMessage;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.exceptions.ZangException;
import junit.framework.Assert;
import org.junit.Test;


public class SmsTest extends BaseZangTest {

    @Test
    public void listSms() throws ZangException {
        SmsConnector connector = connectorFactory.getSmsConnector();
        connector.listSmsMessages(null, null, null, null, 0L, 10L);
    }

    @Test
    public void sendSms() throws ZangException {
        SmsConnector connector = connectorFactory.getSmsConnector();
        SmsMessage msg = connector.sendSmsMessage(testParameters.getPhone1(), testParameters.getPhone2(),
                "test from java", "callback.url", HttpMethod.GET, false);
        SmsMessage receivedMessage = connector.viewSmsMessage(msg.getSid());
        Assert.assertEquals(msg.getSid(), receivedMessage.getSid());
    }

    @Test
    public void viewSms() throws ZangException {
        SmsConnector connector = connectorFactory.getSmsConnector();
        SmsMessage receivedMessage = connector.viewSmsMessage("SMe18890840dec1c93b68d4966b1e5ace3");
    }

}
