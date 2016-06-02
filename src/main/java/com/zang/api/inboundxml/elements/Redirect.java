package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.inboundxml.elements.enums.Voice;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("Redirect")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"url"})
@SuppressWarnings("unused")
public class Redirect implements ResponseElement {

	@XStreamAsAttribute
	private String method;
	
	private String url;
	
	protected Redirect() {
		
	}
	
	static Redirect createRedirect(String url, HttpMethod method) {
		Redirect r = new Redirect();
		r.url = url;
		r.method = method == null ? null : method.toString();
		return r;
	}

}
