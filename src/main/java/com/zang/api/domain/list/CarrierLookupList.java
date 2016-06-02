package com.zang.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.zang.api.domain.CarrierLookup;
import com.zang.api.domain.ZangList;

public class CarrierLookupList extends ZangList<CarrierLookup>{

	@Override
	@JsonProperty("carrier_lookups")
	protected void mapElements(List<CarrierLookup> elements) {
		setElements(elements);
	}

}
