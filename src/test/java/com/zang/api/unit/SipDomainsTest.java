package com.zang.api.unit;

import com.zang.api.connectors.SipDomainsConnector;
import com.zang.api.domain.AccessControlList;
import com.zang.api.domain.CredentialsList;
import com.zang.api.domain.Domain;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.list.AccessControlListsList;
import com.zang.api.domain.list.CredentialsListsList;
import com.zang.api.domain.list.DomainsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.DomainParams;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.model.Parameter;

import java.io.IOException;


public class SipDomainsTest extends BaseUnitTest {

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
        createExpectation("GET", "SIP/Domains/TestDomainSid/CredentialListMappings.json", null, null,
                "/sipdomains/credentialslistlist.json");

        CredentialsListsList credentialsListsList = connector.listMappedCredentialsLists("TestDomainSid");

        Assert.assertEquals(1, (int) credentialsListsList.getTotal());
        checkCl(credentialsListsList.iterator().next());
    }

    @Test
    public void mapCredentialsList() throws ZangException, IOException {
        createExpectation("POST", "SIP/Domains/TestDomainSid/CredentialListMappings.json", new Parameter[]{
                new Parameter("CredentialListSid", "TestCredentialsListSid")
                }, null,
                "/sipdomains/credentialslist.json");

        CredentialsList credentialsList = connector.mapCredentialsLists("TestDomainSid", "TestCredentialsListSid");
        checkCl(credentialsList);
    }

    @Test
    public void deleteMappedCredentialsList() throws ZangException, IOException {
        createExpectation("DELETE", "SIP/Domains/TestDomainSid/CredentialListMappings/TestCredentialsListSid.json", null, null,
                "/sipdomains/credentialslist.json");

        CredentialsList credentialsList = connector.deleteMappedCredentialsList("TestDomainSid", "TestCredentialsListSid");
        checkCl(credentialsList);
    }

    @Test
    public void listMappedIpAcls() throws ZangException, IOException {
        createExpectation("GET", "SIP/Domains/TestDomainSid/IpAccessControlListMappings.json", null, null,
                "/sipdomains/ipacllist.json");

        AccessControlListsList aclListList = connector.listMappedIpAccessControlLists("TestDomainSid");

        Assert.assertEquals(1, (int) aclListList.getTotal());
        checkIpAcl(aclListList.iterator().next());
    }

    @Test
    public void mapIpAcl() throws ZangException, IOException {
        createExpectation("POST", "SIP/Domains/TestDomainSid/IpAccessControlListMappings.json", new Parameter[]{
                        new Parameter("IpAccessControlListSid", "TestIpAccessControlListSid")
                }, null,
                "/sipdomains/ipacl.json");

        AccessControlList aclList = connector.mapIpAccessControlList("TestDomainSid", "TestIpAccessControlListSid");
        checkIpAcl(aclList);
    }

    @Test
    public void deleteIpAcl() throws ZangException, IOException {
        createExpectation("DELETE", "SIP/Domains/TestDomainSid/IpAccessControlListMappings/TestIpAccessControlListSid.json", null, null,
                "/sipdomains/ipacl.json");

        AccessControlList aclList = connector.deleteMappedIpAccessControlList("TestDomainSid", "TestIpAccessControlListSid");
        checkIpAcl(aclList);
    }


    private void checkDomain(Domain domain) {

    }

    private void checkCl(CredentialsList list) {

    }

    private void checkIpAcl(AccessControlList list) {

    }

}
