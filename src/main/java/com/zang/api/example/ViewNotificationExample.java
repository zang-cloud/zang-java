package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.Notification;
import com.zang.api.exceptions.ZangException;

public class ViewNotificationExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			Notification notification = conn.viewNotification("{NotificationSid}");
			System.out.println(notification.getSid());
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
