package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.Participant;
import com.zang.api.exceptions.ZangException;

public class DeafOrMuteParticipantExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			Participant participant = conn.deafOrMuteParticipant("{ConferenceSid}", "{CallSid}", false, true);
			System.out.println(participant.getCallSid());
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
