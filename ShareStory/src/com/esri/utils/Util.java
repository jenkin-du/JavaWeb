package com.esri.utils;

import java.text.SimpleDateFormat;

public class Util {

	/**
	 * 获得唯一的序列号
	 * @return sequence
	 */
	public static String uniqueID() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS"); // 24小时制
		String prefix = sdf.format(System.currentTimeMillis());
		String suffix = String.valueOf((int) (1000 + Math.random() * 9000));

		String sequence = prefix + suffix;

		return sequence;

	}
}
