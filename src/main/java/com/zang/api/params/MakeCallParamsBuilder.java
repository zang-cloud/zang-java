package com.zang.api.params;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.enums.IfMachine;

public class MakeCallParamsBuilder {
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

    MakeCallParamsBuilder() {
    }

    public MakeCallParamsBuilder setAccountSid(String accountSid) {
        this.accountSid = accountSid;
        return this;
    }

    public MakeCallParamsBuilder setTo(String to) {
        this.to = to;
        return this;
    }

    public MakeCallParamsBuilder setFrom(String from) {
        this.from = from;
        return this;
    }

    public MakeCallParamsBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public MakeCallParamsBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public MakeCallParamsBuilder setFallbackUrl(String fallbackUrl) {
        this.fallbackUrl = fallbackUrl;
        return this;
    }

    public MakeCallParamsBuilder setFallbackMethod(HttpMethod fallbackMethod) {
        this.fallbackMethod = fallbackMethod;
        return this;
    }

    public MakeCallParamsBuilder setStatusCallback(String statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    public MakeCallParamsBuilder setStatusCallbackMethod(HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    public MakeCallParamsBuilder setHeartbeatUrl(String heartbeatUrl) {
        this.heartbeatUrl = heartbeatUrl;
        return this;
    }

    public MakeCallParamsBuilder setHeartbeatMethod(HttpMethod heartbeatMethod) {
        this.heartbeatMethod = heartbeatMethod;
        return this;
    }

    public MakeCallParamsBuilder setForwardedFrom(String forwardedFrom) {
        this.forwardedFrom = forwardedFrom;
        return this;
    }

    public MakeCallParamsBuilder setPlayDtmf(String playDtmf) {
        this.playDtmf = playDtmf;
        return this;
    }

    public MakeCallParamsBuilder setTimeout(Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    public MakeCallParamsBuilder setHideCallerId(Boolean hideCallerId) {
        this.hideCallerId = hideCallerId;
        return this;
    }

    public MakeCallParamsBuilder setRecord(Boolean record) {
        this.record = record;
        return this;
    }

    public MakeCallParamsBuilder setRecordCallback(String recordCallback) {
        this.recordCallback = recordCallback;
        return this;
    }

    public MakeCallParamsBuilder setRecordCallbackMethod(HttpMethod recordCallbackMethod) {
        this.recordCallbackMethod = recordCallbackMethod;
        return this;
    }

    public MakeCallParamsBuilder setTranscribe(Boolean transcribe) {
        this.transcribe = transcribe;
        return this;
    }

    public MakeCallParamsBuilder setTranscribeCallback(String transcribeCallback) {
        this.transcribeCallback = transcribeCallback;
        return this;
    }

    public MakeCallParamsBuilder setStraightToVoicemail(Boolean straightToVoicemail) {
        this.straightToVoicemail = straightToVoicemail;
        return this;
    }

    public MakeCallParamsBuilder setIfMachine(IfMachine ifMachine) {
        this.ifMachine = ifMachine;
        return this;
    }

    public MakeCallParamsBuilder setIfMachineUrl(String ifMachineUrl) {
        this.ifMachineUrl = ifMachineUrl;
        return this;
    }

    public MakeCallParamsBuilder setIfMachineMethod(HttpMethod ifMachineMethod) {
        this.ifMachineMethod = ifMachineMethod;
        return this;
    }

    public MakeCallParamsBuilder setSipAuthUsername(String sipAuthUsername) {
        this.sipAuthUsername = sipAuthUsername;
        return this;
    }

    public MakeCallParamsBuilder setSipAuthPassword(String sipAuthPassword) {
        this.sipAuthPassword = sipAuthPassword;
        return this;
    }

    public MakeCallParams build() {
        return new MakeCallParams(accountSid, to, from, url, method, fallbackUrl, fallbackMethod, statusCallback, statusCallbackMethod, heartbeatUrl, heartbeatMethod, forwardedFrom, playDtmf, timeout, hideCallerId, record, recordCallback, recordCallbackMethod, transcribe, transcribeCallback, straightToVoicemail, ifMachine, ifMachineUrl, ifMachineMethod, sipAuthUsername, sipAuthPassword);
    }
}