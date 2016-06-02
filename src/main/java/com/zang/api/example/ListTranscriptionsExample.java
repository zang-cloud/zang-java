package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.Transcription;
import com.zang.api.domain.list.TranscriptionList;
import com.zang.api.exceptions.ZangException;

public class ListTranscriptionsExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			TranscriptionList transcriptionList = conn.listTranscriptions();
			for(Transcription transcription : transcriptionList) {
				System.out.println(transcription.getSid());
			}
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
