package com.zang.api;

import com.zang.api.connectors.ApplicationsConnector;
import com.zang.api.domain.Application;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.list.ApplicationsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.ApplicationParams;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.model.Parameter;

import java.io.IOException;


public class ApplicationsTest extends BaseZangTest {

    private ApplicationsConnector connector;

    @Before
    public void initConnector() {
        connector = connectorFactory.getApplicationsConnector();
    }

    @Test
    public void viewApplication() throws ZangException, IOException {
        createExpectation("GET", "Applications/TestApplicationSid.json", null, null,
                "/applications/application.json");
        Application application = connector.viewApplication("TestApplicationSid");
        checkApplication(application);
    }

    @Test
    public void listApplications() throws ZangException, IOException {
        createExpectation("GET", "Applications.json", null, new Parameter[]{
                        new Parameter("FriendlyName", "TestApplication"),
                        new Parameter("Page", "0"),
                        new Parameter("PageSize", "10"),
                },
                "/applications/applicationslist.json");

        ApplicationsList applications = connector.listApplications("TestAccountSid", "TestApplication", 0, 10);

        Assert.assertEquals(1, (int) applications.getTotal());
        checkApplication(applications.iterator().next());
    }

    @Test
    public void createApplication() throws ZangException, IOException {
        createExpectation("POST", "Applications.json", new Parameter[]{
                new Parameter("FriendlyName", "TestApplication"),
                new Parameter("VoiceUrl", "voiceUrl"),
                new Parameter("VoiceMethod", "POST"),
                new Parameter("VoiceFallbackUrl", "voiceFallbackUrl"),
                new Parameter("VoiceFallbackMethod", "GET"),
                new Parameter("VoiceCallerIdLookup", "true"),
                new Parameter("SmsUrl", "smsUrl"),
                new Parameter("SmsMethod", "POST"),
                new Parameter("SmsFallbackUrl", "smsFallbackUrl"),
                new Parameter("SmsFallbackMethod", "GET"),
                new Parameter("HeartbeatUrl", "heartbeatUrl"),
                new Parameter("HeartbeatMethod", "GET"),
                new Parameter("StatusCallback", "statusCallback"),
                new Parameter("StatusCallbackMethod", "POST"),
                new Parameter("HangupCallback", "hangupCallback"),
                new Parameter("HangupCallbackMethod", "GET")
        }, null, "/applications/application.json");
        Application application = connector.createApplication(
                ApplicationParams.builder().setAccountSid("TestAccountSid").setFriendlyName("TestApplication").setVoiceUrl("voiceUrl").setVoiceMethod(HttpMethod.POST).setVoiceFallbackUrl("voiceFallbackUrl").setVoiceFallbackMethod(HttpMethod.GET).setVoiceCallerIdLookup(true).setSmsUrl("smsUrl").setSmsMethod(HttpMethod.POST).setSmsFallbackUrl("smsFallbackUrl").setSmsFallbackMethod(HttpMethod.GET).setHeartbeatUrl("heartbeatUrl").setHeartbeatMethod(HttpMethod.GET).setStatusCallback("statusCallback").setStatusCallbackMethod(HttpMethod.POST).setHangupCallback("hangupCallback").setHangupCallbackMethod(HttpMethod.GET).build());

        checkApplication(application);
    }

    @Test
    public void updateApplication() throws ZangException, IOException {
        createExpectation("POST", "Applications/TestApplicationSid.json", new Parameter[]{
                new Parameter("FriendlyName", "TestApplication"),
                new Parameter("VoiceUrl", "voiceUrl"),
                new Parameter("VoiceMethod", "POST"),
                new Parameter("VoiceFallbackUrl", "voiceFallbackUrl"),
                new Parameter("VoiceFallbackMethod", "GET"),
                new Parameter("VoiceCallerIdLookup", "true"),
                new Parameter("SmsUrl", "smsUrl"),
                new Parameter("SmsMethod", "POST"),
                new Parameter("SmsFallbackUrl", "smsFallbackUrl"),
                new Parameter("SmsFallbackMethod", "GET"),
                new Parameter("HeartbeatUrl", "heartbeatUrl"),
                new Parameter("HeartbeatMethod", "GET"),
                new Parameter("StatusCallback", "statusCallback"),
                new Parameter("StatusCallbackMethod", "POST"),
                new Parameter("HangupCallback", "hangupCallback"),
                new Parameter("HangupCallbackMethod", "GET")
        }, null, "/applications/application.json");
        Application application = connector.updateApplication("TestAccountSid", "TestApplicationSid","TestApplication", "voiceUrl", HttpMethod.POST,
                "voiceFallbackUrl", HttpMethod.GET, true, "smsUrl", HttpMethod.POST, "smsFallbackUrl", HttpMethod.GET, "heartbeatUrl",
                HttpMethod.GET, "statusCallback", HttpMethod.POST, "hangupCallback", HttpMethod.GET);
        checkApplication(application);
    }

    @Test
    public void deleteApplication() throws ZangException, IOException {
        createExpectation("DELETE", "Applications/TestApplicationSid.json", null, null,
                "/applications/application.json");
        Application application = connector.deleteApplication("TestApplicationSid");
        checkApplication(application);
    }

    private void checkApplication(Application application) {
        Assert.assertEquals("TestApplicationSid", application.getSid());
        Assert.assertEquals("TestApplication", application.getFriendlyName());
    }

}
