package com.gumei.groupbuy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat sf = null;

	/* 获取系统时间 格式为："yyyy/MM/dd " */
	public static String getCurrentDate() {
		Date d = new Date();
		sf = new SimpleDateFormat("yyyy年MM月dd日");
		return sf.format(d);
	}

	/* 时间戳转换成字符窜 */
	public static String getDateToString(long time) {
		Date d = new Date(time * 1000);
		sf = new SimpleDateFormat("yyyy年MM月dd日");
		return sf.format(d);
	}

	/* 时间戳转换成字符窜 */
	public static String getDateToString3(long time) {
		Date d = new Date(time);
		sf = new SimpleDateFormat("HH:mm");
		return sf.format(d);
	}

	/* 时间戳转换成字符窜 */
	public static String getDateToString1(long time) {
		Date d = new Date(time * 1000);
		sf = new SimpleDateFormat("yyyy-MM-dd");
		return sf.format(d);
	}

	/* 时间戳转换成字符窜 */
	public static String getDateToString2(long time) {
		Date d = new Date(time * 1000);
		sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sf.format(d);
	}

	/* 将字符串转为时间戳 */
	public static long getStringToDate(String time) {
		sf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date();
		try {
			date = sf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date.getTime();
	}

	// DateUtils.getCurrentDate(); //获取系统当前时间
	//
	// DateUtils.getDateToString(时间戳); //时间戳转为时间格式
	//
	// DateUtils.getStringToDate("时间格式");//时间格式转为时间戳
}