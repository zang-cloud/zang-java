package com.zang.api.inboundxml.example;

import com.zang.api.inboundxml.elements.Dial;
import com.zang.api.inboundxml.elements.Response;
import com.zang.api.inboundxml.parameters.ConferenceParameters;

public class ConferenceExample {

	public static void main(String[] args) {
		ConferenceParameters params = new ConferenceParameters();
		params.setConferenceName("ZangExampleChat");
		params.setStartConferenceOnEnter(true);
		params.setCallbackUrl("http://webhookr.com/zang-inboundxml-callback-action");
		params.setHangupOnStar(true);
		params.setMaxParticipants(5L);

		String inboundXml = Response.create()
			.dial(
					Dial.createDial()
					.conference(params)
			)
			.createXml();
		System.out.println(inboundXml);

	}

}
