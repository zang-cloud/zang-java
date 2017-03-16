package com.zang.api.inboundxml.elements;

public class PauseBuilder {
    private Integer length;

    PauseBuilder() {
    }

    public PauseBuilder setLength(Integer length) {
        this.length = length;
        return this;
    }

    public Pause build() {
        return new Pause(length);
    }
}