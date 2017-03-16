package com.zang.api.requests;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.enums.IfMachine;

public class CallRequest {

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

    public static CallRequestBuilder builder() {
        return new CallRequestBuilder();
    }

    public CallRequest() {
    }

    public CallRequest(String accountSid, String to, String from, String url, HttpMethod method, String fallbackUrl, HttpMethod fallbackMethod, String statusCallback, HttpMethod statusCallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String forwardedFrom, String playDtmf, Integer timeout, Boolean hideCallerId, Boolean record, String recordCallback, HttpMethod recordCallbackMethod, Boolean transcribe, String transcribeCallback, Boolean straightToVoicemail, IfMachine ifMachine, String ifMachineUrl, HttpMethod ifMachineMethod, String sipAuthUsername, String sipAuthPassword) {
        this.accountSid = accountSid;
        this.to = to;
        this.from = from;
        this.url = url;
        this.method = method;
        this.fallbackUrl = fallbackUrl;
        this.fallbackMethod = fallbackMethod;
        this.statusCallback = statusCallback;
        this.statusCallbackMethod = statusCallbackMethod;
        this.heartbeatUrl = heartbeatUrl;
        this.heartbeatMethod = heartbeatMethod;
        this.forwardedFrom = forwardedFrom;
        this.playDtmf = playDtmf;
        this.timeout = timeout;
        this.hideCallerId = hideCallerId;
        this.record = record;
        this.recordCallback = recordCallback;
        this.recordCallbackMethod = recordCallbackMethod;
        this.transcribe = transcribe;
        this.transcribeCallback = transcribeCallback;
        this.straightToVoicemail = straightToVoicemail;
        this.ifMachine = ifMachine;
        this.ifMachineUrl = ifMachineUrl;
        this.ifMachineMethod = ifMachineMethod;
        this.sipAuthUsername = sipAuthUsername;
        this.sipAuthPassword = sipAuthPassword;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public String getUrl() {
        return url;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getFallbackUrl() {
        return fallbackUrl;
    }

    public HttpMethod getFallbackMethod() {
        return fallbackMethod;
    }

    public String getStatusCallback() {
        return statusCallback;
    }

    public HttpMethod getStatusCallbackMethod() {
        return statusCallbackMethod;
    }

    public String getHeartbeatUrl() {
        return heartbeatUrl;
    }

    public HttpMethod getHeartbeatMethod() {
        return heartbeatMethod;
    }

    public String getForwardedFrom() {
        return forwardedFrom;
    }

    public String getPlayDtmf() {
        return playDtmf;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public Boolean getHideCallerId() {
        return hideCallerId;
    }

    public Boolean getRecord() {
        return record;
    }

    public String getRecordCallback() {
        return recordCallback;
    }

    public HttpMethod getRecordCallbackMethod() {
        return recordCallbackMethod;
    }

    public Boolean getTranscribe() {
        return transcribe;
    }

    public String getTranscribeCallback() {
        return transcribeCallback;
    }

    public Boolean getStraightToVoicemail() {
        return straightToVoicemail;
    }

    public IfMachine getIfMachine() {
        return ifMachine;
    }

    public String getIfMachineUrl() {
        return ifMachineUrl;
    }

    public HttpMethod getIfMachineMethod() {
        return ifMachineMethod;
    }

    public String getSipAuthUsername() {
        return sipAuthUsername;
    }

    public String getSipAuthPassword() {
        return sipAuthPassword;
    }
}
