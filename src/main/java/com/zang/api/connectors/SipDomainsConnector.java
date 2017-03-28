package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.AccessControlList;
import com.zang.api.domain.CredentialsList;
import com.zang.api.domain.Domain;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.list.AccessControlListsList;
import com.zang.api.domain.list.CredentialsListsList;
import com.zang.api.domain.list.DomainsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.DomainParams;
import com.zang.api.restproxies.SipDomainsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;


/**
 * Used for all forms of communication with the Sip Domains endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class SipDomainsConnector extends BaseConnector {

    private SipDomainsProxy proxy;

    SipDomainsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(SipDomainsProxy.class);
    }
    
    public Domain viewDomain(String accountSid, String domainSid) throws ZangException {
        return returnThrows(proxy.viewDomain(accountSid, domainSid), Domain.class);
    }

    public Domain viewDomain(String domainSid) throws ZangException {
        return viewDomain(conf.getSid(), domainSid);
    }

    
    public DomainsList listDomains(String accountSid) throws ZangException {
        return returnThrows(proxy.listDomains(accountSid), DomainsList.class);
    }

    public DomainsList listDomains() throws ZangException {
        return listDomains(conf.getSid());
    }
    
    public Domain createDomain(String accountSid, String domainName, String friendlyName, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String voiceStatusCallback, HttpMethod voiceStatusMethod) throws ZangException {
        return returnThrows(proxy.createDomain(accountSid, domainName, friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, heartbeatUrl, heartbeatMethod, voiceStatusCallback, voiceStatusMethod), Domain.class);
    }

    public Domain createDomain(String domainName, String friendlyName, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String voiceStatusCallback, HttpMethod voiceStatusMethod) throws ZangException {
        return createDomain(conf.getSid(), friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, heartbeatUrl, heartbeatMethod, voiceStatusCallback, voiceStatusMethod);
    }

    public Domain createDomain(DomainParams params) throws ZangException {
        return createDomain(params.getAccountSid() != null ? params.getAccountSid() : conf.getSid(), params.getDomainName(), params.getFriendlyName(), params.getVoiceUrl(), params.getVoiceMethod(), params.getVoiceFallbackUrl(), params.getVoiceFallbackMethod(), params.getHeartbeatUrl(), params.getHeartbeatMethod(), params.getVoiceStatusCallback(), params.getVoiceStatusMethod());
    }

    
    public Domain updateDomain(String accountSid, String domainSid, String friendlyName, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String voiceStatusCallback, HttpMethod voiceStatusMethod) throws ZangException {
        return returnThrows(proxy.updateDomain(accountSid, domainSid, friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, heartbeatUrl, heartbeatMethod, voiceStatusCallback, voiceStatusMethod), Domain.class);
    }

    public Domain updateDomain(String domainSid, String friendlyName, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String voiceStatusCallback, HttpMethod voiceStatusMethod) throws ZangException {
        return updateDomain(conf.getSid(), domainSid, friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, heartbeatUrl, heartbeatMethod, voiceStatusCallback, voiceStatusMethod);
    }

    public Domain updateDomain(DomainParams params) throws ZangException {
        return updateDomain(params.getAccountSid() != null ? params.getAccountSid() : conf.getSid(), params.getDomainSid(), params.getFriendlyName(), params.getVoiceUrl(), params.getVoiceMethod(), params.getVoiceFallbackUrl(), params.getVoiceFallbackMethod(), params.getHeartbeatUrl(), params.getHeartbeatMethod(), params.getVoiceStatusCallback(), params.getVoiceStatusMethod());
    }

    
    public Domain deleteDomain(String accountSid, String domainSid) throws ZangException {
        return returnThrows(proxy.deleteDomain(accountSid, domainSid), Domain.class);
    }

    public Domain deleteDomain(String domainSid) throws ZangException {
        return deleteDomain(conf.getSid(), domainSid);
    }

    
    public CredentialsListsList listMappedCredentialsLists(String accountSid, String domainSid) throws ZangException {
        return returnThrows(proxy.listMappedCredentialsLists(accountSid, domainSid), CredentialsListsList.class);
    }

    public CredentialsListsList listMappedCredentialsLists(String domainSid) throws ZangException {
        return returnThrows(proxy.listMappedCredentialsLists(conf.getSid(), domainSid), CredentialsListsList.class);
    }

    
    public CredentialsList mapCredentialsLists(String accountSid, String domainSid, String credentialListSid) throws ZangException {
        return returnThrows(proxy.mapCredentialsLists(accountSid, domainSid, credentialListSid), CredentialsList.class);
    }

    public CredentialsList mapCredentialsLists(String domainSid, String credentialListSid) throws ZangException {
        return mapCredentialsLists(conf.getSid(), domainSid, credentialListSid);
    }

    public CredentialsList deleteMappedCredentialsList(String accountSid, String domainSid, String credentialsListSid) throws ZangException {
        return returnThrows(proxy.deleteMappedCredentialsList(accountSid, domainSid, credentialsListSid), CredentialsList.class);
    }

    public CredentialsList deleteMappedCredentialsList(String domainSid, String credentialsListSid) throws ZangException {
        return deleteMappedCredentialsList(conf.getSid(), domainSid, credentialsListSid);
    }
    
    public AccessControlListsList listMappedIpAccessControlLists(String accountSid, String domainSid) throws ZangException {
        return returnThrows(proxy.listMappedIpAccessControlLists(accountSid, domainSid), AccessControlListsList.class);
    }

    public AccessControlListsList listMappedIpAccessControlLists(String domainSid) throws ZangException {
        return listMappedIpAccessControlLists(conf.getSid(), domainSid);
    }

    public AccessControlList mapIpAccessControlList(String accountSid, String domainSid, String ipAccessControlListSid) throws ZangException {
        return returnThrows(proxy.mapIpAccessControlList(accountSid, domainSid, ipAccessControlListSid), AccessControlList.class);
    }

    public AccessControlList mapIpAccessControlList(String domainSid, String ipAccessControlListSid) throws ZangException {
        return mapIpAccessControlList(conf.getSid(), domainSid, ipAccessControlListSid);
    }
    
    public AccessControlList deleteMappedIpAccessControlList(String accountSid, String domainSid, String accessControlListSid) throws ZangException {
        return returnThrows(proxy.deleteMappedIpAccessControlList(accountSid, domainSid, accessControlListSid), AccessControlList.class);
    }

    public AccessControlList deleteMappedIpAccessControlList(String domainSid, String accessControlListSid) throws ZangException {
        return deleteMappedIpAccessControlList(conf.getSid(), domainSid, accessControlListSid);
    }
}
