package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.IncomingPhoneNumber;
import com.zang.api.exceptions.ZangException;

public class AddOrDeleteIncomingPhoneNumberExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			IncomingPhoneNumber incomingPhoneNumber = conn.addIncomingPhoneNumber("{phone_number}", "{area_code}");
			String incomingPhoneNumberSid = incomingPhoneNumber.getSid();
			
			IncomingPhoneNumber deletedNumber = conn.deleteIncomingPhoneNumber(incomingPhoneNumberSid);
			System.out.println(deletedNumber.getSid());
			
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
