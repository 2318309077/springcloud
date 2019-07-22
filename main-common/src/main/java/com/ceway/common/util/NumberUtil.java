package com.ceway.common.util;

import java.util.regex.Pattern;

public class NumberUtil {

	/**
	 * 判断字符串是否由数字组成
	 * 宣志
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}
}
