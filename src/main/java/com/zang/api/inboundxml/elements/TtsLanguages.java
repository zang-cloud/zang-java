package com.zang.api.inboundxml.elements;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "tts_languages")
@XmlEnum
public enum TtsLanguages {

    @XmlEnumValue("en")
    EN("en"),
    @XmlEnumValue("en-gb")
    EN_GB("en-gb"),
    @XmlEnumValue("es")
    ES("es"),
    @XmlEnumValue("fr")
    FR("fr"),
    @XmlEnumValue("it")
    IT("it"),
    @XmlEnumValue("de")
    DE("de");
    private final String value;

    TtsLanguages(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TtsLanguages fromValue(String v) {
        for (TtsLanguages c : TtsLanguages.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
