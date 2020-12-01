package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

import java.util.ArrayList;
import java.util.List;

public class ConnectBuilder {
	private List<ConnectElement> content;
	private String action;
	private HttpMethod method;

	ConnectBuilder() {
		this.content = new ArrayList<ConnectElement>();
	}

	/**
	 * Adds an element to the Connect element.
	 *
	 * @param element
	 * @return
	 */
	public ConnectBuilder addElement(ConnectElement element) {
		this.content.add(element);
		return this;
	}

	/**
	 * Replaces the whole content of the Connect element.
	 *
	 * @param content
	 * @return
	 */
	public ConnectBuilder setContent(List<ConnectElement> content) {
		this.content = content;
		return this;
	}

	/**
	 * URL where the flow of the call and the gathered digits will be forwarded to
	 * (if digits are input).
	 *
	 * @param action
	 * @return
	 */
	public ConnectBuilder setAction(String action) {
		this.action = action;
		return this;
	}

	/**
	 * Method used to request the action URL. Default value is POST.
	 *
	 * @param method
	 * @return
	 */
	public ConnectBuilder setMethod(HttpMethod method) {
		this.method = method;
		return this;
	}

    /**
     * Adds a Agent element to the Connect element.
     * @param agent
     * @return
     */
    public ConnectBuilder agent(Agent agent) {
        this.content.add(agent);
        return this;
    }

	public Connect build() {
		return new Connect(content, action, method);
	}
}