package com.zang.api;

import junit.framework.Assert;

import org.junit.Test;

import com.zang.api.domain.IncomingPhoneNumber;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.list.IncomingPhoneNumberList;
import com.zang.api.exceptions.ZangException;

public class IncomingPhoneNumberTest extends BaseZangTest {
	
	@Test
	public void testListPhoneNumbers() throws ZangException {
		connector.listIncomingPhoneNumbers("1", "name", 0L, 10L);
	}
	
	@Test
	public void testViewPhoneNumber() throws ZangException {
		IncomingPhoneNumberList list = connector.listIncomingPhoneNumbers(null, null, null, null);
		for(IncomingPhoneNumber number : list) {
			connector.viewIncomingPhoneNumber(number.getSid());
		}
	}
	

	public void addPhoneNumbers() throws ZangException {
		connector.addIncomingPhoneNumber(testParameters.getPhone1(), testParameters.getArea1());
		connector.addIncomingPhoneNumber(testParameters.getPhone2(), testParameters.getArea2());
	}
	
	@Test
	public void testDeleteAndAddPhoneNumber() throws ZangException {
		
		IncomingPhoneNumberList list = connector.listIncomingPhoneNumbers(null, null, 0L, 1L);
		IncomingPhoneNumber number = list.iterator().next();
		
		connector.deleteIncomingPhoneNumber(number.getSid());
		
		list = connector.listIncomingPhoneNumbers(null, null, null, null);
		for(IncomingPhoneNumber lNumber : list) {
			if (lNumber.getSid().equals(number.getSid())) {
				Assert.fail("Number wasn't deleted!");
				return;
			}
		}
		
		String prefix = number.getPhoneNumber().substring(0, 5);
		connector.addIncomingPhoneNumber(number.getPhoneNumber(), prefix);
		
	}
	
	@Test
	public void testUpdateNumber() throws ZangException{
		IncomingPhoneNumberList list = connector.listIncomingPhoneNumbers(null, null, null, null);
		IncomingPhoneNumber number = list.iterator().next();
		connector.updateIncomingPhoneNumber(number.getSid(), "first_number", 
				"voice.com", HttpMethod.POST, "fallbackUrl.com", HttpMethod.GET, false, "smsurl.com", HttpMethod.POST, 
				"smsfallbackurl.com", HttpMethod.GET, "hangup.com", HttpMethod.POST, "heartbeat.com", HttpMethod.GET);
		IncomingPhoneNumber nr = connector.viewIncomingPhoneNumber(number.getSid());
		Assert.assertEquals("voice.com", nr.getVoiceUrl().trim());
		
		connector.updateIncomingPhoneNumber(number.getSid(), null, 
				"", null, null, null, null, null, null, null, null, null, null, null, null);
		nr = connector.viewIncomingPhoneNumber(number.getSid());
		Assert.assertEquals("", nr.getVoiceUrl().trim());
		
	}
	
}
