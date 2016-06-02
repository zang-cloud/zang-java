package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.SmsMessage;
import com.zang.api.exceptions.ZangException;

public class SendSmsExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			SmsMessage smsMessage = conn
					.sendSmsMessage(
							"(XXX) XXX-XXXX",
							"(XXX) XXX-XXXX",
							"This is an SMS message sent from the Zang Java wrapper! Easy as 1, 2, 3!",
							null);
			System.out.println(smsMessage.getSid());
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
