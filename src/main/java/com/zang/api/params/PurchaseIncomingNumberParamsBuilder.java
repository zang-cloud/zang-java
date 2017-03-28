package com.zang.api.params;

import com.zang.api.domain.enums.HttpMethod;

/**
 * Utility class for executing the Purchase Incoming Number request
 * @see com.zang.api.connectors.IncomingPhoneNumbersConnector
 * @see PurchaseIncomingNumberParams
 */
public class PurchaseIncomingNumberParamsBuilder {
    private String accountSid;
    private String friendlyName;
    private String phoneNumber;
    private String areaCode;
    private Boolean voiceCallerIdLookup;
    private String voiceApplicationSid;
    private String smsApplicationSid;
    private String voiceUrl;
    private HttpMethod voiceMethod;
    private String voiceFallbackUrl;
    private HttpMethod voiceFallbackMethod;
    private String smsUrl;
    private HttpMethod smsMethod;
    private String smsFallbackUrl;
    private HttpMethod smsFallbackMethod;
    private String heartbeatUrl;
    private HttpMethod heartbeatMethod;
    private String statusCallback;
    private HttpMethod statusCallbackMethod;
    private String hangupCallback;
    private HttpMethod hangupCallbackMethod;

    PurchaseIncomingNumberParamsBuilder() {
    }

    /**
     * Sets accountSid. If left blank the one from the Connector configuration will be used.
     * @param accountSid
     * @return
     */
    public PurchaseIncomingNumberParamsBuilder setAccountSid(String accountSid) {
        this.accountSid = accountSid;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setAreaCode(String areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setVoiceCallerIdLookup(Boolean voiceCallerIdLookup) {
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setVoiceApplicationSid(String voiceApplicationSid) {
        this.voiceApplicationSid = voiceApplicationSid;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setSmsApplicationSid(String smsApplicationSid) {
        this.smsApplicationSid = smsApplicationSid;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setVoiceMethod(HttpMethod voiceMethod) {
        this.voiceMethod = voiceMethod;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setVoiceFallbackUrl(String voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setVoiceFallbackMethod(HttpMethod voiceFallbackMethod) {
        this.voiceFallbackMethod = voiceFallbackMethod;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setSmsUrl(String smsUrl) {
        this.smsUrl = smsUrl;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setSmsMethod(HttpMethod smsMethod) {
        this.smsMethod = smsMethod;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setSmsFallbackUrl(String smsFallbackUrl) {
        this.smsFallbackUrl = smsFallbackUrl;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setSmsFallbackMethod(HttpMethod smsFallbackMethod) {
        this.smsFallbackMethod = smsFallbackMethod;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setHeartbeatUrl(String heartbeatUrl) {
        this.heartbeatUrl = heartbeatUrl;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setHeartbeatMethod(HttpMethod heartbeatMethod) {
        this.heartbeatMethod = heartbeatMethod;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setStatusCallback(String statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setStatusCallbackMethod(HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setHangupCallback(String hangupCallback) {
        this.hangupCallback = hangupCallback;
        return this;
    }

    public PurchaseIncomingNumberParamsBuilder setHangupCallbackMethod(HttpMethod hangupCallbackMethod) {
        this.hangupCallbackMethod = hangupCallbackMethod;
        return this;
    }

    public PurchaseIncomingNumberParams build() {
        return new PurchaseIncomingNumberParams(accountSid, friendlyName, phoneNumber, areaCode, voiceCallerIdLookup, voiceApplicationSid, smsApplicationSid, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod, heartbeatUrl, heartbeatMethod, statusCallback, statusCallbackMethod, hangupCallback, hangupCallbackMethod);
    }
}