package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.Account;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.AccountsProxy;
import org.jboss.resteasy.client.ClientExecutor;
import org.jboss.resteasy.client.ClientResponse;

/**
 * 
 * The class used for all forms of communication with the Accounts endpoint of the Zang REST API.
 * 
 */
public class AccountConnector extends BaseConnector {

	private AccountsProxy accountsProxy;

    /**
     * @see BaseConnector, PropertiesFileZangConfiguration,
     *      ZangConfiguration
     */
	AccountConnector(ZangConfiguration conf, ClientExecutor executor) {
		super(conf, executor);
		accountsProxy = createProxy(AccountsProxy.class);
	}


	/**
	 * An account resource provides information about a single Zang account.
	 * This methods gets the info of the account with the provided Sid.
	 * 
	 * @param accountSid The sid for the account to be retrieved.
	 * @return Account object
	 * @throws ZangException
	 */
	public Account viewAccount(String accountSid) throws ZangException {
		ClientResponse<Account> acc = accountsProxy.getAccount(accountSid);
		return returnThrows(acc);
	}

	/**
	 * @see #viewAccount(String)
	 * @return The account with the Sid defined in the configuration.
	 * @throws ZangException
	 */
	public Account viewAccount() throws ZangException {
		return viewAccount(conf.getSid());
	}

	/**
	 * Updates the friendly name of an account.
	 * @param accountSid Sid of account to update
	 * @param friendlyName The new friendly name for this account
	 * @return The account with the updated friendlyName value
	 * @throws ZangException
	 */
	public Account updateAccount(String accountSid, String friendlyName) throws ZangException {
		ClientResponse<Account> acc = accountsProxy.updateAccount(accountSid, friendlyName);
		return returnThrows(acc);
	}

	/**
	 * @see #updateAccount(String, String)
	 * @param friendlyName The new friendly name for this account
	 * @return The account with the updated friendlyName value
	 * @throws ZangException
	 */
	public Account updateAccount(String friendlyName) throws ZangException {
		return updateAccount(conf.getSid(), friendlyName);
	}

}
