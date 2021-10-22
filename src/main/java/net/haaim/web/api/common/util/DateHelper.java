package net.haaim.web.api.common.util;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateHelper {
	
	private static final String YYYYMMDD_FORMAT = "yyyyMMdd";
	
	/**
	 * 기준 년,월에 해당하는 시작 일자를 포함하여 문자열을 반환한다.
	 * 값이 없는 경우 현재 일자 기준으로 반환한다.
	 * @param baseYear
	 * @param baseMonth
	 * @return
	 */
	public static String getStartDate(Integer baseYear, Integer baseMonth) {
		if(baseYear == null || baseMonth == null) {
			YearMonth now = YearMonth.now();
			return LocalDate.of(now.getYear(), now.getMonthValue(), 1).format(DateTimeFormatter.ofPattern(YYYYMMDD_FORMAT));
		} else {
			return LocalDate.of(baseYear, baseMonth, 1).format(DateTimeFormatter.ofPattern(YYYYMMDD_FORMAT));
		}
	}
	
	/**
	 * 기준 년,월에 해당하는 마지막 일자를 포함하여 문자열을 반환한다.
	 * 값이 없는 경우 현재 일자 기준으로 반환한다.
	 * @param baseYear
	 * @param baseMonth
	 * 
	 * @return "yyyyMMdd"
	 */
	public static String getEndDate(Integer baseYear, Integer baseMonth) {
		if(baseYear == null || baseMonth == null) {
			YearMonth now = YearMonth.now();
			return LocalDate.of(now.getYear(), now.getMonthValue(), now.lengthOfMonth()).format(DateTimeFormatter.ofPattern(YYYYMMDD_FORMAT));
		} else {
			return LocalDate.of(baseYear, baseMonth, YearMonth.of(baseYear, baseMonth).lengthOfMonth()).format(DateTimeFormatter.ofPattern(YYYYMMDD_FORMAT));
		}
	}
	
	/**
	 * 현재 일자에 포함되는 주(week)의 시작 일자를 구한다.
	 * 주 시작은 일요일.
	 * @return
	 */
	public static String getStartDateByWeekly() {
		LocalDate now = LocalDate.now();
		LocalDate changeDate = now.minusDays(now.getDayOfWeek().getValue());
		return changeDate.format(DateTimeFormatter.ofPattern(YYYYMMDD_FORMAT));
	}
}
