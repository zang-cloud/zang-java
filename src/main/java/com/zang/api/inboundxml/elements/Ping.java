package com.zang.api.inboundxml.elements;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "content"
})
@XmlRootElement(name = "Ping")
public class Ping implements ResponseElement {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "method")
    protected String method;


    public String getContent() {
        return content;
    }


    public void setContent(String value) {
        this.content = value;
    }


    public String getMethod() {
        return method;
    }


    public void setMethod(String value) {
        this.method = value;
    }

}
