package com.zang.api.inboundxml.elements.enums;

import java.util.HashMap;
import java.util.Map;

import com.zang.api.domain.enums.util.EnumUtil;

public enum Voice {
	MAN, WOMAN;
	
	private static Map<Voice, String> map;
	
	static {
		map = new HashMap<Voice, String>();
		map.put(MAN, "man");
		map.put(WOMAN, "woman");
	}
	
	public static Voice forValue(String s) {
		return EnumUtil.getValue(s, map, null);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
	
}
