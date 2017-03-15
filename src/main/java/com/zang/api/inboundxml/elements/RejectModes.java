package com.zang.api.inboundxml.elements;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "reject_modes")
@XmlEnum
public enum RejectModes {

    @XmlEnumValue("busy")
    BUSY("busy"),
    @XmlEnumValue("rejected")
    REJECTED("rejected");
    private final String value;

    RejectModes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RejectModes fromValue(String v) {
        for (RejectModes c : RejectModes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
