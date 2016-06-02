package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.Transcription;
import com.zang.api.domain.enums.TranscriptionType;
import com.zang.api.exceptions.ZangException;

public class TranscribeAudioUrlExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			Transcription transcription = conn.transcribeRecording("{RecordingSid}", "http://liveoutput.com/transcribecallback", null, TranscriptionType.GOLD);
			System.out.println(transcription.getSid());
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
