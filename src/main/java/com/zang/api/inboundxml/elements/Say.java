package com.zang.api.inboundxml.elements;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "content"
})
@XmlRootElement(name = "Say")
public class Say implements ResponseElement, GatherElement, GetSpeechElement {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "loop")
    protected BigInteger loop;
    @XmlAttribute(name = "voice")
    protected SayVoice voice;
    @XmlAttribute(name = "language")
    protected TtsLanguages language;


    public String getContent() {
        return content;
    }


    public void setContent(String value) {
        this.content = value;
    }


    public BigInteger getLoop() {
        return loop;
    }


    public void setLoop(BigInteger value) {
        this.loop = value;
    }


    public SayVoice getVoice() {
        return voice;
    }


    public void setVoice(SayVoice value) {
        this.voice = value;
    }


    public TtsLanguages getLanguage() {
        return language;
    }


    public void setLanguage(TtsLanguages value) {
        this.language = value;
    }

}
