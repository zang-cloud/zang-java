package com.zang.api.unit;

import com.zang.api.connectors.TranscriptionsConnector;
import com.zang.api.domain.Transcription;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.enums.TranscriptionQuality;
import com.zang.api.domain.enums.TranscriptionStatus;
import com.zang.api.exceptions.ZangException;
import com.zang.api.testutil.TestParameters;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.model.Parameter;

import java.io.IOException;


public class TranscriptionsTest extends BaseUnitTest {

    private TranscriptionsConnector connector;

    @Before
    public void initConnector() {
        connector = connectorFactory.getTranscriptionsConnector();
    }

    @Test
    public void viewTranscription() throws ZangException, IOException {
        createExpectation("GET", "Transcriptions/TestTranscriptionSid.json", null, null,
                "/transcriptions/transcription.json");
        checkTranscription(connector.viewTranscription("TestTranscriptionSid"));
    }

    @Test
    public void listTranscriptions() throws ZangException, IOException {
        createExpectation("GET", "Transcriptions.json", null, new Parameter[]{
                        new Parameter("Status", "completed"),
                        new Parameter("DateTranscribed>", "2016-12-12"),
                        new Parameter("DateTranscribed<", "2017-03-19"),
                        new Parameter("Page", "0"),
                        new Parameter("PageSize", "33"),
                },
                "/transcriptions/transcriptionslist.json");
        connector.listTranscriptions(TranscriptionStatus.COMPLETED, TestParameters.getFromDate(), TestParameters.getToDate(), 0, 33);
    }

    @Test
    public void transcribeRecording() throws ZangException, IOException {
        createExpectation("POST", "Recordings/TestRecordingSid/Transcriptions.json", new Parameter[]{
                        new Parameter("TranscribeCallback", "TranscribeCallback"),
                        new Parameter("CallbackMethod", "GET"),
                        new Parameter("SliceStart", "0"),
                        new Parameter("SliceDuration", "33"),
                        new Parameter("Quality", "hybrid"),
                }, null,
                "/transcriptions/transcription.json");
        checkTranscription(connector.transcribeRecording("TestRecordingSid",
                "TranscribeCallback",
                HttpMethod.GET, 0, 33, TranscriptionQuality.HYBRID));
    }

    @Test
    public void transcribeAudioUrl() throws ZangException, IOException {
        createExpectation("POST", "Transcriptions.json", new Parameter[]{
                        new Parameter("AudioUrl", "AudioUrl"),
                        new Parameter("TranscribeCallback", "TranscribeCallback"),
                        new Parameter("CallbackMethod", "GET"),
                        new Parameter("SliceStart", "0"),
                        new Parameter("SliceDuration", "33"),
                        new Parameter("Quality", "auto"),
                }, null,
                "/transcriptions/transcription.json");
        checkTranscription(connector.transcribeAudioUrl("AudioURl",
                "TranscribeCallback",
                HttpMethod.GET, 0, 33, TranscriptionQuality.AUTO));
    }


    private void checkTranscription(Transcription transcription) {
    }

}
