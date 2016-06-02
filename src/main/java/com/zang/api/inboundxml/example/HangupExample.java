package com.zang.api.inboundxml.example;

import com.zang.api.inboundxml.elements.Response;

public class HangupExample {
	
	public static void main(String[] args) {
		
		String inboundXml = Response.create()
			.hangup()
			.createXml();
		System.out.println(inboundXml);
		
	}
	
}
