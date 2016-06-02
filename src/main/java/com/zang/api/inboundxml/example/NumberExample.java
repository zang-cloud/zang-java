package com.zang.api.inboundxml.example;

import com.zang.api.inboundxml.elements.Dial;
import com.zang.api.inboundxml.elements.Response;

public class NumberExample {
	
	public static void main(String[] args) {
		
		String inboundXml = Response.create()
			.dial(Dial.createDial().
					number("(555) 555-5555", "ww12w3221", null, null)
					)
			.createXml();
		System.out.println(inboundXml);
		
	}
	
}
