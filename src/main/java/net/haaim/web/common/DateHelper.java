package net.haaim.web.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
	
	/**
	 * 입력한 날짜를 String format(yyyyMMddHHmmss)으로 변환한다.
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 */
	public static String toString(int year, int month, int day, int hour, int minute, int second) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date(year, month, day, hour, minute, second));
	}
	
	public static String toNowString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}
}
