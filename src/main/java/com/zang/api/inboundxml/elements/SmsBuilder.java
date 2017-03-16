package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

public class SmsBuilder {
    private String text;
    private String to;
    private String from;
    private String action;
    private HttpMethod method;
    private String statusCallback;
    private HttpMethod statusCallbackMethod;

    SmsBuilder() {
    }

    public SmsBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public SmsBuilder setTo(String to) {
        this.to = to;
        return this;
    }

    public SmsBuilder setFrom(String from) {
        this.from = from;
        return this;
    }

    public SmsBuilder setAction(String action) {
        this.action = action;
        return this;
    }

    public SmsBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public SmsBuilder setStatusCallback(String statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    public SmsBuilder setStatusCallbackMethod(HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    public Sms build() {
        return new Sms(text, to, from, action, method, statusCallback, statusCallbackMethod);
    }
}