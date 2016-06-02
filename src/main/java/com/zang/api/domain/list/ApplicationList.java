package com.zang.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.zang.api.domain.Application;
import com.zang.api.domain.ZangList;

public class ApplicationList extends ZangList<Application> {

	@Override
	@JsonProperty("applications")
	protected void mapElements(List<Application> elements) {
		setElements(elements);
	}
}
