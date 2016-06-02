package com.zang.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.zang.api.domain.SmsMessage;
import com.zang.api.domain.ZangList;

public class SmsMessageList extends ZangList<SmsMessage> {
	
	@Override
	@JsonProperty(value="sms_messages")
	protected void mapElements(List<SmsMessage> elements) {
		setElements(elements);
	}

}
