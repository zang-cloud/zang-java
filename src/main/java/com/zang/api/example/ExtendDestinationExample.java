package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.list.FraudList;
import com.zang.api.exceptions.ZangException;

public class ExtendDestinationExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			FraudList fraudControlResources = conn.extendDestinationAuth("US", null, null, null);
			System.out.println(fraudControlResources.getFrauds().getMaxOutboundRate());
			
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
