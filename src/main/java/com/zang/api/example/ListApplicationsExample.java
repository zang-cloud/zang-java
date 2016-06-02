package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.Application;
import com.zang.api.domain.list.ApplicationList;
import com.zang.api.exceptions.ZangException;

public class ListApplicationsExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			ApplicationList applicationList = conn.listApplications();
			for(Application application : applicationList) {
				System.out.println(application.getSid());
			}
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
