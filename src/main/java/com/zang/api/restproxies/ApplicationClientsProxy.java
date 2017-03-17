package com.zang.api.restproxies;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface ApplicationClientsProxy {
    @GET
    @Path("Accounts/{AccountSid}/Applications/{ApplicationSid}/Clients/{ClientSid}.json")
    @Produces("application/json")
    Response viewApplicationClient(@PathParam("AccountSid") String accountSid,
                                   @PathParam("ApplicationSid") String applicationSid,
                                   @PathParam("ClientSid") String clientSid);

    @GET
    @Path("Accounts/{AccountSid}/Applications/{ApplicationSid}/Clients.json")
    @Produces("application/json")
    Response listApplicationClients(@PathParam("AccountSid") String accountSid,
                                    @PathParam("ApplicationSid") String applicationSid);

    @POST
    @Path("Accounts/{AccountSid}/Applications/{ApplicationSid}/Clients/Tokens.json")
    @Produces("application/json")
    Response createApplicationClient(@PathParam("AccountSid") String accountSid,
                                     @PathParam("ApplicationSid") String applicationSid,
                                     @FormParam("Nickname") String nickname);
}

