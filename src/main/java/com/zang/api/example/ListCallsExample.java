package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.Call;
import com.zang.api.domain.list.CallList;
import com.zang.api.exceptions.ZangException;

public class ListCallsExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			CallList callList = conn.listCalls();
			for(Call call : callList) {
				System.out.println(call.getSid());
			}
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
