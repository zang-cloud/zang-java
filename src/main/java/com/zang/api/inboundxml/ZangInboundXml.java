package com.zang.api.inboundxml;

import com.zang.api.inboundxml.elements.Response;
import com.zang.api.inboundxml.elements.ResponseBuilder;

public class ZangInboundXml {

    public static ResponseBuilder builder() {
        return Response.builder();
    }

}
