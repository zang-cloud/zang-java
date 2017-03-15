package com.zang.api.inboundxml.elements;

import com.zang.api.inboundxml.elements.enums.RejectReason;

public class HangupBuilder {
    private Integer schedule;
    private RejectReason reason;

    HangupBuilder() {
    }

    public HangupBuilder setSchedule(Integer schedule) {
        this.schedule = schedule;
        return this;
    }

    public HangupBuilder setReason(RejectReason reason) {
        this.reason = reason;
        return this;
    }

    public Hangup build() {
        return new Hangup(schedule, reason);
    }
}