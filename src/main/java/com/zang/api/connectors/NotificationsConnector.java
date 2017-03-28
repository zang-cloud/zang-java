package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.Notification;
import com.zang.api.domain.enums.LogLevel;
import com.zang.api.domain.list.NotificationsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.NotificationsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;


/**
 * Used for all forms of communication with the Notifications endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class NotificationsConnector extends BaseConnector {

    private NotificationsProxy proxy;

    NotificationsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(NotificationsProxy.class);
    }


    public Notification viewNotification(String accountSid, String notificationSid) throws ZangException {
        return returnThrows(proxy.viewNotification(accountSid, notificationSid), Notification.class);
    }

    public Notification viewNotification(String notificationSid) throws ZangException {
        return viewNotification(conf.getSid(), notificationSid);
    }

    public NotificationsList listNotifications(String accountSid, LogLevel log, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listNotifications(accountSid, log, page, pageSize), NotificationsList.class);
    }

    public NotificationsList listNotifications(LogLevel log, Integer page, Integer pageSize) throws ZangException {
        return listNotifications(conf.getSid(), log, page, pageSize);
    }

    public NotificationsList listNotifications() throws ZangException {
        return listNotifications(conf.getSid(), null, null, null);
    }


}
