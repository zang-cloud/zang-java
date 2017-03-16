package com.zang.api.connectors;

import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.configuration.ZangConfiguration;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;

/**
 * The class used for all forms of communication with the Zang REST API.
 */
public class ZangConnectorFactory {

    private ZangConfiguration conf;
    private ClientHttpEngine executor;

    /**
     * Creates a new ZangConnectorFactory based on the provided configuration.
     *
     * @param conf The configuration based on which the ZangConnectorFactory will be
     *             created.
     * @see BasicZangConfiguration , PropertiesFileZangConfiguration,
     * ZangConfiguration
     */
    public ZangConnectorFactory(ZangConfiguration conf) {
        this.conf = conf;
    }

    public ZangConnectorFactory(ZangConfiguration conf, ClientHttpEngine executor) {
        this.conf = conf;
        this.executor = executor;
    }

    public AccountsConnector getAccountsConnector() {
        return new AccountsConnector(this.conf, this.executor);
    }

    public static AccountsConnector getAccountsConnector(ZangConfiguration conf) {
        return new AccountsConnector(conf, null);
    }

    public static AccountsConnector getAccountsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        return new AccountsConnector(conf, executor);
    }


    public UsagesConnector getUsagesConnector() {
        return new UsagesConnector(this.conf, this.executor);
    }

    public static UsagesConnector getUsagesConnector(ZangConfiguration conf) {
        return new UsagesConnector(conf, null);
    }

    public static UsagesConnector getUsagesConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        return new UsagesConnector(conf, executor);
    }


    public SmsConnector getSmsConnector() {
        return new SmsConnector(this.conf, this.executor);
    }

    public static SmsConnector getSmsConnector(ZangConfiguration conf) {
        return new SmsConnector(conf, null);
    }

    public static SmsConnector getSmsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        return new SmsConnector(conf, executor);
    }

    public CallsConnector getCallsConnector() {
        return new CallsConnector(this.conf, this.executor);
    }

    public static CallsConnector getCallsConnector(ZangConfiguration conf) {
        return new CallsConnector(conf, null);
    }

    public static CallsConnector getCallsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        return new CallsConnector(conf, executor);
    }
}
