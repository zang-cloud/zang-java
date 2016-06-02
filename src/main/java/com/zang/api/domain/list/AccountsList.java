package com.zang.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.zang.api.domain.Account;
import com.zang.api.domain.ZangList;

public class AccountsList extends ZangList<Account>{

	@Override
	@JsonProperty("accounts")
	protected void mapElements(List<Account> elements) {
		setElements(elements);
	}

}
