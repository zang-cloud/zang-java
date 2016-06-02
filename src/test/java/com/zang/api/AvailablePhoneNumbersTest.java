package com.zang.api;

import org.junit.Test;

import com.zang.api.exceptions.ZangException;

public class AvailablePhoneNumbersTest extends BaseZangTest {
	
	@Test
	public void testListAvailablePhoneNumbers() throws ZangException{
		connector.listAvailablePhoneNumbers("US", "425", "999", "KS", "66101", 0L, 10L);
	}
}
