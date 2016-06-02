package com.zang.api;

import org.junit.Assert;
import org.junit.Test;

import com.zang.api.domain.Application;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.list.ApplicationList;
import com.zang.api.exceptions.ZangException;

public class ApplicationTest extends BaseZangTest {
	
	@Test
	public void testCreateApplication() throws ZangException {
		Application app = connector.createApplication("my_app", "www.google.com", HttpMethod.GET, "voicefallback.com", 
				HttpMethod.POST, true, "smsurl.com", HttpMethod.GET, "smsfallback.com", HttpMethod.GET, "heartbeat.com", HttpMethod.GET, "hangupcallback.com", HttpMethod.POST);
		
		Assert.assertEquals("heartbeat.com", app.getHeartbeatUrl());
		Assert.assertEquals("my_app", app.getFriendlyName());
		connector.deleteApplication(app.getSid());
	}
	
	@Test
	public void testListApplications() throws ZangException {
		Application app = connector.createApplication("my_app", "www.google.com", HttpMethod.GET, null, 
				null, null, null, null, null, null, "heartbeat.com", HttpMethod.GET, null, null);
		
		
		ApplicationList list = connector.listApplications("my_app", 0L, 10L);
		
		boolean found = false;
		for(Application lApp : list) {
			if (lApp.getSid().equals(app.getSid())) {
				found = true;
				break;
			}
		}
		Assert.assertTrue(found);
	}
	
	@Test
	public void testViewApplication() throws ZangException {
		Application app = connector.createApplication("my_app", "www.google.com", HttpMethod.GET, null, 
				null, null, null, null, null, null, "heartbeat.com", HttpMethod.GET, null, null);
		
		Application vApp = connector.viewApplication(app.getSid());
		
		Assert.assertEquals(app.getSid(), vApp.getSid());
		Assert.assertEquals("heartbeat.com", vApp.getHeartbeatUrl());
		Assert.assertEquals("my_app", vApp.getFriendlyName());
		connector.deleteApplication(app.getSid());
	}
	
	@Test
	public void testUpdateApplication() throws ZangException {
		Application app = connector.createApplication("my_app", "www.google.com", HttpMethod.GET, null, 
				null, null, null, null, null, null, "heartbeat.com", HttpMethod.GET, null, null);
		
		Assert.assertEquals("heartbeat.com", app.getHeartbeatUrl());
		Assert.assertEquals(HttpMethod.GET, app.getHeartbeatMethod());
		
		Application uApp = connector.updateApplication(app.getSid(), 
				"my_app", "www.google.com", HttpMethod.GET, "voicefallback.com", 
				HttpMethod.POST, true, "smsurl.com", HttpMethod.GET, "smsfallback.com", HttpMethod.GET, "nobeat.com", HttpMethod.POST, "hangupcallback.com", HttpMethod.POST);
		
		Application vApp = connector.viewApplication(uApp.getSid());
		
		Assert.assertEquals(vApp.getSid(), app.getSid());
		Assert.assertEquals("nobeat.com", vApp.getHeartbeatUrl());
		Assert.assertEquals(HttpMethod.POST, vApp.getHeartbeatMethod());
		connector.deleteApplication(app.getSid());
	}
	
	@Test
	public void testDeleteApplication() throws ZangException {
		Application app = connector.createApplication("my_app", "www.google.com", HttpMethod.GET, null, 
				null, null, null, null, null, null, "heartbeat.com", HttpMethod.GET, null, null);
		
		connector.deleteApplication(app.getSid());
		
		ApplicationList list = connector.listApplications(null, null, null);

		for(Application lApp : list) {
			if (lApp.getSid().equals(app.getSid())) {
				Assert.fail("Application wasn't deleted.");
			}
		}
	}
	
	@Test
	public void testDeleteAllApplications() throws ZangException {
		ApplicationList list = connector.listApplications(null, null, null);

		for(Application app : list) {
			connector.deleteApplication(app.getSid());
		}
	}
}
