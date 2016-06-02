package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.Application;
import com.zang.api.exceptions.ZangException;

public class ViewApplicationExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			Application application = conn.viewApplication("{ApplicationSid}");
			System.out.println(application.getSid());
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
