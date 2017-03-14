package com.zang.api;

import com.zang.api.exceptions.ZangException;
import com.zang.api.inboundxml.ZangInboundXml;
import com.zang.api.inboundxml.elements.SayVoice;
import com.zang.api.inboundxml.elements.TtsLanguages;
import org.junit.Test;

public class InboundXmlTest {

    @Test
    public void createInboundXml() throws ZangException {
        String result = ZangInboundXml.create()
                .say("Hello there", SayVoice.MALE, TtsLanguages.EN, null)
                .say("How are you?", SayVoice.FEMALE, TtsLanguages.EN, null)
                .sip("lel@lel.com", null, null, "a", "b", null)
                .build();
        System.out.println(result);
    }

}
