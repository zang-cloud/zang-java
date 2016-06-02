package com.zang.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.zang.api.domain.Notification;
import com.zang.api.domain.ZangList;

public class NotificationList extends ZangList<Notification>{

	@Override
	@JsonProperty("notifications")
	protected void mapElements(List<Notification> elements) {
		setElements(elements);
	}

}
