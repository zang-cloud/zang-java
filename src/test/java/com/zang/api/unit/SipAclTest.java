package com.zang.api.unit;

import com.zang.api.connectors.SipIpAccessControlListsConnector;
import com.zang.api.domain.AccessControlList;
import com.zang.api.domain.IpAddress;
import com.zang.api.exceptions.ZangException;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.model.Parameter;

import java.io.IOException;


public class SipAclTest extends BaseUnitTest {

    private SipIpAccessControlListsConnector connector;

    @Before
    public void initConnector() {
        connector = connectorFactory.getSipIpAccessControlListsConnector();
    }


    @Test
    public void viewIpAcl() throws ZangException, IOException {
        createExpectation("GET", "SIP/IpAccessControlLists/TestIpAccessControlListSid.json", null, null,
                "/sipdomains/ipacl.json");
        checkAcl(connector.viewIpAccessControlList("TestIpAccessControlListSid"));
    }

    @Test
    public void listIpAcls() throws ZangException, IOException {
        createExpectation("GET", "SIP/IpAccessControlLists.json", null, new Parameter[]{
                        new Parameter("Page", "0"),
                        new Parameter("PageSize", "50")
                },
                "/sipdomains/ipacllist.json");
        connector.listIpAccessControlLists(0, 50);
    }


    @Test
    public void createIpAcl() throws ZangException, IOException {
        createExpectation("POST", "SIP/IpAccessControlLists.json", new Parameter[]{
                        new Parameter("FriendlyName", "MyIpAclList")
                }, null,
                "/sipdomains/ipacl.json");
        checkAcl(connector.createIpAccessControlList("MyIpAclList"));
    }


    @Test
    public void updateIpAcl() throws ZangException, IOException {
        createExpectation("POST", "SIP/IpAccessControlLists/TestIpAccessControlListSid.json", new Parameter[]{
                        new Parameter("FriendlyName", "NewIpAclList")
                }, null,
                "/sipdomains/ipacl.json");
        checkAcl(connector.updateIpAccessControlList("TestIpAccessControlListSid", "NewIpAclList"));
    }


    @Test
    public void deleteIpAcl() throws ZangException, IOException {
        createExpectation("DELETE", "SIP/IpAccessControlLists/TestIpAccessControlListSid.json", null, null,
                "/sipdomains/ipacl.json");
        checkAcl(connector.deleteIpAccessControlList("TestIpAccessControlListSid"));
    }


    @Test
    public void viewAclIp() throws ZangException, IOException {
        createExpectation("GET", "SIP/IpAccessControlLists/TestIpAccessControlListSid/IpAddresses/TestIpAddressSid.json", null, null,
                "/sipdomains/ipaddress.json");
        checkIp(connector.viewAccessControlListIp("TestIpAccessControlListSid", "TestIpAddressSid"));
    }


    @Test
    public void listAclIps() throws ZangException, IOException {
        createExpectation("GET", "SIP/IpAccessControlLists/TestIpAccessControlListSid/IpAddresses.json", null, null,
                "/sipdomains/ipaddresslist.json");
        connector.listAccessControlListIps("TestIpAccessControlListSid");
    }


    @Test
    public void addAclIp() throws ZangException, IOException {
        createExpectation("POST", "SIP/IpAccessControlLists/TestIpAccessControlListSid/IpAddresses.json", new Parameter[]{
                        new Parameter("FriendlyName", "MyIpAddress"),
                        new Parameter("IpAddress", "10.0.0.1")
                }, null,
                "/sipdomains/ipaddress.json");
        checkIp(connector.addAccessControlListIp("TestIpAccessControlListSid", "MyIpAddress", "10.0.0.1"));
    }


    @Test
    public void updateAclIp() throws ZangException, IOException {
        createExpectation("POST", "SIP/IpAccessControlLists/TestIpAccessControlListSid/IpAddresses/TestIpAddressSid.json", new Parameter[]{
                new Parameter("FriendlyName", "NewIpAddress"),
                new Parameter("IpAddress", "10.0.0.2")
        }, null, "/sipdomains/ipaddress.json");
        checkIp(connector.updateAccessControlListIp("TestIpAccessControlListSid", "TestIpAddressSid", "NewIpAddress", "10.0.0.2"));
    }


    @Test
    public void deleteAclIp() throws ZangException, IOException {
        createExpectation("DELETE", "SIP/IpAccessControlLists/TestIpAccessControlListSid/IpAddresses/TestIpAddressSid.json", null, null,
                "/sipdomains/ipaddress.json");
        checkIp(connector.deleteAccessControlListIp("TestIpAccessControlListSid", "TestIpAddressSid"));
    }

    private void checkAcl(AccessControlList acl) {

    }

    private void checkIp(IpAddress ip) {

    }

}
