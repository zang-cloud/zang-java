package com.zang.api.inboundxml.example;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.inboundxml.elements.Gather;
import com.zang.api.inboundxml.elements.Response;

public class GatherExample {
	
	public static void main(String[] args) {
		
		String inboundXml = Response.create()
			.gather(
					Gather.createGather(
							"http://example.com/example-callback-url/say?example=simple.xml", 
							HttpMethod.GET, null, 
							"#", 
							4L)
							.say("Please enter your 4 digit pin.")
					)
			.createXml();
		System.out.println(inboundXml);
		
	}
	
}
