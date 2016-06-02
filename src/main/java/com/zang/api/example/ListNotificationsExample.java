package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.Notification;
import com.zang.api.domain.list.NotificationList;
import com.zang.api.exceptions.ZangException;

public class ListNotificationsExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			NotificationList notificationList = conn.listNotifications();
			for(Notification notification : notificationList) {
				System.out.println(notification.getSid());
			}
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
