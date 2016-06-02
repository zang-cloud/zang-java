package com.zang.api;

import junit.framework.Assert;

import org.junit.Test;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.configuration.PropertiesFileZangConfiguration;
import com.zang.api.exceptions.ZangException;

public class ConnectionTest {

	@Test
	public void testInvalidCredentials(){
		BasicZangConfiguration conf = new BasicZangConfiguration("", "");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			conn.viewAccount(new PropertiesFileZangConfiguration().getSid());
			Assert.fail();
		} catch (ZangException e) {

		}
	}
	
}
