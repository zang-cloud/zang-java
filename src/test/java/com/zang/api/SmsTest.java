package com.zang.api;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.zang.api.domain.SmsMessage;
import com.zang.api.exceptions.ZangException;


public class SmsTest extends BaseZangTest {

	@Test
	public void testGetSmsList() throws ZangException{
		connector.listSmsMessages("1", "2", new Date(0), new Date(), 0L, 10L);
	}
	
	@Test
	public void testSendAndGetSms() throws ZangException{
		SmsMessage msg = connector.sendSmsMessage(testParameters.getPhone1(), testParameters.getPhone2(), "test from java", "callback.url");
		SmsMessage receivedMessage = connector.viewSmsMessage(msg.getSid());
		Assert.assertEquals(msg.getSid(), receivedMessage.getSid());
	}
	
}
