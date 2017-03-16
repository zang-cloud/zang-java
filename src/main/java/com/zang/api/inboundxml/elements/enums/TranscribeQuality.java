package com.zang.api.inboundxml.elements.enums;

import com.zang.api.domain.enums.util.EnumUtil;

import javax.xml.bind.annotation.XmlEnumValue;
import java.util.HashMap;
import java.util.Map;

public enum TranscribeQuality {
    @XmlEnumValue("auto")
    AUTO,
    @XmlEnumValue("hybrid")
    HYBRID;

    private static Map<TranscribeQuality, String> map;

    static {
        map = new HashMap<TranscribeQuality, String>();
        map.put(AUTO, "auto");
        map.put(HYBRID, "hybrid");
    }

    public static TranscribeQuality forValue(String s) {
        return EnumUtil.getValue(s, map, null);
    }

    @Override
    public String toString() {
        return map.get(this);
    }
}