package com.zang.api.params;

import com.zang.api.domain.enums.HttpMethod;

public class DomainParams {
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

    public static DomainParamsBuilder builder() {
        return new DomainParamsBuilder();
    }

    public DomainParams() {
    }

    public DomainParams(String accountSid, String domainSid, String domainName, String friendlyName, String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl, HttpMethod voiceFallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String voiceStatusCallback, HttpMethod voiceStatusMethod) {
        this.accountSid = accountSid;
        this.domainSid = domainSid;
        this.domainName = domainName;
        this.friendlyName = friendlyName;
        this.voiceUrl = voiceUrl;
        this.voiceMethod = voiceMethod;
        this.voiceFallbackUrl = voiceFallbackUrl;
        this.voiceFallbackMethod = voiceFallbackMethod;
        this.heartbeatUrl = heartbeatUrl;
        this.heartbeatMethod = heartbeatMethod;
        this.voiceStatusCallback = voiceStatusCallback;
        this.voiceStatusMethod = voiceStatusMethod;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getDomainSid() {
        return domainSid;
    }

    public void setDomainSid(String domainSid) {
        this.domainSid = domainSid;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getVoiceUrl() {
        return voiceUrl;
    }

    public void setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
    }

    public HttpMethod getVoiceMethod() {
        return voiceMethod;
    }

    public void setVoiceMethod(HttpMethod voiceMethod) {
        this.voiceMethod = voiceMethod;
    }

    public String getVoiceFallbackUrl() {
        return voiceFallbackUrl;
    }

    public void setVoiceFallbackUrl(String voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
    }

    public HttpMethod getVoiceFallbackMethod() {
        return voiceFallbackMethod;
    }

    public void setVoiceFallbackMethod(HttpMethod voiceFallbackMethod) {
        this.voiceFallbackMethod = voiceFallbackMethod;
    }

    public String getHeartbeatUrl() {
        return heartbeatUrl;
    }

    public void setHeartbeatUrl(String heartbeatUrl) {
        this.heartbeatUrl = heartbeatUrl;
    }

    public HttpMethod getHeartbeatMethod() {
        return heartbeatMethod;
    }

    public void setHeartbeatMethod(HttpMethod heartbeatMethod) {
        this.heartbeatMethod = heartbeatMethod;
    }

    public String getVoiceStatusCallback() {
        return voiceStatusCallback;
    }

    public void setVoiceStatusCallback(String voiceStatusCallback) {
        this.voiceStatusCallback = voiceStatusCallback;
    }

    public HttpMethod getVoiceStatusMethod() {
        return voiceStatusMethod;
    }

    public void setVoiceStatusMethod(HttpMethod voiceStatusMethod) {
        this.voiceStatusMethod = voiceStatusMethod;
    }
}
