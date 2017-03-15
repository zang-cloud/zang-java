package com.zang.api.inboundxml.elements;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "content"
})
@XmlRootElement(name = "Reject")
public class Reject implements ResponseElement {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "reason")
    protected RejectModes reason;


    public String getContent() {
        return content;
    }


    public void setContent(String value) {
        this.content = value;
    }


    public RejectModes getReason() {
        return reason;
    }


    public void setReason(RejectModes value) {
        this.reason = value;
    }

}
