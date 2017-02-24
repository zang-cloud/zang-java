package com.zang.api.restproxies;

import com.zang.api.domain.Usage;
import com.zang.api.domain.list.UsagesList;
import org.jboss.resteasy.client.ClientResponse;

import javax.ws.rs.*;

public interface UsageProxy {
    @GET
    @Path("Accounts/{AccountSid}/Usages/{UsageSid}.json")
    @Produces("application/json")
    ClientResponse<Usage> getUsage(
            @PathParam("AccountSid") String accountSid,
            @PathParam("UsageSid") String usageSid
    );

    @GET
    @Path("Accounts/{AccountSid}/Usages.json")
    @Produces("application/json")
    ClientResponse<UsagesList> listUsages(
            @PathParam("AccountSid") String accountSid,
            @QueryParam(value="Day") Integer day,
            @QueryParam(value="Month") Integer month,
            @QueryParam(value="Year") Integer year,
            @QueryParam(value="Product") Integer product,
            @QueryParam(value="Page") Long page,
            @QueryParam(value="PageSize") Long pageSize
    );


}
