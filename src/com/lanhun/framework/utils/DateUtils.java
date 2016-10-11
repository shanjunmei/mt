package com.lanhun.framework.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateUtils {
	
	private final static String DATE_TIME_PATTERN="yyyy-MM-dd HH:mm:ss";
	private final static String DATE_PATTERN="yyyy-MM-dd";
	/*private final static SimpleDateFormat dateTimeFormat=new SimpleDateFormat(DATE_TIME_PATTERN);
	private final static SimpleDateFormat dateFormat=new SimpleDateFormat(DATE_PATTERN);	*/
	public static SimpleDateFormat getDateTimeFormator(){
		return getDateFormator(DATE_TIME_PATTERN);
	}
	public static SimpleDateFormat getDateFormator(String pattern){
		SimpleDateFormat dateFormat=new SimpleDateFormat(pattern);
		return dateFormat;
	}
	public static SimpleDateFormat getDateFormator(){
		return getDateFormator(DATE_PATTERN);
	}
	
	public static java.util.Date getDayBegin(java.util.Date da) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(da);

		cal.set(11, 0);
		cal.set(12, 0);
		cal.set(13, 0);
		cal.set(14, 0);
		java.util.Date ds = new java.util.Date(cal.getTimeInMillis());
		return ds;
	}
	public static java.util.Date getNextDay(java.util.Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(5, cal.get(5) + 1);
		return cal.getTime();
	}
	public static java.util.Date parse(Object source){
		try {
			return getDateTimeFormator().parse(source.toString());
		} catch (ParseException e) {
			try {
			return	getDateFormator().parse(source.toString());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
}
