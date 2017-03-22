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

    public ConferencesConnector getConferencesConnector() {
        return new ConferencesConnector(this.conf, this.executor);
    }

    public static ConferencesConnector getConferencesConnector(ZangConfiguration conf) {
        return new ConferencesConnector(conf, null);
    }

    public static ConferencesConnector getConferencesConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        return new ConferencesConnector(conf, executor);
    }

    public ApplicationsConnector getApplicationsConnector() {
        return new ApplicationsConnector(this.conf, this.executor);
    }

    public static ApplicationsConnector getApplicationsConnector(ZangConfiguration conf) {
        return new ApplicationsConnector(conf, null);
    }

    public static ApplicationsConnector getApplicationsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        return new ApplicationsConnector(conf, executor);
    }

    public ApplicationClientsConnector getApplicationClientsConnector() {
        return new ApplicationClientsConnector(this.conf, this.executor);
    }

    public static ApplicationClientsConnector getApplicationClientsConnector(ZangConfiguration conf) {
        return new ApplicationClientsConnector(conf, null);
    }

    public static ApplicationClientsConnector getApplicationClientsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        return new ApplicationClientsConnector(conf, executor);
    }

    public SipDomainsConnector getSipDomainsConnector() {
        return new SipDomainsConnector(this.conf, this.executor);
    }

    public static SipDomainsConnector getSipDomainsConnector(ZangConfiguration conf) {
        return new SipDomainsConnector(conf, null);
    }

    public static SipDomainsConnector getSipDomainsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        return new SipDomainsConnector(conf, executor);
    }

    public SipCredentialsConnector getSipCredentialsConnector() {
        return new SipCredentialsConnector(this.conf, this.executor);
    }

    public static SipCredentialsConnector getSipCredentialsConnector(ZangConfiguration conf) {
        return new SipCredentialsConnector(conf, null);
    }

    public static SipCredentialsConnector getSipCredentialsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        return new SipCredentialsConnector(conf, executor);
    }

    public SipIpAccessControlListsConnector getSipIpAccessControlListsConnector() {
        return new SipIpAccessControlListsConnector(this.conf, this.executor);
    }

    public static SipIpAccessControlListsConnector getSipIpAccessControlListsConnector(ZangConfiguration conf) {
        return new SipIpAccessControlListsConnector(conf, null);
    }

    public static SipIpAccessControlListsConnector getSipIpAccessControlListsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        return new SipIpAccessControlListsConnector(conf, executor);
    }

    public IncomingPhoneNumbersConnector getIncomingPhoneNumbersConnector() {
        return new IncomingPhoneNumbersConnector(this.conf, this.executor);
    }

    public static IncomingPhoneNumbersConnector getIncomingPhoneNumbersConnector(ZangConfiguration conf) {
        return new IncomingPhoneNumbersConnector(conf, null);
    }

    public static IncomingPhoneNumbersConnector getIncomingPhoneNumbersConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        return new IncomingPhoneNumbersConnector(conf, executor);
    }

    public RecordingsConnector getRecordingsConnector() {
        return new RecordingsConnector(this.conf, this.executor);
    }

    public static RecordingsConnector getRecordingsConnector(ZangConfiguration conf) {
        return new RecordingsConnector(conf, null);
    }

    public static RecordingsConnector getRecordingsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        return new RecordingsConnector(conf, executor);
    }

    public NotificationsConnector getNotificationsConnector() {
        return new NotificationsConnector(this.conf, this.executor);
    }

    public static NotificationsConnector getNotificationsConnector(ZangConfiguration conf) {
        return new NotificationsConnector(conf, null);
    }

    public static NotificationsConnector getNotificationsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        return new NotificationsConnector(conf, executor);
    }
}
