package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

public class NumberBuilder {
    private String number;
    private String sendDigits;
    private HttpMethod method;
    private String url;
    private Boolean sendOnPreanswer;

    NumberBuilder() {
    }

    public NumberBuilder setNumber(String number) {
        this.number = number;
        return this;
    }

    public NumberBuilder setSendDigits(String sendDigits) {
        this.sendDigits = sendDigits;
        return this;
    }

    public NumberBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public NumberBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public NumberBuilder setSendOnPreanswer(Boolean sendOnPreanswer) {
        this.sendOnPreanswer = sendOnPreanswer;
        return this;
    }

    public Number build() {
        return new Number(number, sendDigits, method, url, sendOnPreanswer);
    }
}