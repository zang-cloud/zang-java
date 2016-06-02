package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.CarrierLookup;
import com.zang.api.domain.list.CarrierLookupList;
import com.zang.api.exceptions.ZangException;

public class CarrierLookupExample {

	public static void main(String[] args) {
		BasicZangConfiguration conf = new BasicZangConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		ZangConnector conn = new ZangConnector(conf);
		
		try {
			CarrierLookupList carrierLookups = conn.carrierLookup("{E_164_number}");
			for (CarrierLookup carrierLookup : carrierLookups) {
				System.out.println(carrierLookup.getSid());
			}
		} catch (ZangException e) {
			e.printStackTrace();
		}
	}
}
