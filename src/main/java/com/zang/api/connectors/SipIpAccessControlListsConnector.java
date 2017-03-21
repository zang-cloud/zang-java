package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.AccessControlList;
import com.zang.api.domain.IpAddress;
import com.zang.api.domain.list.AccessControlListsList;
import com.zang.api.domain.list.IpAddressesList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.SipIpAccessControlListsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;


public class SipIpAccessControlListsConnector extends BaseConnector {

    private SipIpAccessControlListsProxy sipIpAccessControlListsProxy;

    SipIpAccessControlListsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        sipIpAccessControlListsProxy = createProxy(SipIpAccessControlListsProxy.class);
    }


    
    public AccessControlList viewIpAccessControlList(String accountSid, String ipAccessControlListSid) throws ZangException {
        return returnThrows(sipIpAccessControlListsProxy.viewIpAccessControlList(accountSid, ipAccessControlListSid), AccessControlList.class);
    }

    public AccessControlList viewIpAccessControlList(String ipAccessControlListSid) throws ZangException {
        return viewIpAccessControlList(conf.getSid(), ipAccessControlListSid);
    }

    
    public AccessControlListsList listIpAccessControlLists(String accountSid, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(sipIpAccessControlListsProxy.listIpAccessControlLists(accountSid, page, pageSize), AccessControlListsList.class);
    }

    public AccessControlListsList listIpAccessControlLists(Integer page, Integer pageSize) throws ZangException {
        return listIpAccessControlLists(conf.getSid(), page, pageSize);
    }

    
    public AccessControlList createIpAccessControlList(String accountSid,  String friendlyName) throws ZangException {
        return returnThrows(sipIpAccessControlListsProxy.createIpAccessControlList(accountSid, friendlyName), AccessControlList.class);
    }

    public AccessControlList createIpAccessControlList(String friendlyName) throws ZangException {
        return createIpAccessControlList(conf.getSid(), friendlyName);
    }

    
    public AccessControlList updateIpAccessControlList(String accountSid, String ipAccessControlListSid,  String friendlyName) throws ZangException {
        return returnThrows(sipIpAccessControlListsProxy.updateIpAccessControlList(accountSid, ipAccessControlListSid, friendlyName), AccessControlList.class);
    }

    public AccessControlList updateIpAccessControlList(String ipAccessControlListSid,  String friendlyName) throws ZangException {
        return updateIpAccessControlList(conf.getSid(), ipAccessControlListSid, friendlyName);
    }

    
    public AccessControlList deleteIpAccessControlList(String accountSid, String ipAccessControlListSid) throws ZangException {
        return returnThrows(sipIpAccessControlListsProxy.deleteIpAccessControlList(accountSid, ipAccessControlListSid), AccessControlList.class);
    }

    public AccessControlList deleteIpAccessControlList(String ipAccessControlListSid) throws ZangException {
        return deleteIpAccessControlList(conf.getSid(), ipAccessControlListSid);
    }

    
    public IpAddress viewAccessControlListIp(String accountSid, String ipAccessControlListSid, String ipSid) throws ZangException {
        return returnThrows(sipIpAccessControlListsProxy.viewAccessControlListIp(accountSid, ipAccessControlListSid, ipSid), IpAddress.class);
    }

    public IpAddress viewAccessControlListIp(String ipAccessControlListSid, String ipSid) throws ZangException {
        return viewAccessControlListIp(conf.getSid(), ipAccessControlListSid, ipSid);
    }

    
    public IpAddressesList listAccessControlListIps(String accountSid, String ipAccessControlListSid) throws ZangException {
        return returnThrows(sipIpAccessControlListsProxy.listAccessControlListIps(accountSid, ipAccessControlListSid), IpAddressesList.class);
    }

    public IpAddressesList listAccessControlListIps(String ipAccessControlListSid) throws ZangException {
        return listAccessControlListIps(conf.getSid(), ipAccessControlListSid);
    }

    
    public IpAddress addAccessControlListIp(String accountSid, String ipAccessControlListSid,  String friendlyName,  String ipAddress) throws ZangException {
        return returnThrows(sipIpAccessControlListsProxy.addAccessControlListIp(accountSid, ipAccessControlListSid, friendlyName, ipAddress), IpAddress.class);
    }

    public IpAddress addAccessControlListIp(String ipAccessControlListSid,  String friendlyName,  String ipAddress) throws ZangException {
        return addAccessControlListIp(conf.getSid(), ipAccessControlListSid, friendlyName, ipAddress);
    }

    
    public IpAddress updateAccessControlListIp(String accountSid, String ipAccessControlListSid, String ipSid,  String friendlyName,  String ipAddress) throws ZangException {
        return returnThrows(sipIpAccessControlListsProxy.updateAccessControlListIp(accountSid, ipAccessControlListSid, ipSid, friendlyName, ipAddress), IpAddress.class);
    }

    public IpAddress updateAccessControlListIp(String ipAccessControlListSid, String ipSid,  String friendlyName,  String ipAddress) throws ZangException {
        return updateAccessControlListIp(conf.getSid(), ipAccessControlListSid, ipSid, friendlyName, ipAddress);
    }

    
    public IpAddress deleteAccessControlListIp(String accountSid, String ipAccessControlListSid, String ipSid) throws ZangException {
        return returnThrows(sipIpAccessControlListsProxy.deleteAccessControlListIp(accountSid, ipAccessControlListSid, ipSid), IpAddress.class);
    }

    public IpAddress deleteAccessControlListIp(String ipAccessControlListSid, String ipSid) throws ZangException {
        return deleteAccessControlListIp(conf.getSid(), ipAccessControlListSid, ipSid);
    }
}
