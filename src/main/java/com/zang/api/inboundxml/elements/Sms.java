package com.zang.api.inboundxml.elements;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "content"
})
@XmlRootElement(name = "Sms")
public class Sms implements ResponseElement {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "to", required = true)
    protected String to;
    @XmlAttribute(name = "from", required = true)
    protected String from;
    @XmlAttribute(name = "action")
    @XmlSchemaType(name = "anyURI")
    protected String action;
    @XmlAttribute(name = "method")
    protected String method;
    @XmlAttribute(name = "statusCallback")
    @XmlSchemaType(name = "anyURI")
    protected String statusCallback;
    @XmlAttribute(name = "statusCallbackMethod")
    protected String statusCallbackMethod;


    public String getContent() {
        return content;
    }

    public void setContent(String value) {
        this.content = value;
    }


    public String getTo() {
        return to;
    }


    public void setTo(String value) {
        this.to = value;
    }


    public String getFrom() {
        return from;
    }


    public void setFrom(String value) {
        this.from = value;
    }


    public String getAction() {
        return action;
    }


    public void setAction(String value) {
        this.action = value;
    }


    public String getMethod() {
        return method;
    }


    public void setMethod(String value) {
        this.method = value;
    }


    public String getStatusCallback() {
        return statusCallback;
    }


    public void setStatusCallback(String value) {
        this.statusCallback = value;
    }


    public String getStatusCallbackMethod() {
        return statusCallbackMethod;
    }


    public void setStatusCallbackMethod(String value) {
        this.statusCallbackMethod = value;
    }

}
