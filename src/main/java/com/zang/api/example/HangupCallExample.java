package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.Call;
import com.zang.api.exceptions.ZangException;

public class HangupCallExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			Call call = conn.hangUpCall("{CallSid}");
			System.out.println(call.getSid());
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
