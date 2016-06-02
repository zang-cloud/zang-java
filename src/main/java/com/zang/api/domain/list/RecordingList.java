package com.zang.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.zang.api.domain.Recording;
import com.zang.api.domain.ZangList;

public class RecordingList extends ZangList<Recording>{

	@Override
	@JsonProperty("recordings")
	protected void mapElements(List<Recording> elements) {
		setElements(elements);
	}

}
