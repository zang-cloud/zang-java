package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.IncomingPhoneNumber;
import com.zang.api.exceptions.ZangException;
import com.zang.api.requests.IncomingPhoneNumberRequest;

public class UpdateIncomingPhoneNumberExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		IncomingPhoneNumberRequest ipnRequest = new IncomingPhoneNumberRequest();
		
		//the sid of the incoming phone number to be edited
		ipnRequest.setIncomingPhoneNumberSid("{IncomingPhoneNumberSid}");
		ipnRequest.setVoiceUrl("{fully_qualified_url}");
		try {
			IncomingPhoneNumber incomingPhoneNumber = conn.updateIncomingPhoneNumber(ipnRequest);
			System.out.println(incomingPhoneNumber.getSid());
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
