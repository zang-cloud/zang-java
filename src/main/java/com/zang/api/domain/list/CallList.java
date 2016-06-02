package com.zang.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.zang.api.domain.Call;
import com.zang.api.domain.ZangList;

public class CallList extends ZangList<Call>{

	@Override
	@JsonProperty("calls")
	protected void mapElements(List<Call> elements) {
		setElements(elements);
	}

}
