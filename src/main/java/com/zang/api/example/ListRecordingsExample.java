package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.Recording;
import com.zang.api.domain.list.RecordingList;
import com.zang.api.exceptions.ZangException;

public class ListRecordingsExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			RecordingList recordingList = conn.listRecordings();
			for(Recording recording : recordingList) {
				System.out.println(recording.getSid());
			}
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
