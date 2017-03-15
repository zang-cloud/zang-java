package com.zang.api.inboundxml.elements;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "content"
})
@XmlRootElement(name = "Pause")
public class Pause implements ResponseElement, GatherElement, GetSpeechElement {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "length")
    protected Integer length;


    public String getContent() {
        return content;
    }


    public void setContent(String value) {
        this.content = value;
    }


    public Integer getLength() {
        return length;
    }


    public void setLength(Integer value) {
        this.length = value;
    }

}
