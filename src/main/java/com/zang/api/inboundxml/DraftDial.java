package com.zang.api.inboundxml;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.inboundxml.elements.Dial;
import com.zang.api.inboundxml.elements.Sip;

public class DraftDial {

    private Dial dial;

    DraftDial() {
        dial = new Dial();
    }



    public Dial build() {
        return dial;
    }

    public DraftDial sip(Sip sip) {
        dial.getContent().add(sip);
        return this;
    }

    public DraftDial sip(String sipAddress, String action, HttpMethod method, String username, String password, String sendDigits) {
        Sip sip = new Sip();
        sip.setContent(sipAddress);
        sip.setAction(action);
        sip.setMethod(method != null ? method.toString() : null);
        sip.setUsername(username);
        sip.setPassword(password);
        sip.setSendDigits(sendDigits);
        return this.sip(sip);
    }



}
