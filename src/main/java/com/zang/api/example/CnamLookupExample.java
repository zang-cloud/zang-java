package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.CnamDip;
import com.zang.api.domain.list.CnamDipList;
import com.zang.api.exceptions.ZangException;

public class CnamLookupExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			CnamDipList cnamList = conn.cnamLookup("{E_164_number}");
			for(CnamDip cnamDip : cnamList) {
				System.out.println(cnamDip.getSid());
			}
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
