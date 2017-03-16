package com.zang.api.requests;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.enums.IfMachine;

public class CallRequestBuilder {
    private String accountSid;
    private String to;
    private String from;
    private String url;
    private HttpMethod method;
    private String fallbackUrl;
    private HttpMethod fallbackMethod;
    private String statusCallback;
    private HttpMethod statusCallbackMethod;
    private String heartbeatUrl;
    private HttpMethod heartbeatMethod;
    private String forwardedFrom;
    private String playDtmf;
    private Integer timeout;
    private Boolean hideCallerId;
    private Boolean record;
    private String recordCallback;
    private HttpMethod recordCallbackMethod;
    private Boolean transcribe;
    private String transcribeCallback;
    private Boolean straightToVoicemail;
    private IfMachine ifMachine;
    private String ifMachineUrl;
    private HttpMethod ifMachineMethod;
    private String sipAuthUsername;
    private String sipAuthPassword;

    CallRequestBuilder() {
    }

    public CallRequestBuilder setAccountSid(String accountSid) {
        this.accountSid = accountSid;
        return this;
    }

    public CallRequestBuilder setTo(String to) {
        this.to = to;
        return this;
    }

    public CallRequestBuilder setFrom(String from) {
        this.from = from;
        return this;
    }

    public CallRequestBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public CallRequestBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public CallRequestBuilder setFallbackUrl(String fallbackUrl) {
        this.fallbackUrl = fallbackUrl;
        return this;
    }

    public CallRequestBuilder setFallbackMethod(HttpMethod fallbackMethod) {
        this.fallbackMethod = fallbackMethod;
        return this;
    }

    public CallRequestBuilder setStatusCallback(String statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    public CallRequestBuilder setStatusCallbackMethod(HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    public CallRequestBuilder setHeartbeatUrl(String heartbeatUrl) {
        this.heartbeatUrl = heartbeatUrl;
        return this;
    }

    public CallRequestBuilder setHeartbeatMethod(HttpMethod heartbeatMethod) {
        this.heartbeatMethod = heartbeatMethod;
        return this;
    }

    public CallRequestBuilder setForwardedFrom(String forwardedFrom) {
        this.forwardedFrom = forwardedFrom;
        return this;
    }

    public CallRequestBuilder setPlayDtmf(String playDtmf) {
        this.playDtmf = playDtmf;
        return this;
    }

    public CallRequestBuilder setTimeout(Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    public CallRequestBuilder setHideCallerId(Boolean hideCallerId) {
        this.hideCallerId = hideCallerId;
        return this;
    }

    public CallRequestBuilder setRecord(Boolean record) {
        this.record = record;
        return this;
    }

    public CallRequestBuilder setRecordCallback(String recordCallback) {
        this.recordCallback = recordCallback;
        return this;
    }

    public CallRequestBuilder setRecordCallbackMethod(HttpMethod recordCallbackMethod) {
        this.recordCallbackMethod = recordCallbackMethod;
        return this;
    }

    public CallRequestBuilder setTranscribe(Boolean transcribe) {
        this.transcribe = transcribe;
        return this;
    }

    public CallRequestBuilder setTranscribeCallback(String transcribeCallback) {
        this.transcribeCallback = transcribeCallback;
        return this;
    }

    public CallRequestBuilder setStraightToVoicemail(Boolean straightToVoicemail) {
        this.straightToVoicemail = straightToVoicemail;
        return this;
    }

    public CallRequestBuilder setIfMachine(IfMachine ifMachine) {
        this.ifMachine = ifMachine;
        return this;
    }

    public CallRequestBuilder setIfMachineUrl(String ifMachineUrl) {
        this.ifMachineUrl = ifMachineUrl;
        return this;
    }

    public CallRequestBuilder setIfMachineMethod(HttpMethod ifMachineMethod) {
        this.ifMachineMethod = ifMachineMethod;
        return this;
    }

    public CallRequestBuilder setSipAuthUsername(String sipAuthUsername) {
        this.sipAuthUsername = sipAuthUsername;
        return this;
    }

    public CallRequestBuilder setSipAuthPassword(String sipAuthPassword) {
        this.sipAuthPassword = sipAuthPassword;
        return this;
    }

    public CallRequest build() {
        return new CallRequest(accountSid, to, from, url, method, fallbackUrl, fallbackMethod, statusCallback, statusCallbackMethod, heartbeatUrl, heartbeatMethod, forwardedFrom, playDtmf, timeout, hideCallerId, record, recordCallback, recordCallbackMethod, transcribe, transcribeCallback, straightToVoicemail, ifMachine, ifMachineUrl, ifMachineMethod, sipAuthUsername, sipAuthPassword);
    }
}