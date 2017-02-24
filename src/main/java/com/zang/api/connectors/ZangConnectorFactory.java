package com.zang.api.connectors;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.configuration.ZangConfiguration;
import org.jboss.resteasy.client.ClientExecutor;

/**
 * 
 * The class used for all forms of communication with the Zang REST API.
 * 
 */
public class ZangConnectorFactory {

	private ZangConfiguration conf;
	private ClientExecutor executor;

	/**
	 * Creates a new ZangConnectorFactory based on the provided configuration.
	 *
	 * @param conf
	 *            The configuration based on which the ZangConnectorFactory will be
	 *            created.
	 * @see BasicZangConfiguration , PropertiesFileZangConfiguration,
	 *      ZangConfiguration
	 */
	public ZangConnectorFactory(ZangConfiguration conf) {
		this.conf = conf;
	}

    public ZangConnectorFactory(ZangConfiguration conf, ClientExecutor executor) {
        this.conf = conf;
        this.executor = executor;
    }

	public AccountConnector getAccountsConnector() {
        return new AccountConnector(this.conf, this.executor);
	}

	public static AccountConnector getAccountsConnector(ZangConfiguration conf) {
		return new AccountConnector(conf, null);
	}

	public static AccountConnector getAccountsConnector(ZangConfiguration conf, ClientExecutor executor) {
		return new AccountConnector(conf, executor);
	}


    public UsageConnector getUsageConnector() {
        return new UsageConnector(this.conf, this.executor);
    }

    public static UsageConnector getUsageConnector(ZangConfiguration conf) {
        return new UsageConnector(conf, null);
    }

    public static UsageConnector getUsageConnector(ZangConfiguration conf, ClientExecutor executor) {
        return new UsageConnector(conf, executor);
    }


    public SmsConnector getSmsConnector() {
        return new SmsConnector(this.conf, this.executor);
    }

    public static SmsConnector getSmsConnector(ZangConfiguration conf) {
        return new SmsConnector(conf, null);
    }

    public static SmsConnector getSmsConnector(ZangConfiguration conf, ClientExecutor executor) {
        return new SmsConnector(conf, executor);
    }
}
