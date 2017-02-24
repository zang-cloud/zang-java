package com.zang.api.example;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.SmsConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.SmsMessage;
import com.zang.api.exceptions.ZangException;

public class SendSmsExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		SmsConnector conn = ZangConnectorFactory.getSmsConnector(conf);
		
		try {
			SmsMessage smsMessage = conn
					.sendSmsMessage(
							"(XXX) XXX-XXXX",
							"(XXX) XXX-XXXX",
							"This is an SMS message sent from the Zang Java wrapper! Easy as 1, 2, 3!",
							null,
							null,
							null);
			System.out.println(smsMessage.getSid());
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
