package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.Call;
import com.zang.api.exceptions.ZangException;

public class PlayAudioExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			Call call = conn.playAudioToCall("{CallSid}", "http://example.com/sound-file.mp3");
			System.out.println(call.getSid());
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
