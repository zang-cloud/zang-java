package com.zang.api.restproxies;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface CarrierServicesProxy {
    @POST
    @Path("Accounts/{AccountSid}/Lookups/Carrier.json")
    @Produces("application/json")
    Response carrierLookup(
            @PathParam("AccountSid") String accountSid
    );

    @GET
    @Path("Accounts/{AccountSid}/Lookups/Carrier.json")
    @Produces("application/json")
    Response authorizeDestination(
            @PathParam("AccountSid") String accountSid,
            @FormParam("Page") Integer page,
            @FormParam("PageSize") Integer pageSize
    );

    @POST
    @Path("Accounts/{AccountSid}/Lookups/Cnam.json")
    @Produces("application/json")
    Response cnamLookup(
            @PathParam("AccountSid") String accountSid,
            @FormParam("PhoneNumber") String phoneNumber
    );

    @GET
    @Path("Accounts/{AccountSid}/Lookups/Cnam.json")
    @Produces("application/json")
    Response cnamLookupList(
            @PathParam("AccountSid") String accountSid,
            @FormParam("Page") Integer page,
            @FormParam("PageSize") Integer pageSize
    );

    @POST
    @Path("Accounts/{AccountSid}/Lookups/Bna.json")
    @Produces("application/json")
    Response bnaLookup(
            @PathParam("AccountSid") String accountSid,
            @FormParam("PhoneNumber") String phoneNumber
    );

    @GET
    @Path("Accounts/{AccountSid}/Lookups/Bna.json")
    @Produces("application/json")
    Response bnaLookupList(
            @PathParam("AccountSid") String accountSid,
            @FormParam("Page") Integer page,
            @FormParam("PageSize") Integer pageSize
    );
}
