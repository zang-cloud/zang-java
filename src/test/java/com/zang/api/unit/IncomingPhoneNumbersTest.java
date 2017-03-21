package com.zang.api.unit;

import com.zang.api.connectors.IncomingPhoneNumbersConnector;
import com.zang.api.domain.IncomingPhoneNumber;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.exceptions.ZangException;
import com.zang.api.params.PurchaseIncomingNumberParams;
import com.zang.api.params.UpdateIncomingNumberParams;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.model.Parameter;

import java.io.IOException;

public class IncomingPhoneNumbersTest extends BaseUnitTest {

    private IncomingPhoneNumbersConnector connector;

    @Before
    public void initConnector() {
        connector = connectorFactory.getIncomingPhoneNumbersConnector();
    }


    @Test
    public void viewIncomingPhoneNumber() throws ZangException, IOException {
        createExpectation("GET", "IncomingPhoneNumbers/TestIncomingPhoneNumberSid.json", null, null,
                "/incomingphonenumbers/incomingphonenumber.json");
        check(connector.viewIncomingNumber("TestIncomingPhoneNumberSid"));
    }

    @Test
    public void listIncomingPhoneNumbers() throws ZangException, IOException {
        createExpectation("GET", "IncomingPhoneNumbers.json", null, new Parameter[]{
                new Parameter("Contains", "123"),
                new Parameter("FriendlyName", "MyNumber"),
                new Parameter("Page", "0"),
                new Parameter("PageSize", "25")
        }, "/incomingphonenumbers/incomingphonenumberslist.json");

        check(connector.listIncomingNumbers("123", "MyNumber", 0, 25)
                .iterator().next());

    }

    @Test
    public void purchaseIncomingPhoneNumber() throws ZangException, IOException {
        createExpectation("POST", "IncomingPhoneNumbers.json", new Parameter[]{
                        new Parameter("FriendlyName", "MyNumber"),
                        new Parameter("PhoneNumber", "+1234"),
                        new Parameter("AreaCode", "123"),
                        new Parameter("VoiceCallerIdLookup", "true"),
                        new Parameter("VoiceApplicationSid", "VoiceApplicationSid"),
                        new Parameter("SmsApplicationSid", "SmsApplicationSid"),
                        new Parameter("VoiceUrl", "VoiceUrl"),
                        new Parameter("VoiceMethod", "GET"),
                        new Parameter("VoiceFallbackUrl", "VoiceFallbackUrl"),
                        new Parameter("VoiceFallbackMethod", "GET"),
                        new Parameter("SmsUrl", "SmsUrl"),
                        new Parameter("SmsMethod", "GET"),
                        new Parameter("SmsFallbackUrl", "SmsFallbackUrl"),
                        new Parameter("SmsFallbackMethod", "POST"),
                        new Parameter("HeartbeatUrl", "HeartbeatUrl"),
                        new Parameter("HeartbeatMethod", "POST"),
                        new Parameter("StatusCallback", "StatusCallback"),
                        new Parameter("StatusCallbackMethod", "POST"),
                        new Parameter("HangupCallback", "HangupCallback"),
                        new Parameter("HangupCallbackMethod", "POST")
                }, null,
                "/incomingphonenumbers/incomingphonenumber.json");

        check(connector.purchaseIncomingNumber(PurchaseIncomingNumberParams.builder()
                .setFriendlyName("MyNumber")
                .setPhoneNumber("+1234")
                .setAreaCode("123")
                .setVoiceCallerIdLookup(true)
                .setVoiceApplicationSid("VoiceApplicationSid")
                .setSmsApplicationSid("SmsApplicationSid")
                .setVoiceUrl("VoiceUrl")
                .setVoiceMethod(HttpMethod.GET)
                .setVoiceFallbackUrl("VoiceFallbackUrl")
                .setVoiceFallbackMethod(HttpMethod.GET)
                .setSmsUrl("SmsUrl")
                .setSmsMethod(HttpMethod.GET)
                .setSmsFallbackUrl("SmsFallbackUrl")
                .setSmsFallbackMethod(HttpMethod.POST)
                .setHeartbeatUrl("HeartbeatUrl")
                .setHeartbeatMethod(HttpMethod.POST)
                .setStatusCallback("StatusCallback")
                .setStatusCallbackMethod(HttpMethod.POST)
                .setHangupCallback("HangupCallback")
                .setHangupCallbackMethod(HttpMethod.POST)
                .build()));
    }

    @Test
    public void updateIncomingPhoneNumber() throws ZangException, IOException {
        createExpectation("POST", "IncomingPhoneNumbers/TestIncomingPhoneNumberSid.json", new Parameter[]{
                        new Parameter("FriendlyName", "MyNumber"),
                        new Parameter("VoiceCallerIdLookup", "true"),
                        new Parameter("VoiceUrl", "VoiceUrl"),
                        new Parameter("VoiceMethod", "GET"),
                        new Parameter("VoiceFallbackUrl", "VoiceFallbackUrl"),
                        new Parameter("VoiceFallbackMethod", "GET"),
                        new Parameter("SmsUrl", "SmsUrl"),
                        new Parameter("SmsMethod", "GET"),
                        new Parameter("SmsFallbackUrl", "SmsFallbackUrl"),
                        new Parameter("SmsFallbackMethod", "POST"),
                        new Parameter("HeartbeatUrl", "HeartbeatUrl"),
                        new Parameter("HeartbeatMethod", "POST"),
                        new Parameter("StatusCallback", "StatusCallback"),
                        new Parameter("StatusCallbackMethod", "POST"),
                        new Parameter("HangupCallback", "HangupCallback"),
                        new Parameter("HangupCallbackMethod", "POST")
                }, null,
                "/incomingphonenumbers/incomingphonenumber.json");

        check(connector.updateIncomingNumber(UpdateIncomingNumberParams.builder()
                .setIncomingPhoneNumberSid("TestIncomingPhoneNumberSid")
                .setFriendlyName("MyNumber")
                .setVoiceCallerIdLookup(true)
                .setVoiceUrl("VoiceUrl")
                .setVoiceMethod(HttpMethod.GET)
                .setVoiceFallbackUrl("VoiceFallbackUrl")
                .setVoiceFallbackMethod(HttpMethod.GET)
                .setSmsUrl("SmsUrl")
                .setSmsMethod(HttpMethod.GET)
                .setSmsFallbackUrl("SmsFallbackUrl")
                .setSmsFallbackMethod(HttpMethod.POST)
                .setHeartbeatUrl("HeartbeatUrl")
                .setHeartbeatMethod(HttpMethod.POST)
                .setStatusCallback("StatusCallback")
                .setStatusCallbackMethod(HttpMethod.POST)
                .setHangupCallback("HangupCallback")
                .setHangupCallbackMethod(HttpMethod.POST)
                .build()));
    }

    @Test
    public void deleteIncomingPhoneNumber() throws ZangException, IOException {
        createExpectation("DELETE", "IncomingPhoneNumbers/TestIncomingPhoneNumberSid.json", null, null,
                "/incomingphonenumbers/incomingphonenumber.json");
        check(connector.deleteIncomingNumber("TestIncomingPhoneNumberSid"));
    }

    private void check(IncomingPhoneNumber ipn) {

    }

}
