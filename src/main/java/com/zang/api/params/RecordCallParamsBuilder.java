package com.zang.api.params;

import com.zang.api.domain.enums.RecordingAudioDirection;
import com.zang.api.domain.enums.TranscriptionQuality;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;

public class RecordCallParamsBuilder {
    private String accountSid;
    private String callSid;
    private Boolean record;
    private RecordingAudioDirection direction;
    private Integer timeLimit;
    private String callbackUrl;
    private RecordingFileFormat fileFormat;
    private Boolean trimSilence;
    private Boolean transcribe;
    private TranscriptionQuality transcriptionQuality;
    private String transcribeCallback;

    RecordCallParamsBuilder() {
    }

    public RecordCallParamsBuilder setAccountSid(String accountSid) {
        this.accountSid = accountSid;
        return this;
    }

    public RecordCallParamsBuilder setCallSid(String callSid) {
        this.callSid = callSid;
        return this;
    }

    public RecordCallParamsBuilder setRecord(Boolean record) {
        this.record = record;
        return this;
    }

    public RecordCallParamsBuilder setDirection(RecordingAudioDirection direction) {
        this.direction = direction;
        return this;
    }

    public RecordCallParamsBuilder setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
        return this;
    }

    public RecordCallParamsBuilder setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public RecordCallParamsBuilder setFileFormat(RecordingFileFormat fileFormat) {
        this.fileFormat = fileFormat;
        return this;
    }

    public RecordCallParamsBuilder setTrimSilence(Boolean trimSilence) {
        this.trimSilence = trimSilence;
        return this;
    }

    public RecordCallParamsBuilder setTranscribe(Boolean transcribe) {
        this.transcribe = transcribe;
        return this;
    }

    public RecordCallParamsBuilder setTranscriptionQuality(TranscriptionQuality transcriptionQuality) {
        this.transcriptionQuality = transcriptionQuality;
        return this;
    }

    public RecordCallParamsBuilder setTranscribeCallback(String transcribeCallback) {
        this.transcribeCallback = transcribeCallback;
        return this;
    }

    public RecordCallParams build() {
        return new RecordCallParams(accountSid, callSid, record, direction, timeLimit, callbackUrl, fileFormat, trimSilence, transcribe, transcriptionQuality, transcribeCallback);
    }
}