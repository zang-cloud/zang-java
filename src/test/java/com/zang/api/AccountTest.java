package com.zang.api;

import org.junit.Test;

import com.zang.api.exceptions.ZangException;

public class AccountTest extends BaseZangTest{
	
	@Test
	public void testGetAccount() throws ZangException{
		connector.viewAccount(conf.getSid());
		connector.viewAccounts();
	}
	
}
