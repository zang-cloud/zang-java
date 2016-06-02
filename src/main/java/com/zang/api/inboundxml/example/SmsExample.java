package com.zang.api.inboundxml.example;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.inboundxml.elements.Response;

public class SmsExample {
	
	public static void main(String[] args) {
		
		String inboundXml = Response.create()
			.sms("Test message sent from Zang!", 
					"(555) 555-5552", 
					"(555) 555-5551", 
					"http://liveoutput.com/zang-test-sms-action", 
					HttpMethod.POST, 
					"http://liveoutput.com/zang-test-status-callback")
			.createXml();
		System.out.println(inboundXml);
		
	}
	
}
