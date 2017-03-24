package com.zang.api.domain.list;

import com.zang.api.domain.CnamLookup;
import com.zang.api.domain.ZangList;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class CnamLookupsList extends ZangList<CnamLookup> {

    @Override
    @JsonProperty("cnam_dips")
    protected void mapElements(List<CnamLookup> elements) {
        setElements(elements);
    }

}
