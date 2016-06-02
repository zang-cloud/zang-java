package com.zang.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.zang.api.domain.AvailablePhoneNumber;
import com.zang.api.domain.ZangList;

public class AvailablePhoneNumberList extends ZangList<AvailablePhoneNumber>{

	@Override
	@JsonProperty("available_phone_numbers")
	protected void mapElements(List<AvailablePhoneNumber> elements) {
		setElements(elements);
	}

}
