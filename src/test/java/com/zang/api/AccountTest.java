package com.zang.api;

import com.zang.api.domain.Account;
import org.junit.Assert;
import org.junit.Test;

import com.zang.api.exceptions.ZangException;

public class AccountTest extends BaseZangTest{
	
	@Test
	public void testGetAccount() throws ZangException{
		connector.updateAccount(conf.getSid(), "friendlyname1");
		Account account = connector.viewAccount(conf.getSid());
		Assert.assertEquals("friendlyname1", account.getFriendlyName());
		connector.updateAccount(conf.getSid(), "friendlyname2");
		account = connector.viewAccount(conf.getSid());
		Assert.assertEquals("friendlyname2", account.getFriendlyName());
	}
	
}
