package com.zang.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.zang.api.json.JsonBooleanParser;

/**
 * Zang offers the ability to preset all voice and sms urls for a given
 * application name. This application can then be assigned to multiple numbers
 * so you don't have to update all of their urls manually.
 */
public class Application extends BaseZangObjectWithMethods{
	@JsonProperty("friendly_name")
	private String friendlyName;
	@JsonDeserialize(using = JsonBooleanParser.class)

	/**
	 * @return String defining this resource.
	 */
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	
}


