package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

public class PlayBuilder {
    private String url;
    private Integer loop;
    private HttpMethod method;

    PlayBuilder() {
    }

    public PlayBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public PlayBuilder setLoop(Integer loop) {
        this.loop = loop;
        return this;
    }

    public PlayBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public Play build() {
        return new Play(url, loop, method);
    }
}