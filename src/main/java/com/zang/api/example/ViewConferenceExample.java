package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.Conference;
import com.zang.api.exceptions.ZangException;

public class ViewConferenceExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			Conference conference = conn.viewConference("{ConferenceSid}");
			System.out.println(conference.getSid());
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
