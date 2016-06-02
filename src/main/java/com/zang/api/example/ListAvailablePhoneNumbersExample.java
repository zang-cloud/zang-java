package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.AvailablePhoneNumber;
import com.zang.api.domain.list.AvailablePhoneNumberList;
import com.zang.api.exceptions.ZangException;

public class ListAvailablePhoneNumbersExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		
		try {
			AvailablePhoneNumberList availablePhoneNumbers = conn.listAvailablePhoneNumbers("US", null, null, "Local", null, null, null);
			for (AvailablePhoneNumber availablePhoneNumber : availablePhoneNumbers) {
				System.out.println(availablePhoneNumber.getPhoneNumber());
			}
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
