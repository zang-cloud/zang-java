package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.enums.IfMachine;
import com.zang.api.domain.enums.RecordingAudioDirection;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;

import java.util.ArrayList;
import java.util.List;

public class DialBuilder {
    private List<DialElement> content;
    private String action;
    private HttpMethod method;
    private Integer timeout;
    private Boolean hangupOnStar;
    private Integer timeLimit;
    private String callerId;
    private Boolean hideCallerId;
    private String callerName;
    private String dialMusic;
    private String callbackUrl;
    private HttpMethod callbackMethod;
    private String confirmSound;
    private String digitsMatch;
    private Boolean straightToVm;
    private String heartbeatUrl;
    private HttpMethod heartbeatMethod;
    private String forwardedFrom;
    private Boolean record;
    private RecordingAudioDirection recordDirection;
    private String recordCallbackUrl;
    private Integer recordLifetime;
    private RecordingFileFormat recordFormat;
    private IfMachine ifMachine;
    private String ifMachineUrl;
    private HttpMethod ifMachineMethod;
    private Boolean outboundAction;

    DialBuilder() {
        this.content = new ArrayList<DialElement>();
    }

    public DialBuilder addElement(DialElement element) {
        this.content.add(element);
        return this;
    }

    public DialBuilder conference(Conference conference) {
        this.content.add(conference);
        return this;
    }

    public DialBuilder number(Number number) {
        this.content.add(number);
        return this;
    }

    public DialBuilder sip(Sip sip) {
        this.content.add(sip);
        return this;
    }

    public DialBuilder setContent(List<DialElement> content) {
        this.content = content;
        return this;
    }

    public DialBuilder setAction(String action) {
        this.action = action;
        return this;
    }

    public DialBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public DialBuilder setTimeout(Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    public DialBuilder setHangupOnStar(Boolean hangupOnStar) {
        this.hangupOnStar = hangupOnStar;
        return this;
    }

    public DialBuilder setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
        return this;
    }

    public DialBuilder setCallerId(String callerId) {
        this.callerId = callerId;
        return this;
    }

    public DialBuilder setHideCallerId(Boolean hideCallerId) {
        this.hideCallerId = hideCallerId;
        return this;
    }

    public DialBuilder setCallerName(String callerName) {
        this.callerName = callerName;
        return this;
    }

    public DialBuilder setDialMusic(String dialMusic) {
        this.dialMusic = dialMusic;
        return this;
    }

    public DialBuilder setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public DialBuilder setCallbackMethod(HttpMethod callbackMethod) {
        this.callbackMethod = callbackMethod;
        return this;
    }

    public DialBuilder setConfirmSound(String confirmSound) {
        this.confirmSound = confirmSound;
        return this;
    }

    public DialBuilder setDigitsMatch(String digitsMatch) {
        this.digitsMatch = digitsMatch;
        return this;
    }

    public DialBuilder setStraightToVm(Boolean straightToVm) {
        this.straightToVm = straightToVm;
        return this;
    }

    public DialBuilder setHeartbeatUrl(String heartbeatUrl) {
        this.heartbeatUrl = heartbeatUrl;
        return this;
    }

    public DialBuilder setHeartbeatMethod(HttpMethod heartbeatMethod) {
        this.heartbeatMethod = heartbeatMethod;
        return this;
    }

    public DialBuilder setForwardedFrom(String forwardedFrom) {
        this.forwardedFrom = forwardedFrom;
        return this;
    }

    public DialBuilder setRecord(Boolean record) {
        this.record = record;
        return this;
    }

    public DialBuilder setRecordDirection(RecordingAudioDirection recordDirection) {
        this.recordDirection = recordDirection;
        return this;
    }

    public DialBuilder setRecordCallbackUrl(String recordCallbackUrl) {
        this.recordCallbackUrl = recordCallbackUrl;
        return this;
    }

    public DialBuilder setRecordLifetime(Integer recordLifetime) {
        this.recordLifetime = recordLifetime;
        return this;
    }

    public DialBuilder setRecordFormat(RecordingFileFormat recordFormat) {
        this.recordFormat = recordFormat;
        return this;
    }

    public DialBuilder setIfMachine(IfMachine ifMachine) {
        this.ifMachine = ifMachine;
        return this;
    }

    public DialBuilder setIfMachineUrl(String ifMachineUrl) {
        this.ifMachineUrl = ifMachineUrl;
        return this;
    }

    public DialBuilder setIfMachineMethod(HttpMethod ifMachineMethod) {
        this.ifMachineMethod = ifMachineMethod;
        return this;
    }

    public DialBuilder setOutboundAction(Boolean outboundAction) {
        this.outboundAction = outboundAction;
        return this;
    }

    public Dial build() {
        return new Dial(content, action, method, timeout, hangupOnStar, timeLimit, callerId, hideCallerId, callerName, dialMusic, callbackUrl, callbackMethod, confirmSound, digitsMatch, straightToVm, heartbeatUrl, heartbeatMethod, forwardedFrom, record, recordDirection, recordCallbackUrl, recordLifetime, recordFormat, ifMachine, ifMachineUrl, ifMachineMethod, outboundAction);
    }
}