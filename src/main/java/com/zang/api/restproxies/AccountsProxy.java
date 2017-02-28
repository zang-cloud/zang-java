package com.zang.api.restproxies;

import com.zang.api.domain.Account;
import org.jboss.resteasy.client.ClientResponse;

import javax.ws.rs.*;

public interface AccountsProxy {
    @GET
    @Path("Accounts/{AccountSid}.json")
    @Produces("application/json")
    ClientResponse<Account> getAccount(@PathParam("AccountSid") String accountSid);


    @POST
    @Path("Accounts/{AccountSid}.json")
    @Produces("application/json")
    ClientResponse<Account> updateAccount(
            @PathParam("AccountSid") String accountSid,
            @FormParam("FriendlyName") String friendlyName);

}
