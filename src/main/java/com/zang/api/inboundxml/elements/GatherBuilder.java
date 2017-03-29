package com.zang.api.inboundxml.elements;

import com.zang.api.domain.enums.HttpMethod;

import java.util.ArrayList;
import java.util.List;

public class GatherBuilder {
    private List<GatherElement> content;
    private String action;
    private HttpMethod method;
    private Integer timeout;
    private String finishOnKey;
    private Integer numDigits;

    GatherBuilder() {
        this.content = new ArrayList<GatherElement>();
    }

    public GatherBuilder addElement(GatherElement element) {
        this.content.add(element);
        return this;
    }

    public GatherBuilder say(Say say) {
        this.content.add(say);
        return this;
    }

    public GatherBuilder play(Play play) {
        this.content.add(play);
        return this;
    }

    public GatherBuilder pause(Pause pause) {
        this.content.add(pause);
        return this;
    }

    public GatherBuilder playLastRecording(PlayLastRecording playLastRecording) {
        this.content.add(playLastRecording);
        return this;
    }

    public GatherBuilder setContent(List<GatherElement> content) {
        this.content = content;
        return this;
    }

    /**
     * URL where the flow of the call and the gathered digits will be forwarded to (if digits are input).
     * @param action
     * @return
     */
    public GatherBuilder setAction(String action) {
        this.action = action;
        return this;
    }

    /**
     * Method used to request the action URL. Default value is POST.
     * @param method
     * @return
     */
    public GatherBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    /**
     * The number of seconds <Gather> should wait for digits to be entered before requesting the action URL. Timeout resets with each new digit input. Default value is 5 seconds. Timeout accepts any integer greater than or equal to 0.
     * @param timeout
     * @return
     */
    public GatherBuilder setTimeout(Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    /**
     * The key a caller can press to end the <Gather>. Default value is #. Acceptable values are digits from 0 to 9, # or *
     * @param finishOnKey
     * @return
     */
    public GatherBuilder setFinishOnKey(String finishOnKey) {
        this.finishOnKey = finishOnKey;
        return this;
    }

    /**
     * The maximum number of digits to <Gather>. Default value is set to no limit. Acceptable value is any integer greater than or equal to 0.
     * @param numDigits
     * @return
     */
    public GatherBuilder setNumDigits(Integer numDigits) {
        this.numDigits = numDigits;
        return this;
    }

    public Gather build() {
        return new Gather(content, action, method, timeout, finishOnKey, numDigits);
    }
}