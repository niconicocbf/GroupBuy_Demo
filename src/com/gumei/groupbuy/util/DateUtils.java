package com.gumei.groupbuy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat sf = null;

	/* ��ȡϵͳʱ�� ��ʽΪ��"yyyy/MM/dd " */
	public static String getCurrentDate() {
		Date d = new Date();
		sf = new SimpleDateFormat("yyyy��MM��dd��");
		return sf.format(d);
	}

	/* ʱ���ת�����ַ��� */
	public static String getDateToString(long time) {
		Date d = new Date(time * 1000);
		sf = new SimpleDateFormat("yyyy��MM��dd��");
		return sf.format(d);
	}

	/* ʱ���ת�����ַ��� */
	public static String getDateToString3(long time) {
		Date d = new Date(time);
		sf = new SimpleDateFormat("HH:mm");
		return sf.format(d);
	}

	/* ʱ���ת�����ַ��� */
	public static String getDateToString1(long time) {
		Date d = new Date(time * 1000);
		sf = new SimpleDateFormat("yyyy-MM-dd");
		return sf.format(d);
	}

	/* ʱ���ת�����ַ��� */
	public static String getDateToString2(long time) {
		Date d = new Date(time * 1000);
		sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sf.format(d);
	}

	/* ���ַ���תΪʱ��� */
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

	// DateUtils.getCurrentDate(); //��ȡϵͳ��ǰʱ��
	//
	// DateUtils.getDateToString(ʱ���); //ʱ���תΪʱ���ʽ
	//
	// DateUtils.getStringToDate("ʱ���ʽ");//ʱ���ʽתΪʱ���
}