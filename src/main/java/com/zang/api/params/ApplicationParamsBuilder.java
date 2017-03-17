package com.zang.api.params;

import com.zang.api.domain.enums.HttpMethod;

public class ApplicationParamsBuilder {
    private String accountSid;
    private String friendlyName;
    private String voiceUrl;
    private HttpMethod voiceMethod;
    private String voiceFallbackUrl;
    private HttpMethod voiceFallbackMethod;
    private Boolean voiceCallerIdLookup;
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

    ApplicationParamsBuilder() {
    }

    public ApplicationParamsBuilder setAccountSid(String accountSid) {
        this.accountSid = accountSid;
        return this;
    }

    public ApplicationParamsBuilder setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public ApplicationParamsBuilder setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    public ApplicationParamsBuilder setVoiceMethod(HttpMethod voiceMethod) {
        this.voiceMethod = voiceMethod;
        return this;
    }

    public ApplicationParamsBuilder setVoiceFallbackUrl(String voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
        return this;
    }

    public ApplicationParamsBuilder setVoiceFallbackMethod(HttpMethod voiceFallbackMethod) {
        this.voiceFallbackMethod = voiceFallbackMethod;
        return this;
    }

    public ApplicationParamsBuilder setVoiceCallerIdLookup(Boolean voiceCallerIdLookup) {
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        return this;
    }

    public ApplicationParamsBuilder setSmsUrl(String smsUrl) {
        this.smsUrl = smsUrl;
        return this;
    }

    public ApplicationParamsBuilder setSmsMethod(HttpMethod smsMethod) {
        this.smsMethod = smsMethod;
        return this;
    }

    public ApplicationParamsBuilder setSmsFallbackUrl(String smsFallbackUrl) {
        this.smsFallbackUrl = smsFallbackUrl;
        return this;
    }

    public ApplicationParamsBuilder setSmsFallbackMethod(HttpMethod smsFallbackMethod) {
        this.smsFallbackMethod = smsFallbackMethod;
        return this;
    }

    public ApplicationParamsBuilder setHeartbeatUrl(String heartbeatUrl) {
        this.heartbeatUrl = heartbeatUrl;
        return this;
    }

    public ApplicationParamsBuilder setHeartbeatMethod(HttpMethod heartbeatMethod) {
        this.heartbeatMethod = heartbeatMethod;
        return this;
    }

    public ApplicationParamsBuilder setStatusCallback(String statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    public ApplicationParamsBuilder setStatusCallbackMethod(HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    public ApplicationParamsBuilder setHangupCallback(String hangupCallback) {
        this.hangupCallback = hangupCallback;
        return this;
    }

    public ApplicationParamsBuilder setHangupCallbackMethod(HttpMethod hangupCallbackMethod) {
        this.hangupCallbackMethod = hangupCallbackMethod;
        return this;
    }

    public ApplicationParams build() {
        return new ApplicationParams(accountSid, friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, voiceCallerIdLookup, smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod, heartbeatUrl, heartbeatMethod, statusCallback, statusCallbackMethod, hangupCallback, hangupCallbackMethod);
    }
}