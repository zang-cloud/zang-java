package com.zang.api.inboundxml.elements;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "say_voice")
@XmlEnum
public enum SayVoice {

    @XmlEnumValue("female")
    FEMALE("female"),
    @XmlEnumValue("male")
    MALE("male");
    private final String value;

    SayVoice(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SayVoice fromValue(String v) {
        for (SayVoice c : SayVoice.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
