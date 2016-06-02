package com.zang.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.zang.api.domain.IncomingPhoneNumber;
import com.zang.api.domain.ZangList;

public class IncomingPhoneNumberList extends ZangList<IncomingPhoneNumber>{

	@Override
	@JsonProperty("incoming_phone_numbers")
	protected void mapElements(List<IncomingPhoneNumber> elements) {
		setElements(elements);
	}

}
