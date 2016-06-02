package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.IncomingPhoneNumber;
import com.zang.api.exceptions.ZangException;

public class ViewIncomingPhoneNumberExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			IncomingPhoneNumber incomingPhoneNumber = conn.viewIncomingPhoneNumber("{IncomingPhoneNumberSid}");
			System.out.println(incomingPhoneNumber.getSid());
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
