package com.zang.api.inboundxml.example;

import com.zang.api.inboundxml.elements.Response;
import com.zang.api.inboundxml.elements.enums.RejectReason;

public class RejectExample {
	
	public static void main(String[] args) {
		
		String inboundXml = Response.create()
			.reject(RejectReason.BUSY)
			.createXml();
		System.out.println(inboundXml);
		
	}
	
}
