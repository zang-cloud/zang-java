package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.Application;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.list.ApplicationsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.ApplicationParams;
import com.zang.api.restproxies.ApplicationsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;


public class ApplicationsConnector extends BaseConnector {

    private ApplicationsProxy proxy;

    ApplicationsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(ApplicationsProxy.class);
    }

    public Application viewApplication(String accountSid, String applicationSid)
            throws ZangException {
        return returnThrows(proxy.viewApplication(accountSid,
                applicationSid), Application.class);
    }

    public Application viewApplication(String applicationSid)
            throws ZangException {
        return viewApplication(conf.getSid(), applicationSid);
    }

    public ApplicationsList listApplications(String accountSid, String friendlyName, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listApplications(accountSid, friendlyName, page, pageSize), ApplicationsList.class);
    }

    public ApplicationsList listApplications(String friendlyName, Integer page, Integer pageSize) throws ZangException {
        return listApplications(conf.getSid(), friendlyName, page, pageSize);
    }
    public ApplicationsList listApplications() throws ZangException {
        return listApplications(conf.getSid(), null, null);
    }

    public Application createApplication(String accountSid, String friendlyName, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, boolean voiceCallerIdLookup, String smsUrl, HttpMethod smsMethod, String smsFallbackUrl, HttpMethod smsFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String statusCallback, HttpMethod statusCallbackMethod, String hangupCallback, HttpMethod hangupCallbackMethod) throws ZangException {
        return returnThrows(proxy.createApplication(accountSid, friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, voiceCallerIdLookup, smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod, heartbeatUrl, heartbeatMethod, statusCallback, statusCallbackMethod, hangupCallback, hangupCallbackMethod), Application.class);
    }

    public Application createApplication(ApplicationParams applicationParams) throws ZangException {
        return createApplication(applicationParams.getAccountSid() != null ? applicationParams.getAccountSid() : conf.getSid(), applicationParams.getFriendlyName(), applicationParams.getVoiceUrl(), applicationParams.getVoiceMethod(), applicationParams.getVoiceFallbackUrl(), applicationParams.getVoiceFallbackMethod(), applicationParams.getVoiceCallerIdLookup(), applicationParams.getSmsUrl(), applicationParams.getSmsMethod(), applicationParams.getSmsFallbackUrl(), applicationParams.getSmsFallbackMethod(), applicationParams.getHeartbeatUrl(), applicationParams.getHeartbeatMethod(), applicationParams.getStatusCallback(), applicationParams.getStatusCallbackMethod(), applicationParams.getHangupCallback(), applicationParams.getHangupCallbackMethod());
    }

    public Application updateApplication(String accountSid, String applicationSid, String friendlyName, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, boolean voiceCallerIdLookup, String smsUrl, HttpMethod smsMethod, String smsFallbackUrl, HttpMethod smsFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String statusCallback, HttpMethod statusCallbackMethod, String hangupCallback, HttpMethod hangupCallbackMethod) throws ZangException {
        return returnThrows(proxy.updateApplication(accountSid, applicationSid, friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, voiceCallerIdLookup, smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod, heartbeatUrl, heartbeatMethod, statusCallback, statusCallbackMethod, hangupCallback, hangupCallbackMethod), Application.class);
    }

    public Application updateApplication(String applicationSid, ApplicationParams applicationParams) throws ZangException {
        return updateApplication(applicationParams.getAccountSid() != null ? applicationParams.getAccountSid() : conf.getSid(), applicationSid, applicationParams.getFriendlyName(), applicationParams.getVoiceUrl(), applicationParams.getVoiceMethod(), applicationParams.getVoiceFallbackUrl(), applicationParams.getVoiceFallbackMethod(), applicationParams.getVoiceCallerIdLookup(), applicationParams.getSmsUrl(), applicationParams.getSmsMethod(), applicationParams.getSmsFallbackUrl(), applicationParams.getSmsFallbackMethod(), applicationParams.getHeartbeatUrl(), applicationParams.getHeartbeatMethod(), applicationParams.getStatusCallback(), applicationParams.getStatusCallbackMethod(), applicationParams.getHangupCallback(), applicationParams.getHangupCallbackMethod());
    }


    public Application deleteApplication(String accountSid, String applicationSid) throws ZangException {
        return returnThrows(proxy.deleteApplication(accountSid, applicationSid), Application.class);
    }

    public Application deleteApplication(String applicationSid) throws ZangException {
        return deleteApplication(conf.getSid(), applicationSid);
    }
}
