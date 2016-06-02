package com.zang.api.inboundxml.example;

import com.zang.api.inboundxml.elements.Dial;
import com.zang.api.inboundxml.elements.Response;

public class SipExample {

	public static void main(String[] args) {
		
		String inboundXml = Response.create()
				.dial(Dial.createDial()
						.sip("username@domain.com")
				).createXml();
		System.out.println(inboundXml);

	}
}
