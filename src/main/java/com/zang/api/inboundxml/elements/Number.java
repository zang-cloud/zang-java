package com.zang.api.inboundxml.elements;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "number"
})
@XmlRootElement(name = "Number")
public class Number implements DialElement {

    @XmlValue
    protected String number;
    @XmlAttribute(name = "sendDigits")
    protected String sendDigits;
    @XmlAttribute(name = "method")
    protected String method;
    @XmlAttribute(name = "url")
    @XmlSchemaType(name = "anyURI")
    protected String url;
    @XmlAttribute(name = "sendOnPreanswer")
    protected String sendOnPreanswer;


    public String getNumber() {
        return number;
    }


    public void setNumber(String value) {
        this.number = value;
    }


    public String getSendDigits() {
        return sendDigits;
    }


    public void setSendDigits(String value) {
        this.sendDigits = value;
    }


    public String getMethod() {
        return method;
    }


    public void setMethod(String value) {
        this.method = value;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String value) {
        this.url = value;
    }


    public String getSendOnPreanswer() {
        return sendOnPreanswer;
    }


    public void setSendOnPreanswer(String value) {
        this.sendOnPreanswer = value;
    }

}
