package com.zang.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.zang.api.domain.Conference;
import com.zang.api.domain.ZangList;

public class ConferenceList extends ZangList<Conference>{

	@Override
	@JsonProperty("conferences")
	protected void mapElements(List<Conference> elements) {
		setElements(elements);
	}

}
