package com.zang.api;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.exceptions.ZangException;
import com.zang.api.inboundxml.elements.*;
import com.zang.api.inboundxml.elements.Number;
import com.zang.api.inboundxml.elements.enums.RejectReason;
import org.junit.Test;

public class InboundXmlTest {

    @Test
    public void createInboundXml() throws ZangException {
        String result =
                Response.builder()
                        .getSpeech(GetSpeech.builder()
                                .setMethod(HttpMethod.GET)
                                .setGrammar("grammar")
                                .build())
                        .dial(Dial.builder()
                                .setCallerId("123")
                                .setMethod(HttpMethod.GET)
                                .setHangupOnStar(true)
                                .conference(Conference.builder()
                                        .setName("My conference")
                                        .setHangupOnStar(true)
                                        .build())
                                .build())
                        .hangup(Hangup.builder()
                                .setReason(RejectReason.BUSY)
                                .setSchedule(12)
                                .build())
                        .build()
                        .toXml();

        System.out.println(result);
    }

    @Test
    public void createConferenceXml() throws ZangException {
        String result =
                Response.builder()
                        .dial(Dial.builder()
                                .conference(
                                        Conference.builder()
                                                .setName("TestConference")
                                                .setStartConferenceOnEnter(true)
                                                .setEndConferenceOnExit(true)
                                                .setMaxParticipants(10)
                                                .build())
                                .number(Number.builder().setNumber("+385981945644").build())
                                .build())
                        .say(Say.builder().setText("Welcome to Zang my friend!").build())
                        .build()
                        .toXml();

        System.out.println(result);
    }

}
