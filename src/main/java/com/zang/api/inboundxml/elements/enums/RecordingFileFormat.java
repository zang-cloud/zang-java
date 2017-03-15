package com.zang.api.inboundxml.elements.enums;

import com.zang.api.domain.enums.util.EnumUtil;

import java.util.HashMap;
import java.util.Map;

public enum RecordingFileFormat {
    MP3, WAV;

    private static Map<RecordingFileFormat, String> map;

    static {
        map = new HashMap<RecordingFileFormat, String>();
        map.put(MP3, "mp3");
        map.put(WAV, "wav");
    }

    public static RecordingFileFormat forValue(String s) {
        return EnumUtil.getValue(s, map, null);
    }

    @Override
    public String toString() {
        return map.get(this);
    }
}
