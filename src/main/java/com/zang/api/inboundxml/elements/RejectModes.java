
package com.zang.api.inboundxml.elements;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for reject_modes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="reject_modes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="busy"/>
 *     &lt;enumeration value="rejected"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
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
        for (RejectModes c: RejectModes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
