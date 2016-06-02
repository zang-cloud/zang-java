package com.zang.api.inboundxml.example;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.inboundxml.elements.Dial;
import com.zang.api.inboundxml.elements.Response;
import com.zang.api.inboundxml.parameters.DialParameters;

public class DialExample {
	
	public static void main(String[] args) {
		DialParameters params = new DialParameters();
		params.setNumber("(555) 724-2212");
		params.setAction("http://liveoutput.com/zang-inboundxml-dial-sample");
		params.setMethod(HttpMethod.GET);
		String inboundXml = Response.create()
			.dial(Dial.createDial(params)
					)
			.createXml();
		System.out.println(inboundXml);
		
	}
	
}
