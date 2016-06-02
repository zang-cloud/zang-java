package com.zang.api.inboundxml.example;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.inboundxml.elements.Response;
import com.zang.api.inboundxml.elements.enums.Voice;
import com.zang.api.inboundxml.parameters.RecordParameters;

public class RecordExample {
	
	public static void main(String[] args) {

		RecordParameters params = new RecordParameters("http://liveoutput.com/zang-telml-recording-action-example");
		params.setMethod(HttpMethod.POST);
		
		String inboundXml = Response.create()
			.say("Please state your name.", Voice.MAN, 3L)
			.record(params)
			.createXml();
		
		System.out.println(inboundXml);

	}
	
}
