package com.zang.api.params;

import com.zang.api.domain.enums.HttpMethod;

/**
 * Utility class for executing the Update Incoming Number request
 * @see com.zang.api.connectors.IncomingPhoneNumbersConnector
 * @see UpdateIncomingNumberParams
 */
public class UpdateIncomingNumberParamsBuilder {
    private String accountSid;
    private String incomingPhoneNumberSid;
    private String friendlyName;
    private Boolean voiceCallerIdLookup;
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

    UpdateIncomingNumberParamsBuilder() {
    }

    /**
     * Sets accountSid. If left blank the one from the Connector configuration will be used.
     * @param accountSid
     * @return
     */
    public UpdateIncomingNumberParamsBuilder setAccountSid(String accountSid) {
        this.accountSid = accountSid;
        return this;
    }

    public UpdateIncomingNumberParamsBuilder setIncomingPhoneNumberSid(String incomingPhoneNumberSid) {
        this.incomingPhoneNumberSid = incomingPhoneNumberSid;
        return this;
    }

    public UpdateIncomingNumberParamsBuilder setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public UpdateIncomingNumberParamsBuilder setVoiceCallerIdLookup(Boolean voiceCallerIdLookup) {
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        return this;
    }

    public UpdateIncomingNumberParamsBuilder setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    public UpdateIncomingNumberParamsBuilder setVoiceMethod(HttpMethod voiceMethod) {
        this.voiceMethod = voiceMethod;
        return this;
    }

    public UpdateIncomingNumberParamsBuilder setVoiceFallbackUrl(String voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
        return this;
    }

    public UpdateIncomingNumberParamsBuilder setVoiceFallbackMethod(HttpMethod voiceFallbackMethod) {
        this.voiceFallbackMethod = voiceFallbackMethod;
        return this;
    }

    public UpdateIncomingNumberParamsBuilder setSmsUrl(String smsUrl) {
        this.smsUrl = smsUrl;
        return this;
    }

    public UpdateIncomingNumberParamsBuilder setSmsMethod(HttpMethod smsMethod) {
        this.smsMethod = smsMethod;
        return this;
    }

    public UpdateIncomingNumberParamsBuilder setSmsFallbackUrl(String smsFallbackUrl) {
        this.smsFallbackUrl = smsFallbackUrl;
        return this;
    }

    public UpdateIncomingNumberParamsBuilder setSmsFallbackMethod(HttpMethod smsFallbackMethod) {
        this.smsFallbackMethod = smsFallbackMethod;
        return this;
    }

    public UpdateIncomingNumberParamsBuilder setHeartbeatUrl(String heartbeatUrl) {
        this.heartbeatUrl = heartbeatUrl;
        return this;
    }

    public UpdateIncomingNumberParamsBuilder setHeartbeatMethod(HttpMethod heartbeatMethod) {
        this.heartbeatMethod = heartbeatMethod;
        return this;
    }

    public UpdateIncomingNumberParamsBuilder setStatusCallback(String statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    public UpdateIncomingNumberParamsBuilder setStatusCallbackMethod(HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    public UpdateIncomingNumberParamsBuilder setHangupCallback(String hangupCallback) {
        this.hangupCallback = hangupCallback;
        return this;
    }

    public UpdateIncomingNumberParamsBuilder setHangupCallbackMethod(HttpMethod hangupCallbackMethod) {
        this.hangupCallbackMethod = hangupCallbackMethod;
        return this;
    }

    public UpdateIncomingNumberParams build() {
        return new UpdateIncomingNumberParams(accountSid, incomingPhoneNumberSid, friendlyName, voiceCallerIdLookup, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod, heartbeatUrl, heartbeatMethod, statusCallback, statusCallbackMethod, hangupCallback, hangupCallbackMethod);
    }
}