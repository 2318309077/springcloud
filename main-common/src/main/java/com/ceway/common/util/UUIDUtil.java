package com.ceway.common.util;

import java.util.UUID;

public class UUIDUtil {
	public static String randomUUID() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		return uuid;
	}
}
