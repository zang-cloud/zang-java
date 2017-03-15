package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

import java.util.ArrayList;
import java.util.List;

public class GatherBuilder {
    private List<GatherElement> content;
    private String action;
    private HttpMethod method;
    private Integer timeout;
    private String finishOnKey;
    private Integer numDigits;

    GatherBuilder() {
        this.content = new ArrayList<GatherElement>();
    }

    public GatherBuilder addElement(GatherElement element) {
        this.content.add(element);
        return this;
    }

    public GatherBuilder say(Say say) {
        this.content.add(say);
        return this;
    }

    public GatherBuilder play(Play play) {
        this.content.add(play);
        return this;
    }

    public GatherBuilder pause(Pause pause) {
        this.content.add(pause);
        return this;
    }

    public GatherBuilder playLastRecording(PlayLastRecording playLastRecording) {
        this.content.add(playLastRecording);
        return this;
    }

    public GatherBuilder setContent(List<GatherElement> content) {
        this.content = content;
        return this;
    }

    public GatherBuilder setAction(String action) {
        this.action = action;
        return this;
    }

    public GatherBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public GatherBuilder setTimeout(Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    public GatherBuilder setFinishOnKey(String finishOnKey) {
        this.finishOnKey = finishOnKey;
        return this;
    }

    public GatherBuilder setNumDigits(Integer numDigits) {
        this.numDigits = numDigits;
        return this;
    }

    public Gather build() {
        return new Gather(content, action, method, timeout, finishOnKey, numDigits);
    }
}