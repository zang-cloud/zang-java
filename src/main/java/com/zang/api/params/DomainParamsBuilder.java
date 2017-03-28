package com.zang.api.params;

import com.zang.api.domain.enums.HttpMethod;

/**
 * Utility class for communicating with the Sip Domains endpoint.
 * @see com.zang.api.connectors.SipDomainsConnector
 * @see DomainParams
 */
public class DomainParamsBuilder {
    private String accountSid;
    private String domainSid;
    private String domainName;
    private String friendlyName;
    private String voiceUrl;
    private HttpMethod voiceMethod;
    private String voiceFallbackUrl;
    private HttpMethod voiceFallbackMethod;
    private String heartbeatUrl;
    private HttpMethod heartbeatMethod;
    private String voiceStatusCallback;
    private HttpMethod voiceStatusMethod;

    DomainParamsBuilder() {

    }

    public DomainParamsBuilder setAccountSid(String accountSid) {
        this.accountSid = accountSid;
        return this;
    }

    public DomainParamsBuilder setDomainSid(String domainSid) {
        this.domainSid = domainSid;
        return this;
    }

    public DomainParamsBuilder setDomainName(String domainName) {
        this.domainName = domainName;
        return this;
    }

    public DomainParamsBuilder setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public DomainParamsBuilder setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    public DomainParamsBuilder setVoiceMethod(HttpMethod voiceMethod) {
        this.voiceMethod = voiceMethod;
        return this;
    }

    public DomainParamsBuilder setVoiceFallbackUrl(String voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
        return this;
    }

    public DomainParamsBuilder setVoiceFallbackMethod(HttpMethod voiceFallbackMethod) {
        this.voiceFallbackMethod = voiceFallbackMethod;
        return this;
    }

    public DomainParamsBuilder setHeartbeatUrl(String heartbeatUrl) {
        this.heartbeatUrl = heartbeatUrl;
        return this;
    }

    public DomainParamsBuilder setHeartbeatMethod(HttpMethod heartbeatMethod) {
        this.heartbeatMethod = heartbeatMethod;
        return this;
    }

    public DomainParamsBuilder setVoiceStatusCallback(String voiceStatusCallback) {
        this.voiceStatusCallback = voiceStatusCallback;
        return this;
    }

    public DomainParamsBuilder setVoiceStatusMethod(HttpMethod voiceStatusMethod) {
        this.voiceStatusMethod = voiceStatusMethod;
        return this;
    }

    public DomainParams build() {
        return new DomainParams(accountSid, domainSid, domainName, friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod, heartbeatUrl, heartbeatMethod, voiceStatusCallback, voiceStatusMethod);
    }
}