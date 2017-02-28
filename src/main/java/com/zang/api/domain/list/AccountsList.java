package com.zang.api.domain.list;

import com.zang.api.domain.Account;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class AccountsList extends ZangList<Account> {

    @Override
    @JsonProperty("accounts")
    protected void mapElements(List<Account> elements) {
        setElements(elements);
    }

}
