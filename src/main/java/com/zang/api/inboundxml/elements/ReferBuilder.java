package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

import java.util.ArrayList;
import java.util.List;

public class ReferBuilder {
    private List<ReferElement> content;
    private String action;
    private HttpMethod method;
    private Integer timeout;
    private String callbackUrl;
    private HttpMethod callbackMethod;

    ReferBuilder() {
        this.content = new ArrayList<ReferElement>();
    }

    /**
     * Adds an element to the Refer element.
     * @param element
     * @return
     */
    public ReferBuilder addElement(ReferElement element) {
        this.content.add(element);
        return this;
    }

    /**
     * Adds a Sip element to the Refer element.
     * @param sip
     * @return
     */
    public ReferBuilder sip(Sip sip) {
        this.content.add(sip);
        return this;
    }

    /**
     * Replaces the whole content of the Refer element.
     * @param content
     * @return
     */
    public ReferBuilder setContent(List<ReferElement> content) {
        this.content = content;
        return this;
    }

    /**
     * URL where some parameters specific to <Refer> will be sent for further processing.
     * @param action
     * @return
     */
    public ReferBuilder setAction(String action) {
        this.action = action;
        return this;
    }

    /**
     * Method used to request the action URL. Default Value: POST. Allowed Value: POST or GET.
     * @param method
     * @return
     */
    public ReferBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    /**
     * The number of seconds cpaas should wait for <Refer> verb to conclude.
     * @param timeout
     * @return
     */
    public ReferBuilder setTimeout(Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    /**
     * URL where the status of the Refer can be sent. Note that this URL only receives parameters containing information about the call, the call does not execute XML given as a callbackUrl.
     * @param callbackUrl
     * @return
     */
    public ReferBuilder setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    /**
     * Method used to request the callback URL. Default Value: POST. Allowed Value: POST or GET.
     * @param callbackMethod
     * @return
     */
    public ReferBuilder setCallbackMethod(HttpMethod callbackMethod) {
        this.callbackMethod = callbackMethod;
        return this;
    }

    public Refer build() {
        return new Refer(content, action, method, timeout, callbackUrl, callbackMethod);
    }
}
