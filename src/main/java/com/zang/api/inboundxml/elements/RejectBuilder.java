package com.zang.api.inboundxml.elements;

import com.zang.api.inboundxml.elements.enums.RejectReason;

public class RejectBuilder {
    private RejectReason reason;

    RejectBuilder() {
    }

    public RejectBuilder setReason(RejectReason reason) {
        this.reason = reason;
        return this;
    }

    public Reject build() {
        return new Reject(reason);
    }
}