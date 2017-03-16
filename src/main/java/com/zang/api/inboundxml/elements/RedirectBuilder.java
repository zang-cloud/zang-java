package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

public class RedirectBuilder {
    private String url;
    private HttpMethod method;

    RedirectBuilder() {
    }

    public RedirectBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public RedirectBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public Redirect build() {
        return new Redirect(url, method);
    }
}