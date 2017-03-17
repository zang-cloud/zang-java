package com.zang.api;

import com.zang.api.connectors.CallsConnector;
import com.zang.api.domain.Call;
import com.zang.api.domain.enums.*;
import com.zang.api.domain.list.CallsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;
import com.zang.api.params.MakeCallParams;
import junit.framework.Assert;
import org.junit.Test;
import org.mockserver.model.Parameter;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;


public class CallsTest extends BaseZangTest {

    @Test
    public void viewCall() throws ZangException, IOException {
        createExpectation("GET", "Calls/TestCallSid.json", null, null,
                "/calls/call.json");
        CallsConnector connector = connectorFactory.getCallsConnector();
        Call call = connector.viewCall("TestCallSid");
        checkCall(call);
    }

    @Test
    public void listCalls() throws ZangException, IOException {
        createExpectation("GET", "Calls.json", null, new Parameter[]{
                        new Parameter("To", "+123456"),
                        new Parameter("From", "+654321"),
                        new Parameter("Status", "completed"),
                        new Parameter("StartTime>", "2000-01-22"),
                        new Parameter("StartTime<", "2017-03-20"),
                        new Parameter("Page", "0"),
                        new Parameter("PageSize", "10")
                },
                "/calls/callslist.json");
        CallsConnector connector = connectorFactory.getCallsConnector();
        Calendar from = Calendar.getInstance();
        from.set(2000, Calendar.JANUARY, 22);
        Calendar to = Calendar.getInstance();
        to.set(2017, Calendar.MARCH, 20);
        CallsList callsList = connector.listCalls(
                "+123456",
                "+654321",
                CallStatus.COMPLETED,
                from.getTime(),
                to.getTime(),
                0,
                10);
        Assert.assertEquals(1, (int) callsList.getTotal());
        checkCall(callsList.iterator().next());
    }

    @Test
    public void makeCall() throws ZangException, IOException {
        createExpectation("POST", "Calls.json", new Parameter[]{
                        new Parameter("To", "+123456"),
                        new Parameter("From", "+654321"),
                        new Parameter("Url", "TestUrl"),
                        new Parameter("Method", "GET"),
                        new Parameter("FallbackUrl", "FallbackUrl"),
                        new Parameter("FallbackMethod", "POST"),
                        new Parameter("StatusCallback", "StatusCallback"),
                        new Parameter("StatusCallbackMethod", "GET"),
                        new Parameter("HeartbeatUrl", "HeartbeatUrl"),
                        new Parameter("HeartbeatMethod", "GET"),
                        new Parameter("ForwardedFrom", "1234"),
                        new Parameter("PlayDtmf", "123#"),
                        new Parameter("Timeout", "122"),
                        new Parameter("HideCallerId", "true"),
                        new Parameter("Record", "true"),
                        new Parameter("RecordCallback", "RecordCallback"),
                        new Parameter("RecordCallbackMethod", "GET"),
                        new Parameter("Transcribe", "true"),
                        new Parameter("TranscribeCallback", "TranscribeCallback"),
                        new Parameter("StraightToVoicemail", "true"),
                        new Parameter("IfMachine", "redirect"),
                        new Parameter("IfMachineUrl", "IfMachineUrl"),
                        new Parameter("IfMachineMethod", "GET"),
                        new Parameter("SipAuthUsername", "username"),
                        new Parameter("SipAuthPassword", "password")
                }, null,
                "/calls/call.json");
        CallsConnector connector = connectorFactory.getCallsConnector();
        Call call = connector.makeCall(MakeCallParams.builder()
                .setTo("+123456")
                .setFrom("+654321")
                .setUrl("TestUrl")
                .setMethod(HttpMethod.GET)
                .setFallbackUrl("FallbackUrl")
                .setFallbackMethod(HttpMethod.POST)
                .setStatusCallback("StatusCallback")
                .setStatusCallbackMethod(HttpMethod.GET)
                .setHeartbeatUrl("HeartbeatUrl")
                .setHeartbeatMethod(HttpMethod.GET)
                .setForwardedFrom("1234")
                .setPlayDtmf("123#")
                .setTimeout(122)
                .setHideCallerId(true)
                .setRecord(true)
                .setRecordCallback("RecordCallback")
                .setRecordCallbackMethod(HttpMethod.GET)
                .setTranscribe(true)
                .setTranscribeCallback("TranscribeCallback")
                .setStraightToVoicemail(true)
                .setIfMachine(IfMachine.REDIRECT)
                .setIfMachineUrl("IfMachineUrl")
                .setIfMachineMethod(HttpMethod.GET)
                .setSipAuthUsername("username")
                .setSipAuthPassword("password")
                .build());
        checkCall(call);
    }

    @Test
    public void interruptLiveCall() throws ZangException, IOException {
        createExpectation("POST", "Calls/TestCallSid.json", new Parameter[]{
                        new Parameter("Url", "TestUrl"),
                        new Parameter("Method", "GET"),
                        new Parameter("Status", "canceled"),
                }, null,
                "/calls/call.json");
        CallsConnector connector = connectorFactory.getCallsConnector();
        Call call = connector.interruptLiveCall("TestCallSid", "TestUrl", HttpMethod.GET, EndCallStatus.CANCELED);
        checkCall(call);
    }

    @Test
    public void sendDigitsToLiveCall() throws ZangException, IOException {
        createExpectation("POST", "Calls/TestCallSid.json", new Parameter[]{
                        new Parameter("PlayDtmf", "0123#"),
                        new Parameter("PlayDtmfDirection", "out")
                }, null,
                "/calls/call.json");
        CallsConnector connector = connectorFactory.getCallsConnector();
        Call call = connector.sendDigitsToLiveCall("TestCallSid", "0123#", AudioDirection.OUT);
        checkCall(call);
    }

    @Test
    public void recordLiveCall() throws ZangException, IOException {
        createExpectation("POST", "Calls/TestCallSid/Recordings.json", new Parameter[]{
                        new Parameter("Record", "true"),
                        new Parameter("Direction", "both"),
                        new Parameter("TimeLimit", "15"),
                        new Parameter("CallbackUrl", "TestUrl"),
                        new Parameter("FileFormat", "mp3"),
                        new Parameter("TrimSilence", "true"),
                        new Parameter("Transcribe", "true"),
                        new Parameter("TranscribeQuality", "hybrid"),
                        new Parameter("TranscribeCallback", "TestTranscribeUrl"),
                }, null,
                "/calls/call.json");
        CallsConnector connector = connectorFactory.getCallsConnector();
        Call call = connector.recordLiveCall("TestCallSid", true, RecordingAudioDirection.BOTH, 15, "TestUrl", RecordingFileFormat.MP3, true, true, TranscribeQuality.HYBRID, "TestTranscribeUrl");
        checkCall(call);
    }

    @Test
    public void playAudioToLiveCall() throws ZangException, IOException {
        createExpectation("POST", "Calls/TestCallSid/Play.json", new Parameter[]{
                new Parameter("AudioUrl", "AudioUrl"),
                new Parameter("Direction", "both"),
                new Parameter("Loop", "true")
                }, null,
                "/calls/call.json");
        CallsConnector connector = connectorFactory.getCallsConnector();
        Call call = connector.playAudioToLiveCall("TestCallSid", "AudioUrl", RecordingAudioDirection.BOTH, true);
        checkCall(call);
    }

    @Test
    public void applyVoiceEffect() throws ZangException, IOException {
        createExpectation("POST", "Calls/TestCallSid/Effect.json", new Parameter[]{
                new Parameter("AudioDirection", "out"),
                        new Parameter("Pitch", "5"),
                        new Parameter("PitchSemiTones", "4"),
                        new Parameter("PitchOctaves", "3"),
                        new Parameter("Rate", "2"),
                        new Parameter("Tempo", "1"),
                }, null,
                "/calls/call.json");
        CallsConnector connector = connectorFactory.getCallsConnector();
        Call call = connector.applyVoiceEffect("TestCallSid", AudioDirection.OUT, 5, 4, 3, 2, 1);
        checkCall(call);
    }


    private void checkCall(Call call) {
        Assert.assertEquals(AnsweredBy.TBD, call.getAnsweredBy());
        BigDecimal expect = new BigDecimal(0.1872);
        BigDecimal receive = call.getPrice();
        expect = expect.setScale(4, BigDecimal.ROUND_HALF_UP);
        receive = receive.setScale(4, BigDecimal.ROUND_HALF_UP);
        Assert.assertEquals(0, expect.compareTo(receive));
        Assert.assertEquals(CallStatus.COMPLETED, call.getStatus());
    }

}
