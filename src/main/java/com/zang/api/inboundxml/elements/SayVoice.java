
package com.zang.api.inboundxml.elements;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for say_voice.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="say_voice">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="female"/>
 *     &lt;enumeration value="male"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
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
        for (SayVoice c: SayVoice.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
