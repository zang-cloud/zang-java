package com.zang.api.inboundxml.elements;

import com.zang.api.inboundxml.elements.enums.Language;
import com.zang.api.inboundxml.elements.enums.Voice;

public class SayBuilder {
    private String text;
    private Integer loop;
    private Voice voice;
    private Language language;

    SayBuilder() {
    }

    public SayBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public SayBuilder setLoop(Integer loop) {
        this.loop = loop;
        return this;
    }

    public SayBuilder setVoice(Voice voice) {
        this.voice = voice;
        return this;
    }

    public SayBuilder setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public Say build() {
        return new Say(text, loop, voice, language);
    }
}