package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

import java.util.ArrayList;
import java.util.List;

public class ResponseBuilder {

    private List<ResponseElement> content;
    private String statusCallback;
    private HttpMethod statusMethod;
    private String heartbeatCallback;
    private HttpMethod heartbeatMethod;

    ResponseBuilder() {
        content = new ArrayList<ResponseElement>();
    }

    public ResponseBuilder addElement(ResponseElement element) {
        content.add(element);
        return this;
    }

    public ResponseBuilder dial(Dial dial) {
        content.add(dial);
        return this;
    }

    public ResponseBuilder gather(Gather gather) {
        content.add(gather);
        return this;
    }

    public ResponseBuilder getSpeech(GetSpeech getSpeech) {
        content.add(getSpeech);
        return this;
    }

    public ResponseBuilder hangup(Hangup hangup) {
        content.add(hangup);
        return this;
    }

    public ResponseBuilder pause(Pause pause) {
        content.add(pause);
        return this;
    }

    public ResponseBuilder ping(Ping ping) {
        content.add(ping);
        return this;
    }

    public ResponseBuilder play(Play play) {
        content.add(play);
        return this;
    }

    public ResponseBuilder record(Record record) {
        content.add(record);
        return this;
    }

    public ResponseBuilder redirect(Redirect redirect) {
        content.add(redirect);
        return this;
    }

    public ResponseBuilder reject(Reject reject) {
        content.add(reject);
        return this;
    }

    public ResponseBuilder say(Say say) {
        content.add(say);
        return this;
    }

    public ResponseBuilder sms(Sms sms) {
        content.add(sms);
        return this;
    }

    public ResponseBuilder playLastRecording(PlayLastRecording playLastRecording) {
        this.content.add(playLastRecording);
        return this;
    }

    public ResponseBuilder setContent(List<ResponseElement> content) {
        this.content = content;
        return this;
    }

    public ResponseBuilder setStatusCallback(String statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    public ResponseBuilder setStatusMethod(HttpMethod statusMethod) {
        this.statusMethod = statusMethod;
        return this;
    }

    public ResponseBuilder setHeartbeatCallback(String heartbeatCallback) {
        this.heartbeatCallback = heartbeatCallback;
        return this;
    }

    public ResponseBuilder setHeartbeatMethod(HttpMethod heartbeatMethod) {
        this.heartbeatMethod = heartbeatMethod;
        return this;
    }

    public Response build() {
        return new Response(content, statusCallback, statusMethod, heartbeatCallback, heartbeatMethod);
    }
}