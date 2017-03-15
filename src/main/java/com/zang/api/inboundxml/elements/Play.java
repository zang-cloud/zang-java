package com.zang.api.inboundxml.elements;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "content"
})
@XmlRootElement(name = "Play")
public class Play implements ResponseElement, GatherElement, GetSpeechElement {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "loop")
    protected Integer loop;
    @XmlAttribute(name = "method")
    protected String method;


    public String getContent() {
        return content;
    }


    public void setContent(String value) {
        this.content = value;
    }


    public Integer getLoop() {
        return loop;
    }


    public void setLoop(Integer value) {
        this.loop = value;
    }


    public String getMethod() {
        return method;
    }


    public void setMethod(String value) {
        this.method = value;
    }

}
