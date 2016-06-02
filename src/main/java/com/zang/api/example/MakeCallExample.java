package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.Call;
import com.zang.api.exceptions.ZangException;
import com.zang.api.requests.CallRequest;

public class MakeCallExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			CallRequest callRequest = new CallRequest();
			callRequest.setFrom("(XXX) XXX-XXXX");
			callRequest.setTo("(XXX) XXX-XXXX");
			callRequest.setUrl("http://liveoutput.com/createnewcall");
			Call call = conn.makeCall(callRequest);
			System.out.println(call.getSid());
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
