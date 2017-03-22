package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.IncomingPhoneNumber;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.list.IncomingPhoneNumbersList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.PurchaseIncomingNumberParams;
import com.zang.api.params.UpdateIncomingNumberParams;
import com.zang.api.restproxies.IncomingPhoneNumbersProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;


public class IncomingPhoneNumbersConnector extends BaseConnector {

    private IncomingPhoneNumbersProxy proxy;

    IncomingPhoneNumbersConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(IncomingPhoneNumbersProxy.class);
    }


    public IncomingPhoneNumber viewIncomingNumber(String accountSid, String incomingPhoneNumberSid) throws ZangException {
        return returnThrows(proxy.viewIncomingNumber(accountSid, incomingPhoneNumberSid), IncomingPhoneNumber.class);
    }

    public IncomingPhoneNumber viewIncomingNumber(String incomingPhoneNumberSid) throws ZangException {
        return viewIncomingNumber(conf.getSid(), incomingPhoneNumberSid);
    }


    public IncomingPhoneNumbersList listIncomingNumbers(String accountSid, String contains, String friendlyName, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listIncomingNumbers(accountSid, contains, friendlyName, page, pageSize), IncomingPhoneNumbersList.class);
    }

    public IncomingPhoneNumbersList listIncomingNumbers(String contains, String friendlyName, Integer page, Integer pageSize) throws ZangException {
        return listIncomingNumbers(conf.getSid(), contains, friendlyName, page, pageSize);
    }


    public IncomingPhoneNumber purchaseIncomingNumber(String accountSid, String friendlyName, String phoneNumber, String areaCode, Boolean voiceCallerIdLookup, String voiceApplicationSid, String smsApplicationSid, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, String smsUrl, HttpMethod smsMethod, String smsFallbackUrl, HttpMethod smsFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String statusCallback, HttpMethod statusCallbackMethod, String hangupCallback, HttpMethod hangupCallbackMethod) throws ZangException {
        return returnThrows(proxy.purchaseIncomingNumber(accountSid, friendlyName, phoneNumber, areaCode, voiceCallerIdLookup, voiceApplicationSid, smsApplicationSid, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod, heartbeatUrl, heartbeatMethod, statusCallback, statusCallbackMethod, hangupCallback, hangupCallbackMethod), IncomingPhoneNumber.class);
    }

    public IncomingPhoneNumber purchaseIncomingNumber(String friendlyName, String phoneNumber, String areaCode, Boolean voiceCallerIdLookup, String voiceApplicationSid, String smsApplicationSid, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, String smsUrl, HttpMethod smsMethod, String smsFallbackUrl, HttpMethod smsFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String statusCallback, HttpMethod statusCallbackMethod, String hangupCallback, HttpMethod hangupCallbackMethod) throws ZangException {
        return purchaseIncomingNumber(conf.getSid(), friendlyName, phoneNumber, areaCode, voiceCallerIdLookup, voiceApplicationSid, smsApplicationSid, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod, heartbeatUrl, heartbeatMethod, statusCallback, statusCallbackMethod, hangupCallback, hangupCallbackMethod);
    }

    public IncomingPhoneNumber purchaseIncomingNumber(PurchaseIncomingNumberParams params) throws ZangException {
        return purchaseIncomingNumber(params.getAccountSid() != null ? params.getAccountSid() : conf.getSid(), params.getFriendlyName(), params.getPhoneNumber(), params.getAreaCode(), params.getVoiceCallerIdLookup(), params.getVoiceApplicationSid(), params.getSmsApplicationSid(), params.getVoiceUrl(), params.getVoiceMethod(), params.getVoiceFallbackUrl(), params.getVoiceFallbackMethod(), params.getSmsUrl(), params.getSmsMethod(), params.getSmsFallbackUrl(), params.getSmsFallbackMethod(), params.getHeartbeatUrl(), params.getHeartbeatMethod(), params.getStatusCallback(), params.getStatusCallbackMethod(), params.getHangupCallback(), params.getHangupCallbackMethod());
    }


    public IncomingPhoneNumber updateIncomingNumber(String accountSid, String incomingPhoneNumberSid, String friendlyName, Boolean voiceCallerIdLookup, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, String smsUrl, HttpMethod smsMethod, String smsFallbackUrl, HttpMethod smsFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String statusCallback, HttpMethod statusCallbackMethod, String hangupCallback, HttpMethod hangupCallbackMethod) throws ZangException {
        return returnThrows(proxy.updateIncomingNumber(accountSid, incomingPhoneNumberSid, friendlyName, voiceCallerIdLookup, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod, heartbeatUrl, heartbeatMethod, statusCallback, statusCallbackMethod, hangupCallback, hangupCallbackMethod), IncomingPhoneNumber.class);
    }

    public IncomingPhoneNumber updateIncomingNumber(String incomingPhoneNumberSid, String friendlyName, Boolean voiceCallerIdLookup, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, String smsUrl, HttpMethod smsMethod, String smsFallbackUrl, HttpMethod smsFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String statusCallback, HttpMethod statusCallbackMethod, String hangupCallback, HttpMethod hangupCallbackMethod) throws ZangException {
        return updateIncomingNumber(conf.getSid(), incomingPhoneNumberSid, friendlyName, voiceCallerIdLookup, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod, heartbeatUrl, heartbeatMethod, statusCallback, statusCallbackMethod, hangupCallback, hangupCallbackMethod);
    }

    public IncomingPhoneNumber updateIncomingNumber(UpdateIncomingNumberParams params) throws ZangException {
        return updateIncomingNumber(params.getAccountSid() != null ? params.getAccountSid() : conf.getSid(), params.getIncomingPhoneNumberSid(), params.getFriendlyName(), params.getVoiceCallerIdLookup(), params.getVoiceUrl(), params.getVoiceMethod(), params.getVoiceFallbackUrl(), params.getVoiceFallbackMethod(), params.getSmsUrl(), params.getSmsMethod(), params.getSmsFallbackUrl(), params.getSmsFallbackMethod(), params.getHeartbeatUrl(), params.getHeartbeatMethod(), params.getStatusCallback(), params.getStatusCallbackMethod(), params.getHangupCallback(), params.getHangupCallbackMethod());
    }

    public IncomingPhoneNumber deleteIncomingNumber(String accountSid, String incomingPhoneNumberSid) throws ZangException {
        return returnThrows(proxy.deleteIncomingNumber(accountSid, incomingPhoneNumberSid), IncomingPhoneNumber.class);
    }

    public IncomingPhoneNumber deleteIncomingNumber(String incomingPhoneNumberSid) throws ZangException {
        return deleteIncomingNumber(conf.getSid(), incomingPhoneNumberSid);
    }
}
