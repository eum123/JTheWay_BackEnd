package net.haaim.web.api.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class DateHelperTest {

	@Test
	public void startDateTest() {
		String value = DateHelper.getStartDate(null, null);
		YearMonth returnValue  = YearMonth.parse(value, DateTimeFormatter.ofPattern("yyyyMMdd"));
		
		YearMonth now = YearMonth.now();
		
		assertEquals(returnValue.getYear(), now.getYear());
		
		assertEquals(returnValue.getMonthValue(), now.getMonthValue());
		
		
		System.out.println(value);
	}
	
	@Test
	public void aStartDateTest() {
		String value = DateHelper.getStartDate(2020, 9);
		YearMonth returnValue  = YearMonth.parse(value, DateTimeFormatter.ofPattern("yyyyMMdd"));
		
		assertEquals(returnValue.getYear(), 2020);
		
		assertEquals(returnValue.getMonthValue(), 9);
	}
	
	@Test
	public void endDateTest() {
		String value = DateHelper.getEndDate(null, null);
		LocalDate returnValue  = LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyyMMdd"));
		
		LocalDate now = LocalDate.now();
		
		assertEquals(returnValue.getYear(), now.getYear());
		
		assertEquals(returnValue.getMonthValue(), now.getMonthValue());
		
		assertEquals(returnValue.getDayOfMonth(), now.lengthOfMonth());
		
		
		System.out.println(value);
	}
	
	@Test
	public void aEndDateTest() {
		String value = DateHelper.getEndDate(2020, 9);
		LocalDate returnValue  = LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyyMMdd"));
		
		assertEquals(returnValue.getYear(), 2020);
		
		assertEquals(returnValue.getMonthValue(), 9);
		
		assertEquals(returnValue.getDayOfMonth(), 30);
	}
	
	@Test
	public void getStartDateByWeekly() {
		String startDateWeekly = DateHelper.getStartDateByWeek();
		System.out.println(startDateWeekly);
	}
	
	@Test
	public void dateTest() {
		LocalDate d = LocalDate.parse("20211115", DateTimeFormatter.ofPattern("yyyyMMdd"));
		System.out.println(d);
		System.out.println(d.getDayOfMonth());
	}
	
	@Test
	public void getStartDateByNextWeek() {
		String baseDate = "20210404";
		
		System.out.println(DateHelper.getStartDateByNextWeek(baseDate));
		
	}
}
