package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.enums.RecordingAudioDirection;
import com.zang.api.domain.enums.TranscriptionQuality;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;
import com.zang.api.inboundxml.elements.enums.SamplingRate;

public class RecordBuilder {
    private String action;
    private HttpMethod method;
    private Integer timeout;
    private String finishOnKey;
    private Integer maxLength;
    private Boolean transcribe;
    private String transcribeCallback;
    private TranscriptionQuality transcriptionQuality;
    private Integer sliceStart;
    private Integer sliceDuration;
    private Boolean playBeep;
    private Boolean bothLegs;
    private RecordingFileFormat fileFormat;
    private RecordingAudioDirection direction;
    private Boolean background;
    private SamplingRate sampleRate;
    private Boolean trimSilence;
    private Integer lifetime;

    RecordBuilder() {
    }

    public RecordBuilder setAction(String action) {
        this.action = action;
        return this;
    }

    public RecordBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public RecordBuilder setTimeout(Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    public RecordBuilder setFinishOnKey(String finishOnKey) {
        this.finishOnKey = finishOnKey;
        return this;
    }

    public RecordBuilder setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    public RecordBuilder setTranscribe(Boolean transcribe) {
        this.transcribe = transcribe;
        return this;
    }

    public RecordBuilder setTranscribeCallback(String transcribeCallback) {
        this.transcribeCallback = transcribeCallback;
        return this;
    }

    public RecordBuilder setTranscriptionQuality(TranscriptionQuality transcriptionQuality) {
        this.transcriptionQuality = transcriptionQuality;
        return this;
    }

    public RecordBuilder setSliceStart(Integer sliceStart) {
        this.sliceStart = sliceStart;
        return this;
    }

    public RecordBuilder setSliceDuration(Integer sliceDuration) {
        this.sliceDuration = sliceDuration;
        return this;
    }

    public RecordBuilder setPlayBeep(Boolean playBeep) {
        this.playBeep = playBeep;
        return this;
    }

    public RecordBuilder setBothLegs(Boolean bothLegs) {
        this.bothLegs = bothLegs;
        return this;
    }

    public RecordBuilder setFileFormat(RecordingFileFormat fileFormat) {
        this.fileFormat = fileFormat;
        return this;
    }

    public RecordBuilder setDirection(RecordingAudioDirection direction) {
        this.direction = direction;
        return this;
    }

    public RecordBuilder setBackground(Boolean background) {
        this.background = background;
        return this;
    }

    public RecordBuilder setSampleRate(SamplingRate sampleRate) {
        this.sampleRate = sampleRate;
        return this;
    }

    public RecordBuilder setTrimSilence(Boolean trimSilence) {
        this.trimSilence = trimSilence;
        return this;
    }

    public RecordBuilder setLifetime(Integer lifetime) {
        this.lifetime = lifetime;
        return this;
    }

    public Record build() {
        return new Record(action, method, timeout, finishOnKey, maxLength, transcribe, transcribeCallback, transcriptionQuality, sliceStart, sliceDuration, playBeep, bothLegs, fileFormat, direction, background, sampleRate, trimSilence, lifetime);
    }
}