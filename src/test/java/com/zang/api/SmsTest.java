package com.zang.api;

import com.zang.api.connectors.SmsConnector;
import com.zang.api.domain.SmsMessage;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.exceptions.ZangException;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Date;


public class SmsTest extends BaseZangTest {

	@Test
	public void testGetSmsList() throws ZangException{
		SmsConnector connector = connectorFactory.getSmsConnector();
		connector.listSmsMessages("1", "2", new Date(0), new Date(), 0L, 10L);
	}
	
	@Test
	public void testSendAndGetSms() throws ZangException{
        SmsConnector connector = connectorFactory.getSmsConnector();
		SmsMessage msg = connector.sendSmsMessage(testParameters.getPhone1(), testParameters.getPhone2(),
                "test from java", "callback.url", HttpMethod.GET, false);
		SmsMessage receivedMessage = connector.viewSmsMessage(msg.getSid());
		Assert.assertEquals(msg.getSid(), receivedMessage.getSid());
	}
	
}
