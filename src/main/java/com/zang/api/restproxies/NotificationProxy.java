package com.zang.api.restproxies;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.zang.api.domain.Notification;
import com.zang.api.domain.enums.LogLevel;
import com.zang.api.domain.list.NotificationList;

public interface NotificationProxy {

	@GET
	@Path("Accounts/{AccountSid}/Notifications/{NotificationSid}.json")
	@Produces("application/json")
	ClientResponse<Notification> viewNotification(
			@PathParam("AccountSid") String accountSid,
			@PathParam("NotificationSid") String notificationSid
			);
	
	@GET
	@Path("Accounts/{AccountSid}/Notifications.json")
	@Produces("application/json")
	ClientResponse<NotificationList> listNotifications(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="Log") LogLevel log,
			@QueryParam(value="Page") Long page,
    		@QueryParam(value="PageSize") Long pageSize
			);
	
	@GET
	@Path("Accounts/{AccountSid}/Calls/{CallSid}/Notifications.json")
	@Produces("application/json")
	ClientResponse<NotificationList> listCallNotifications(
			@PathParam("AccountSid") String accountSid,
			@PathParam("CallSid") String callSid,
			@QueryParam(value="Log") LogLevel log,
			@QueryParam(value="Page") Long page,
    		@QueryParam(value="PageSize") Long pageSize
			);
}
