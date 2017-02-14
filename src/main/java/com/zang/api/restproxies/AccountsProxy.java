package com.zang.api.restproxies;

import javax.ws.rs.*;

import org.jboss.resteasy.client.ClientResponse;

import com.zang.api.domain.Account;
import com.zang.api.domain.list.AccountsList;

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
