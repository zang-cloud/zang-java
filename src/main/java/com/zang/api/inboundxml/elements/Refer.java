package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "content" })
@XmlRootElement(name = "Refer")
public class Refer implements ResponseElement {

    @XmlElementRefs({
        @XmlElementRef(name = "Sip", type = Sip.class, required = false),
    })
    @XmlMixed
    protected List<ReferElement> content;
    @XmlAttribute(name = "action")
    @XmlSchemaType(name = "anyURI")
    protected String action;
    @XmlAttribute(name = "method")
    protected HttpMethod method;
    @XmlAttribute(name = "timeout")
    protected Integer timeout;
    @XmlAttribute(name = "callbackUrl")
    @XmlSchemaType(name = "anyURI")
    protected String callbackUrl;
    @XmlAttribute(name = "callbackMethod")
    protected HttpMethod callbackMethod;

    public static ReferBuilder builder() {
        return new ReferBuilder();
    }

    public Refer() {
    }

    public Refer(List<ReferElement> content, String action, HttpMethod method, Integer timeout, String callbackUrl, HttpMethod callbackMethod) {
        this.content = content;
        this.action = action;
        this.method = method;
        this.timeout = timeout;
        this.callbackUrl = callbackUrl;
        this.callbackMethod = callbackMethod;
    }


    public List<ReferElement> getContent() {
        if (content == null) {
            content = new ArrayList<ReferElement>();
        }
        return this.content;
    }

    public void setContent(List<ReferElement> content) {
        this.content = content;
    }

    public String getAction() {
        return action;
    }


    public void setAction(String value) {
        this.action = value;
    }


    public HttpMethod getMethod() {
        return method;
    }


    public void setMethod(HttpMethod value) {
        this.method = value;
    }


    public Integer getTimeout() {
        return timeout;
    }


    public void setTimeout(Integer value) {
        this.timeout = value;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }


    public void setCallbackUrl(String value) {
        this.callbackUrl = value;
    }


    public HttpMethod getCallbackMethod() {
        return callbackMethod;
    }


    public void setCallbackMethod(HttpMethod value) {
        this.callbackMethod = value;
    }
}
