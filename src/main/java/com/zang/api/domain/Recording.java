package com.zang.api.domain;

import com.zang.api.json.JsonDurationParser;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 * Recorded calls can be viewed using the REST API. All
 * recordings are represented as the same type of resource, regardless of
 * whether initiated via InboundXML or the REST API.
 */
public class Recording extends BaseZangObject {
    @JsonProperty("call_sid")
    private String callSid;
    @JsonDeserialize(using = JsonDurationParser.class)
    private Integer duration;
    @JsonProperty("recording_url")
    private String recordingUrl;

    /**
     * @return The sid identifying the recorded call.
     */
    public String getCallSid() {
        return callSid;
    }

    public void setCallSid(String callSid) {
        this.callSid = callSid;
    }

    /**
     * @return Time of recording in seconds.
     */
    public Integer getDuration() {
        return duration;
    }

    @JsonDeserialize(using = JsonDurationParser.class)
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * @return URL where .mp3 or .wav file of the recording is located.
     */
    public String getRecordingUrl() {
        return recordingUrl;
    }

    public void setRecordingUrl(String recordingUrl) {
        this.recordingUrl = recordingUrl;
    }

}