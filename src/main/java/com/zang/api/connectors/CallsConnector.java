package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.Call;
import com.zang.api.domain.enums.*;
import com.zang.api.domain.list.CallsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;
import com.zang.api.params.MakeCallParams;
import com.zang.api.restproxies.CallsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;

import javax.ws.rs.core.Response;
import java.util.Date;


public class CallsConnector extends BaseConnector {

    private CallsProxy callsProxy;

    /**
     * @see BaseConnector, PropertiesFileZangConfiguration,
     * ZangConfiguration
     */
    CallsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        callsProxy = createProxy(CallsProxy.class);
    }

    public Call viewCall(String accountSid, String callSid) throws ZangException {
        Response response = callsProxy.getCall(accountSid, callSid);
        return returnThrows(response, Call.class);
    }

    public Call viewCall(String callSid) throws ZangException {
        return viewCall(conf.getSid(), callSid);
    }


    public CallsList listCalls(String accountSid, String to, String from, CallStatus status, Date startTimeGte, Date startTimeLt, Integer page, Integer pageSize) throws ZangException {
        Response response = callsProxy.getCallsList(accountSid, to, from, status, getDateString(startTimeGte), getDateString(startTimeLt), page, pageSize);
        return returnThrows(response, CallsList.class);
    }

    public CallsList listCalls(String to, String from, CallStatus status, Date startTimeGte, Date startTimeLt, Integer page, Integer pageSize) throws ZangException {
        return listCalls(conf.getSid(), to, from, status, startTimeGte, startTimeLt, page, pageSize);
    }

    public CallsList listCalls() throws ZangException {
        return listCalls(conf.getSid(), null, null, null, null, null, null, null);
    }

    public Call makeCall(String accountSid, String to, String from, String url, HttpMethod method, String fallbackUrl, HttpMethod fallbackMethod, String statusCallback, HttpMethod statusCallbackMethod, String heartbeatUrl, HttpMethod heartbeatMethod, String forwardedFrom, String playDtmf, Integer timeout, Boolean hideCallerId, Boolean record, String recordCallback, HttpMethod recordCallbackMethod, Boolean transcribe, String transcribeCallback, Boolean straightToVoicemail, IfMachine ifMachine, String ifMachineUrl, HttpMethod ifMachineMethod, String sipAuthUsername, String sipAuthPassword) throws ZangException {
        Response response = callsProxy.makeCall(accountSid, to, from, url, method, fallbackUrl, fallbackMethod, statusCallback, statusCallbackMethod, heartbeatUrl, heartbeatMethod, forwardedFrom, playDtmf, timeout, hideCallerId, record, recordCallback, recordCallbackMethod, transcribe, transcribeCallback, straightToVoicemail, ifMachine, ifMachineUrl, ifMachineMethod, sipAuthUsername, sipAuthPassword);
        return returnThrows(response, Call.class);
    }

    public Call makeCall(MakeCallParams callParams) throws ZangException {
        return makeCall(callParams.getAccountSid() != null ? callParams.getAccountSid() : conf.getSid(), callParams.getTo(), callParams.getFrom(), callParams.getUrl(), callParams.getMethod(), callParams.getFallbackUrl(), callParams.getFallbackMethod(), callParams.getStatusCallback(), callParams.getStatusCallbackMethod(), callParams.getHeartbeatUrl(), callParams.getHeartbeatMethod(), callParams.getForwardedFrom(), callParams.getPlayDtmf(), callParams.getTimeout(), callParams.getHideCallerId(), callParams.getRecord(), callParams.getRecordCallback(), callParams.getRecordCallbackMethod(), callParams.getTranscribe(), callParams.getTranscribeCallback(), callParams.getStraightToVoicemail(), callParams.getIfMachine(), callParams.getIfMachineUrl(), callParams.getIfMachineMethod(), callParams.getSipAuthUsername(), callParams.getSipAuthPassword());
    }

    public Call interruptLiveCall(String accountSid, String callSid, String url, HttpMethod method, EndCallStatus status) throws ZangException {
        Response response = callsProxy.interruptLiveCall(accountSid, callSid, url, method, status);
        return returnThrows(response, Call.class);
    }

    public Call interruptLiveCall(String callSid, String url, HttpMethod method, EndCallStatus status) throws ZangException {
        return interruptLiveCall(conf.getSid(), callSid, url, method, status);
    }

    public Call sendDigitsToLiveCall(String accountSid, String callSid, String playDtmf, AudioDirection playDtmfDirection) throws ZangException {
        Response response = callsProxy.sendDigitsToLiveCall(accountSid, callSid, playDtmf, playDtmfDirection);
        return returnThrows(response, Call.class);
    }

    public Call sendDigitsToLiveCall(String callSid, String playDtmf, AudioDirection playDtmfDirection) throws ZangException {
        return sendDigitsToLiveCall(conf.getSid(), callSid, playDtmf, playDtmfDirection);
    }

    public Call recordLiveCall(String accountSid, String callSid, Boolean record, RecordingAudioDirection direction, Integer timeLimit, String callbackUrl, RecordingFileFormat fileFormat, Boolean trimSilence, Boolean transcribe, TranscribeQuality transcribeQuality, String transcribeCallback) throws ZangException {
        Response response = callsProxy.recordLiveCall(accountSid, callSid, record, direction, timeLimit, callbackUrl, fileFormat, trimSilence, true, transcribeQuality, transcribeCallback);
        return returnThrows(response, Call.class);
    }

    public Call recordLiveCall(String callSid, Boolean record, RecordingAudioDirection direction, Integer timeLimit, String callbackUrl, RecordingFileFormat fileFormat, Boolean trimSilence, Boolean transcribe, TranscribeQuality transcribeQuality, String transcribeCallback) throws ZangException {
        return recordLiveCall(conf.getSid(), callSid, record, direction, timeLimit, callbackUrl, fileFormat, trimSilence, true, transcribeQuality, transcribeCallback);
    }

    public Call playAudioToLiveCall(String accountSid, String callSid, String audioUrl, RecordingAudioDirection direction, Boolean loop) throws ZangException {
        Response response = callsProxy.playAudioToLiveCall(accountSid, callSid, audioUrl, direction, loop);
        return returnThrows(response, Call.class);
    }

    public Call playAudioToLiveCall(String callSid, String audioUrl, RecordingAudioDirection direction, Boolean loop) throws ZangException {
        return playAudioToLiveCall(conf.getSid(), callSid, audioUrl, direction, loop);
    }

    public Call applyVoiceEffect(String accountSid, String callSid, AudioDirection direction, Integer pitch, Integer pitchSemiTones, Integer pitchOctaves, Integer rate, Integer tempo) throws ZangException {
        Response response = callsProxy.applyVoiceEffect(accountSid, callSid, direction, pitch, pitchSemiTones, pitchOctaves, rate, tempo);
        return returnThrows(response, Call.class);
    }

    public Call applyVoiceEffect(String callSid, AudioDirection direction, Integer pitch, Integer pitchSemiTones, Integer pitchOctaves, Integer rate, Integer tempo) throws ZangException {
        return applyVoiceEffect(conf.getSid(), callSid, direction, pitch, pitchSemiTones, pitchOctaves, rate, tempo);
    }
}
