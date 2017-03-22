package com.zang.api.connectors;

import com.zang.api.configuration.ZangConfiguration;
import com.zang.api.domain.Transcription;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.enums.TranscriptionQuality;
import com.zang.api.domain.enums.TranscriptionStatus;
import com.zang.api.domain.list.TranscriptionsList;
import com.zang.api.exceptions.ZangException;
import com.zang.api.restproxies.TranscriptionsProxy;
import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;

import java.util.Date;


public class TranscriptionsConnector extends BaseConnector {

    private TranscriptionsProxy proxy;

    TranscriptionsConnector(ZangConfiguration conf, ClientHttpEngine executor) {
        super(conf, executor);
        proxy = createProxy(TranscriptionsProxy.class);
    }

    public Transcription viewTranscription(String accountSid, String transcriptionSid) throws ZangException {
        return returnThrows(proxy.viewTranscription(accountSid, transcriptionSid), Transcription.class);
    }

    public Transcription viewTranscription(String transcriptionSid) throws ZangException {
        return viewTranscription(conf.getSid(), transcriptionSid);
    }

    public TranscriptionsList listTranscriptions(String accountSid, TranscriptionStatus status, Date dateSentGte, Date dateSentLt, Integer page, Integer pageSize) throws ZangException {
        return returnThrows(proxy.listTranscriptions(accountSid, status, getDateString(dateSentGte), getDateString(dateSentLt), page, pageSize), TranscriptionsList.class);
    }

    public TranscriptionsList listTranscriptions(TranscriptionStatus status, Date dateSentGte, Date dateSentLt, Integer page, Integer pageSize) throws ZangException {
        return listTranscriptions(conf.getSid(), status, dateSentGte, dateSentLt, page, pageSize);
    }

    public TranscriptionsList listTranscriptions() throws ZangException {
        return listTranscriptions(conf.getSid(), null, null, null, null, null);
    }

    public Transcription transcribeRecording(String accountSid, String recordingSid, String transcribeCallback, HttpMethod callbackMethod, Integer sliceStart, Integer sliceDuration, TranscriptionQuality quality) throws ZangException {
        return returnThrows(proxy.transcribeRecording(accountSid, recordingSid, transcribeCallback, callbackMethod, sliceStart, sliceDuration, quality), Transcription.class);
    }

    public Transcription transcribeRecording(String recordingSid, String transcribeCallback, HttpMethod callbackMethod, Integer sliceStart, Integer sliceDuration, TranscriptionQuality quality) throws ZangException {
        return transcribeRecording(conf.getSid(), recordingSid, transcribeCallback, callbackMethod, sliceStart, sliceDuration, quality);
    }

    public Transcription transcribeAudioUrl(String accountSid, String audioUrl, String transcribeCallback, HttpMethod callbackMethod, Integer sliceStart, Integer sliceDuration, TranscriptionQuality quality) throws ZangException {
        return returnThrows(proxy.transcribeAudioUrl(accountSid, audioUrl, transcribeCallback, callbackMethod, sliceStart, sliceDuration, quality), Transcription.class);
    }

    public Transcription transcribeAudioUrl(String audioUrl, String transcribeCallback, HttpMethod callbackMethod, Integer sliceStart, Integer sliceDuration, TranscriptionQuality quality) throws ZangException {
        return transcribeAudioUrl(conf.getSid(), audioUrl, transcribeCallback, callbackMethod, sliceStart, sliceDuration, quality);
    }
}


