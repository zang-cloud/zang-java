package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;

public class ConferenceBuilder {
    private String name;
    private Boolean muted;
    private Boolean beep;
    private Boolean startConferenceOnEnter;
    private Boolean endConferenceOnExit;
    private Integer maxParticipants;
    private Integer timeLimit;
    private String waitUrl;
    private HttpMethod waitMethod;
    private Boolean hangupOnStar;
    private String callbackUrl;
    private HttpMethod callbackMethod;
    private HttpMethod method;
    private String waitSound;
    private HttpMethod waitSoundMethod;
    private String digitsMatch;
    private Boolean stayAlone;
    private Boolean record;
    private RecordingFileFormat recordFileFormat;
    private String recordCallbackUrl;
    private HttpMethod recordCallbackMethod;

    ConferenceBuilder() {
    }

    public ConferenceBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ConferenceBuilder setMuted(Boolean muted) {
        this.muted = muted;
        return this;
    }

    public ConferenceBuilder setBeep(Boolean beep) {
        this.beep = beep;
        return this;
    }

    public ConferenceBuilder setStartConferenceOnEnter(Boolean startConferenceOnEnter) {
        this.startConferenceOnEnter = startConferenceOnEnter;
        return this;
    }

    public ConferenceBuilder setEndConferenceOnExit(Boolean endConferenceOnExit) {
        this.endConferenceOnExit = endConferenceOnExit;
        return this;
    }

    public ConferenceBuilder setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
        return this;
    }

    public ConferenceBuilder setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
        return this;
    }

    public ConferenceBuilder setWaitUrl(String waitUrl) {
        this.waitUrl = waitUrl;
        return this;
    }

    public ConferenceBuilder setWaitMethod(HttpMethod waitMethod) {
        this.waitMethod = waitMethod;
        return this;
    }

    public ConferenceBuilder setHangupOnStar(Boolean hangupOnStar) {
        this.hangupOnStar = hangupOnStar;
        return this;
    }

    public ConferenceBuilder setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public ConferenceBuilder setCallbackMethod(HttpMethod callbackMethod) {
        this.callbackMethod = callbackMethod;
        return this;
    }

    public ConferenceBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public ConferenceBuilder setWaitSound(String waitSound) {
        this.waitSound = waitSound;
        return this;
    }

    public ConferenceBuilder setWaitSoundMethod(HttpMethod waitSoundMethod) {
        this.waitSoundMethod = waitSoundMethod;
        return this;
    }

    public ConferenceBuilder setDigitsMatch(String digitsMatch) {
        this.digitsMatch = digitsMatch;
        return this;
    }

    public ConferenceBuilder setStayAlone(Boolean stayAlone) {
        this.stayAlone = stayAlone;
        return this;
    }

    public ConferenceBuilder setRecord(Boolean record) {
        this.record = record;
        return this;
    }

    public ConferenceBuilder setRecordFileFormat(RecordingFileFormat recordFileFormat) {
        this.recordFileFormat = recordFileFormat;
        return this;
    }

    public ConferenceBuilder setRecordCallbackUrl(String recordCallbackUrl) {
        this.recordCallbackUrl = recordCallbackUrl;
        return this;
    }

    public ConferenceBuilder setRecordCallbackMethod(HttpMethod recordCallbackMethod) {
        this.recordCallbackMethod = recordCallbackMethod;
        return this;
    }

    public Conference build() {
        return new Conference(name, muted, beep, startConferenceOnEnter, endConferenceOnExit, maxParticipants, timeLimit, waitUrl, waitMethod, hangupOnStar, callbackUrl, callbackMethod, method, waitSound, waitSoundMethod, digitsMatch, stayAlone, record, recordFileFormat, recordCallbackUrl, recordCallbackMethod);
    }
}