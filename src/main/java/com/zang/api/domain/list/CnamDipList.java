package com.zang.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.zang.api.domain.CnamDip;
import com.zang.api.domain.ZangList;

public class CnamDipList extends ZangList<CnamDip>{

	@Override
	@JsonProperty("cnam_dips")
	protected void mapElements(List<CnamDip> elements) {
		setElements(elements);
	}

}
