package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.Recording;
import com.zang.api.domain.enums.RecordingAudioDirection;
import com.zang.api.domain.enums.TranscriptionQuality;
import com.zang.api.domain.list.RecordingsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;
import com.zang.api.params.RecordCallParams;
import com.zang.api.restproxies.RecordingsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;

import java.util.Date;


/**
 * Used for all forms of communication with the Recordings endpoint of the Zang REST API.
 * @see ZangConnectorFactory
 */
public class RecordingsConnector extends BaseConnector {

    private RecordingsProxy proxy;

    RecordingsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(RecordingsProxy.class);
    }


    public Recording viewRecording(String accountSid, String recordingSid) throws ZangException {
        return returnThrows(proxy.viewRecording(accountSid, recordingSid), Recording.class);
    }

    public Recording viewRecording(String recordingSid) throws ZangException {
        return viewRecording(conf.getSid(), recordingSid);
    }

    public RecordingsList listRecordings(String accountSid, String callSid, Date dateCreatedGte, Date dateCreatedLt, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listRecordings(accountSid, callSid, getDateString(dateCreatedGte), getDateString(dateCreatedLt), page, pageSize), RecordingsList.class);
    }

    public RecordingsList listRecordings(String callSid, Date dateCreatedGte, Date dateCreatedLt, Integer page, Integer pageSize) throws ZangException {
        return listRecordings(conf.getSid(), callSid, dateCreatedGte, dateCreatedLt, page, pageSize);
    }

    public Recording recordCall(String accountSid, String callSid, Boolean record, RecordingAudioDirection direction, Integer timeLimit, String callbackUrl, RecordingFileFormat fileFormat, Boolean trimSilence, Boolean transcribe, TranscriptionQuality transcriptionQuality, String transcribeCallback) throws ZangException {
        return returnThrows(proxy.recordCall(accountSid, callSid, record, direction, timeLimit, callbackUrl, fileFormat, trimSilence, transcribe, transcriptionQuality, transcribeCallback), Recording.class);
    }

    public Recording recordCall(String callSid, Boolean record, RecordingAudioDirection direction, Integer timeLimit, String callbackUrl, RecordingFileFormat fileFormat, Boolean trimSilence, Boolean transcribe, TranscriptionQuality transcriptionQuality, String transcribeCallback) throws ZangException {
        return recordCall(conf.getSid(), callSid, record, direction, timeLimit, callbackUrl, fileFormat, trimSilence, transcribe, transcriptionQuality, transcribeCallback);
    }

    public Recording recordCall(RecordCallParams params) throws ZangException {
        return recordCall(params.getAccountSid() != null ? params.getAccountSid() : conf.getSid(), params.getCallSid(), params.getRecord(), params.getDirection(), params.getTimeLimit(), params.getCallbackUrl(), params.getFileFormat(), params.getTrimSilence(), params.getTranscribe(), params.getTranscriptionQuality(), params.getTranscribeCallback());
    }

    public Recording deleteRecording(String accountSid, String recordingSid) throws ZangException {
        return returnThrows(proxy.deleteRecording(accountSid, recordingSid), Recording.class);
    }

    public Recording deleteRecording(String recordingSid) throws ZangException {
        return deleteRecording(conf.getSid(), recordingSid);
    }
}
