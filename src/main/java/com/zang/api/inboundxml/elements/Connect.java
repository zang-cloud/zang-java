package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.inboundxml.elements.Number;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "content" })
@XmlRootElement(name = "Connect")
public class Connect implements ResponseElement {

	@XmlElementRefs({
        @XmlElementRef(name = "Agent", type = Agent.class, required = true)
	})
	@XmlMixed
	protected List<ConnectElement> content;
	@XmlAttribute(name = "action")
	@XmlSchemaType(name = "anyURI")
	protected String action;
	@XmlAttribute(name = "method")
	protected HttpMethod method;

	public static ConnectBuilder builder() {
		return new ConnectBuilder();
	}

	public Connect() {
	}

	public Connect(List<ConnectElement> content, String action, HttpMethod method) {
		this.content = content;
		this.action = action;
		this.method = method;
	}

	public List<ConnectElement> getContent() {
		if (content == null) {
			content = new ArrayList<ConnectElement>();
		}
		return this.content;
	}

	public void setContent(List<ConnectElement> content) {
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
}
