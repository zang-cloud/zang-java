package com.zang.api;

import org.junit.Test;

import com.zang.api.exceptions.ZangException;

public class FraudControlTest extends BaseZangTest {

	@Test
	public void testListFraudControlResources() throws ZangException {
		connector.listFraudControlResources(0L, 15L);
	}
	
	@Test
	public void testBlockDestination() throws ZangException {
		connector.blockDestination("US", true, true, true);
	}
	
	@Test
	public void testAuthorizeDestination() throws ZangException {
		connector.authorizeDestination("US", true, true, true);
	}
	
	@Test
	public void testExtendDestination() throws ZangException {
		connector.extendDestinationAuth("US", true, true, true);
	}
	
	@Test
	public void testWhitelistDestination() throws ZangException {
		connector.whitelistDestination("US", true, true, true);
	}

}
