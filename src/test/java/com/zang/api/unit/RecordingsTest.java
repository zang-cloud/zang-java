package com.zang.api.unit;

import com.zang.api.connectors.RecordingsConnector;
import com.zang.api.domain.Recording;
import com.zang.api.domain.enums.RecordingAudioDirection;
import com.zang.api.domain.enums.TranscriptionQuality;
import com.zang.api.exceptions.ZangException;
import com.zang.api.inboundxml.elements.enums.RecordingFileFormat;
import com.zang.api.params.RecordCallParams;
import com.zang.api.testutil.TestParameters;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.model.Parameter;

import java.io.IOException;


public class RecordingsTest extends BaseUnitTest {

    private RecordingsConnector connector;

    @Before
    public void initConnector() {
        connector = connectorFactory.getRecordingsConnector();
    }

    @Test
    public void viewRecording() throws ZangException, IOException {
        createExpectation("GET", "Recordings/TestRecordingSid.json", null, null,
                "/recordings/recording.json");
        checkRecording(connector.viewRecording("TestRecordingSid"));
    }

    @Test
    public void listRecordings() throws ZangException, IOException {
        createExpectation("GET", "Recordings.json", null, new Parameter[]{
                        new Parameter("CallSid", "TestCallSid"),
                        new Parameter("DateCreated>", "2016-12-12"),
                        new Parameter("DateCreated<", "2017-03-19"),
                        new Parameter("Page", "0"),
                        new Parameter("PageSize", "33"),
                },
                "/recordings/recordingslist.json");
        connector.listRecordings("TestCallSid", TestParameters.getFromDate(), TestParameters.getToDate(), 0, 33);
    }

    @Test
    public void recordCall() throws ZangException, IOException {
        createExpectation("POST", "Calls/TestCallSid/Recordings.json", new Parameter[]{
                        new Parameter("", ""),
                        new Parameter("Record", "true"),
                        new Parameter("Direction", "out"),
                        new Parameter("TimeLimit", "1337"),
                        new Parameter("CallbackUrl", "CallbackUrl"),
                        new Parameter("FileFormat", "wav"),
                        new Parameter("TrimSilence", "true"),
                        new Parameter("Transcribe", "true"),
                        new Parameter("TranscribeQuality", "hybrid"),
                        new Parameter("TranscribeCallback", "TranscribeCallback")
                }, null,
                "/recordings/recording.json");
        checkRecording(connector.recordCall(RecordCallParams.builder()
                .setCallSid("TestCallSid")
                .setRecord(true)
                .setDirection(RecordingAudioDirection.OUT)
                .setTimeLimit(1337)
                .setCallbackUrl("CallbackUrl")
                .setFileFormat(RecordingFileFormat.WAV)
                .setTrimSilence(true)
                .setTranscribe(true)
                .setTranscriptionQuality(TranscriptionQuality.HYBRID)
                .setTranscribeCallback("TranscribeCallback")
                .build()));
    }

    @Test
    public void deleteRecording() throws ZangException, IOException {
        createExpectation("DELETE", "Recordings/TestRecordingSid.json", null, null,
                "/recordings/recording.json");
        checkRecording(connector.deleteRecording("TestRecordingSid"));
    }


    private void checkRecording(Recording recording) {
        Assert.assertEquals("http://recordings.telapi.com/{RecordingBucket}/TestRecordingSid.mp3", recording.getRecordingUrl());
    }

}
