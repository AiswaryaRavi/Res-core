package com.aishu.util;

public class ValidatorUtil {
	private ValidatorUtil() {
		throw new IllegalAccessError("Utility class");
	}

	public static boolean isInvalidString(String name) {
		return name == null || "".equals(name.trim());
	}

	public static boolean isInvalidNumber(Integer num) {
		return num == null || num <= 0;
	}

}
