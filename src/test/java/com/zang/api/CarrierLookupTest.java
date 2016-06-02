package com.zang.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zang.api.domain.list.CarrierLookupList;
import com.zang.api.domain.list.CnamDipList;
import com.zang.api.exceptions.ZangException;

public class CarrierLookupTest extends BaseZangTest {
	
	@Test
	public void testCarrierLookup() throws ZangException {
		CarrierLookupList lookuplist = connector.carrierLookup(testParameters.getPhone1());
		System.out.println(lookuplist.getTotal());
		
	}
	
	@Test
	public void testCnamLookup() throws ZangException {
		CnamDipList lookup = connector.cnamLookup(testParameters.getPhone1());
		System.out.println(lookup.getTotal());
	}
	
	
	@Test
	public void testCnamLookupMany() throws ZangException {
		List<String> lookupNumbers = new ArrayList<String>();
		lookupNumbers.add(testParameters.getPhone1());
		lookupNumbers.add(testParameters.getPhone2());
		CnamDipList lookup = connector.cnamLookup(lookupNumbers);
		System.out.println(lookup.getTotal());
	}
	
}
