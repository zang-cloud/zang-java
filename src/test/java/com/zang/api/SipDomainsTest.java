package com.zang.api;

import com.zang.api.connectors.SipDomainsConnector;
import com.zang.api.domain.Domain;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.list.DomainsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.DomainParams;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.model.Parameter;

import java.io.IOException;


public class SipDomainsTest extends BaseZangTest {

    private SipDomainsConnector connector;

    @Before
    public void initConnector() {
        connector = connectorFactory.getSipDomainsConnector();
    }

    @Test
    public void viewDomain() throws ZangException, IOException {
        createExpectation("GET", "SIP/Domains/TestDomainSid.json", null, null,
                "/sipdomains/domain.json");
        Domain domain = connector.viewDomain("TestDomainSid");
        checkDomain(domain);
    }

    @Test
    public void listDomains() throws ZangException, IOException {
        createExpectation("GET", "SIP/Domains.json", null, null,
                "/sipdomains/domainslist.json");

        DomainsList domains = connector.listDomains();

        Assert.assertEquals(1, (int) domains.getTotal());
        checkDomain(domains.iterator().next());
    }

    @Test
    public void createDomain() throws ZangException, IOException {
        createExpectation("POST", "SIP/Domains.json", new Parameter[]{
                new Parameter("DomainName",  "mydomain.com"),
                new Parameter("FriendlyName",  "MyDomain"),
                new Parameter("VoiceUrl",  "VoiceUrl"),
                new Parameter("VoiceMethod",  "POST"),
                new Parameter("VoiceFallbackUrl",  "VoiceFallbackUrl"),
                new Parameter("VoiceFallbackMethod",  "GET"),
                new Parameter("HeartbeatUrl",  "HeartbeatUrl"),
                new Parameter("HeartbeatMethod",  "POST"),
                new Parameter("VoiceStatusCallback",  "VoiceStatusCallback"),
                new Parameter("VoiceStatusMethod",  "GET")
        }, null, "/sipdomains/domain.json");

        Domain domain = connector.createDomain(DomainParams.builder()
                .setAccountSid("TestAccountSid")
                .setDomainName("mydomain.com")
                .setFriendlyName("MyDomain")
                .setVoiceUrl("VoiceUrl")
                .setVoiceMethod(HttpMethod.POST)
                .setVoiceFallbackUrl("VoiceFallbackUrl")
                .setVoiceFallbackMethod(HttpMethod.GET)
                .setHeartbeatUrl("HeartbeatUrl")
                .setHeartbeatMethod(HttpMethod.POST)
                .setVoiceStatusCallback("VoiceStatusCallback")
                .setVoiceStatusMethod(HttpMethod.GET)
        .build());

        checkDomain(domain);
    }

    @Test
    public void updateDomain() throws ZangException, IOException {
        createExpectation("POST", "SIP/Domains/TestDomainSid.json", new Parameter[]{
                new Parameter("FriendlyName",  "MyDomain"),
                new Parameter("VoiceUrl",  "VoiceUrl"),
                new Parameter("VoiceMethod",  "POST"),
                new Parameter("VoiceFallbackUrl",  "VoiceFallbackUrl"),
                new Parameter("VoiceFallbackMethod",  "GET"),
                new Parameter("HeartbeatUrl",  "HeartbeatUrl"),
                new Parameter("HeartbeatMethod",  "POST"),
                new Parameter("VoiceStatusCallback",  "VoiceStatusCallback"),
                new Parameter("VoiceStatusMethod",  "GET")
        }, null, "/sipdomains/domain.json");

        Domain domain = connector.updateDomain(DomainParams.builder()
                .setAccountSid("TestAccountSid")
                .setDomainSid("TestDomainSid")
                .setFriendlyName("MyDomain")
                .setVoiceUrl("VoiceUrl")
                .setVoiceMethod(HttpMethod.POST)
                .setVoiceFallbackUrl("VoiceFallbackUrl")
                .setVoiceFallbackMethod(HttpMethod.GET)
                .setHeartbeatUrl("HeartbeatUrl")
                .setHeartbeatMethod(HttpMethod.POST)
                .setVoiceStatusCallback("VoiceStatusCallback")
                .setVoiceStatusMethod(HttpMethod.GET)
                .build());

        checkDomain(domain);
    }

    @Test
    public void deleteDomain() throws ZangException, IOException {
        createExpectation("DELETE", "SIP/Domains/TestDomainSid.json", null, null,
                "/sipdomains/domain.json");
        Domain domain = connector.deleteDomain("TestDomainSid");
        checkDomain(domain);
    }

    @Test
    public void listMappedCredentialsList() throws ZangException, IOException {
        throw new ZangException("Not implemented");
    }

    @Test
    public void mapCredentialsList() throws ZangException, IOException {
        throw new ZangException("Not implemented");
    }

    @Test
    public void deleteMappedCredentialsList() throws ZangException, IOException {
        throw new ZangException("Not implemented");
    }

    @Test
    public void listMappedIpAcls() throws ZangException, IOException {
        throw new ZangException("Not implemented");
    }

    @Test
    public void mapIpAcl() throws ZangException, IOException {
        throw new ZangException("Not implemented");
    }

    @Test
    public void deleteIpAcl() throws ZangException, IOException {
        throw new ZangException("Not implemented");
    }


    private void checkDomain(Domain domain) {

    }

}
