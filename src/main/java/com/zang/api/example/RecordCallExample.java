package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.list.RecordingList;
import com.zang.api.exceptions.ZangException;

public class RecordCallExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			RecordingList list = conn.recordCall("{CallSid}", true, null, null);
			System.out.println(list.getPagesize());
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
