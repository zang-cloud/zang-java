package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.SmsConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.SmsMessage;
import com.zang.api.domain.list.SmsMessageList;
import com.zang.api.exceptions.ZangException;

public class ListSmsExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		SmsConnector conn = ZangConnectorFactory.getSmsConnector(conf);
		try {
			SmsMessageList smsMessageList = conn.listSmsMessages();
			for(SmsMessage smsMessage : smsMessageList) {
				System.out.println(smsMessage.getSid());
			}
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
