package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.Participant;
import com.zang.api.exceptions.ZangException;

public class PlayAudioToParticipantExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			Participant participant = conn.playAudioToParticipant("{ConferenceSid}", "{MemberId}", "{url_to_sound_file}");
			System.out.println(participant.getCallSid());
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
