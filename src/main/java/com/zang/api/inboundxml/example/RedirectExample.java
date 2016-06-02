package com.zang.api.inboundxml.example;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.inboundxml.elements.Response;

public class RedirectExample {
	
	public static void main(String[] args) {
		
		String inboundXml = Response.create()
			.say("You will now be redirected.")
			.redirect("http://example.com/rest.xml", HttpMethod.POST)
			.say("You will never hear this.")
			.createXml();
		System.out.println(inboundXml);
		
	}
	
}
