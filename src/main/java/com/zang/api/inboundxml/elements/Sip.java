package com.zang.api.inboundxml.elements;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "content"
})
@XmlRootElement(name = "Sip")
public class Sip implements DialElement {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "action")
    @XmlSchemaType(name = "anyURI")
    protected String action;
    @XmlAttribute(name = "method")
    protected String method;
    @XmlAttribute(name = "username")
    protected String username;
    @XmlAttribute(name = "password")
    protected String password;
    @XmlAttribute(name = "sendDigits")
    protected String sendDigits;


    public String getContent() {
        return content;
    }


    public void setContent(String value) {
        this.content = value;
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


    public String getUsername() {
        return username;
    }


    public void setUsername(String value) {
        this.username = value;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String value) {
        this.password = value;
    }


    public String getSendDigits() {
        return sendDigits;
    }


    public void setSendDigits(String value) {
        this.sendDigits = value;
    }

}
