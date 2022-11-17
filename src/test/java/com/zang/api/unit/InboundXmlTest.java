package com.zang.api.unit;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.enums.IfMachine;
import com.zang.api.domain.enums.RecordingAudioDirection;
import com.zang.api.domain.enums.TranscriptionQuality;
import com.zang.api.exceptions.ZangException;
import com.zang.api.inboundxml.ZangInboundXml;
import com.zang.api.inboundxml.elements.*;
import com.zang.api.inboundxml.elements.Number;
import com.zang.api.inboundxml.elements.enums.*;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InboundXmlTest {

    @Test
    public void createInboundXml() throws ZangException {
        String result =
                ZangInboundXml.builder()
                        .getSpeech(GetSpeech.builder()
                                .setMethod(HttpMethod.GET)
                                .setGrammar("grammar")
                                .setPlayBeep(true)
                                .setTimeout(12)
                                .setAction("http://action.com")
                                .play(Play.builder()
                                        .setLoop(12)
                                        .setMethod(HttpMethod.GET)
                                        .setUrl("http://myurl.com")
                                        .build())
                                .pause(Pause.builder().setLength(12).build())
                                .say(Say.builder()
                                        .setLanguage(Language.DE)
                                        .setLoop(12)
                                        .setText("Hello")
                                        .setVoice(Voice.FEMALE)
                                        .build())
                                .build())
                        .dial(Dial.builder()
                                .setMethod(HttpMethod.GET)
                                .setTimeout(12)
                                .setHangupOnStar(true)
                                .setTimeLimit(122)
                                .setCallerId("123")
                                .setHideCallerId(false)
                                .setCallerName("Rocky Balboa")
                                .setDialMusic("music.mp3")
                                .setCallbackUrl("callback")
                                .setCallbackMethod(HttpMethod.GET)
                                .setConfirmSound("sound.mp3")
                                .setDigitsMatch("123")
                                .setStraightToVm(false)
                                .setHeartbeatUrl("heartbeat")
                                .setHeartbeatMethod(HttpMethod.GET)
                                .setAction("action")
                                .setForwardedFrom("564")
                                .setRecord(true)
                                .setRecordDirection(RecordingAudioDirection.IN)
                                .setRecordCallbackUrl("recordcallback")
                                .setRecordLifetime(33)
                                .setRecordFormat(RecordingFileFormat.MP3)
                                .setIfMachine(IfMachine.CONTINUE)
                                .setIfMachineMethod(HttpMethod.GET)
                                .setIfMachineUrl("ifmachineurl")
                                .setOutboundAction(true)
                                .conference(Conference.builder()
                                        .setName("My conference")
                                        .setMuted(false)
                                        .setBeep(true)
                                        .setStartConferenceOnEnter(true)
                                        .setEndConferenceOnExit(true)
                                        .setMaxParticipants(12)
                                        .setWaitSound("waitsound.mp3")
                                        .setHangupOnStar(true)
                                        .setCallbackMethod(HttpMethod.GET)
                                        .setCallbackUrl("callback")
                                        .setDigitsMatch("222")
                                        .setStayAlone(true)
                                        .setRecord(true)
                                        .setRecordCallbackUrl("recordcallback")
                                        .setRecordCallbackMethod(HttpMethod.GET)
                                        .setRecordFileFormat(RecordingFileFormat.MP3)
                                        .setMethod(HttpMethod.GET)
                                        .setWaitMethod(HttpMethod.GET)
                                        .setWaitSoundMethod(HttpMethod.POST)
                                        .setWaitUrl("waiturl")
                                        .build())
                                .number(Number.builder()
                                        .setNumber("123")
                                        .setMethod(HttpMethod.GET)
                                        .setSendDigits("123")
                                        .setSendOnPreanswer(true)
                                        .setUrl("url")
                                        .build())
                                .sip(Sip.builder()
                                        .setAction("action")
                                        .setMethod(HttpMethod.GET)
                                        .setPassword("pass")
                                        .setSendDigits("123")
                                        .setSipAddress("sip")
                                        .setUsername("username")
                                        .build())
                                .build())

                        .hangup(Hangup.builder()
                                .setReason(RejectReason.BUSY)
                                .setSchedule(12)
                                .build())
                        .ping(Ping.builder()
                                .setMethod(HttpMethod.GET)
                                .setUrl("ping.com")
                                .build())
                        .record(Record.builder()
                                .build())
                        .reject(Reject.builder().setReason(RejectReason.BUSY).build())
                        .redirect(Redirect.builder()
                                .setMethod(HttpMethod.GET)
                                .setUrl("redirect.com")
                                .build())
                        .gather(Gather.builder()
                                .setAction("action")
                                .setFinishOnKey("#")
                                .setMethod(HttpMethod.POST)
                                .setNumDigits(12)
                                .setTimeout(24)
                                .pause(Pause.builder().build())
                                .play(Play.builder().build())
                                .playLastRecording(PlayLastRecording.builder().build())
                                .say(Say.builder().build())
                                .build())
                        .sms(Sms.builder()
                                .setAction("action")
                                .setMethod(HttpMethod.POST)
                                .setFrom("+123")
                                .setStatusCallback("statuscallback")
                                .setStatusCallbackMethod(HttpMethod.GET)
                                .setTo("+12312")
                                .setText("Hello")
                                .build())
                        .record(Record.builder()
                                .setAction("action")
                                .setMethod(HttpMethod.POST)
                                .setTimeout(12)
                                .setFinishOnKey("$")
                                .setMaxLength(22)
                                .setTranscribe(true)
                                .setTranscribeCallback("trcallback")
                                .setTranscriptionQuality(TranscriptionQuality.AUTO)
                                .setSliceStart(12)
                                .setSliceDuration(22)
                                .setPlayBeep(true)
                                .setBothLegs(true)
                                .setFileFormat(RecordingFileFormat.WAV)
                                .setDirection(RecordingAudioDirection.BOTH)
                                .setBackground(true)
                                .setSampleRate(SamplingRate.SR_32000)
                                .setTrimSilence(true)
                                .setLifetime(33)
                                .build())
                        .refer(Refer.builder()
                                .setAction("action")
                                .setMethod(HttpMethod.POST)
                                .setTimeout( 180)
                                .setCallbackUrl("callbackURL")
                                .setCallbackMethod(HttpMethod.POST)
                                .sip(Sip.builder()
                                        .setAction("action")
                                        .setMethod(HttpMethod.GET)
                                        .setPassword("pass")
                                        .setSendDigits("123")
                                        .setSipAddress("username@example.com")
                                        .setUsername("username")
                                        .build())
                                .build())
                        .build()
                        .toXml();

        System.out.println(result);
    }

    @Test
    public void createConferenceXml() throws ZangException {
        String result =
                Response.builder()
                        .dial(Dial.builder()
                                .conference(
                                        Conference.builder()
                                                .setName("TestConference")
                                                .setStartConferenceOnEnter(true)
                                                .setEndConferenceOnExit(true)
                                                .setMaxParticipants(10)
                                                .build())
                                .number(Number.builder().setNumber("+385981945644").build())
                                .build())
                        .say(Say.builder().setText("Welcome to Zang my friend!").build())
                        .build()
                        .toXml();

        System.out.println(result);
    }

    @Test
    public void createConnectXml() throws ZangException {
    	String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Response><Connect action=\"http://sample\" method=\"POST\"><Agent>1234</Agent></Connect></Response>";
        String result =
                Response.builder()
                        .connect(Connect.builder()
                                .agent(Agent.builder()
                                                .setAgentId("1234")
                                                .build())
                                .setAction("http://sample")
                                .setMethod(HttpMethod.POST)
                                .build())
                        .build()
                        .toXml();
        assertEquals(expected.replaceAll("[\\r\\n\\t\\s]+",""), result.replaceAll("[\\r\\n\\t\\s]+",""));
    }

    @Test
    public void createReferXml() throws ZangException {
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Response><Refer action=\"https://example.com/actionURL\" method=\"POST\" timeout=\"180\" callbackUrl=\"https://example.com/callbackURL\" callbackMethod=\"POST\"><Sip username=\"username\" password=\"pass\">username@example.com</Sip></Refer></Response>";
        String result =
                Response.builder()
                        .refer(Refer.builder()
                                .setAction("https://example.com/actionURL")
                                .setMethod(HttpMethod.POST)
                                .setTimeout( 180)
                                .setCallbackUrl("https://example.com/callbackURL")
                                .setCallbackMethod(HttpMethod.POST)
                                .sip(Sip.builder()
                                        .setPassword("pass")
                                        .setSipAddress("username@example.com")
                                        .setUsername("username")
                                        .build())
                                .build())
                        .build()
                        .toXml();
        assertEquals(expected.replaceAll("[\\r\\n\\t\\s]+",""), result.replaceAll("[\\r\\n\\t\\s]+",""));
    }
}
