package com.zang.api;

import java.util.Date;

import org.junit.Test;

import com.zang.api.domain.Call;
import com.zang.api.domain.Recording;
import com.zang.api.domain.list.RecordingList;
import com.zang.api.exceptions.ZangException;

public class RecordingsTest extends BaseZangTest {

	@Test
	public void testListRecordings() throws ZangException {
		RecordingList list = connector.listRecordings(new Date(0), new Date(), 0L, 10L);
		for(Recording r : list) {
			System.out.println(r.getCallSid() + " " + r.getSid());
		}
	}
	
	@Test
	public void testListCallRecordings() throws ZangException {
		Call c = connector.listCalls(null, null, null, null, null, null, null, null).iterator().next();
		RecordingList list = connector.listCallRecordings(c.getSid(), new Date(0), new Date(), 0L, 10L);
		
		for(Recording r : list) {
			System.out.println(r.getCallSid() + " " + r.getSid());
		}
	}
	
	@Test
	public void testViewRecording() throws ZangException {
		RecordingList list = connector.listRecordings(null, null, null, null);
		Recording r = list.iterator().next();
		connector.viewRecording(r.getSid());
	}
	
	@Test
	public void testGetRecordingUrl() throws ZangException {
		RecordingList list = connector.listRecordings(null, null, null, null);
		Recording r = list.iterator().next();
		String url = connector.getRecordingUrl(r.getSid());
		System.out.println(url);
	}
}
