package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

public class PingBuilder {
    private String url;
    private HttpMethod method;

    PingBuilder() {
    }

    public PingBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public PingBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public Ping build() {
        return new Ping(url, method);
    }
}