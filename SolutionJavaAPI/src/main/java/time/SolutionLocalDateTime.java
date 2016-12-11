package time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class SolutionLocalDateTime {

	public static void main(String[] args) {
//		System.out.println(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));
//		LocalDate localTime = LocalDate.of(2016, 4, 40);
//		System.out.println(localTime);
		
		
		LocalDate date = LocalDate.of(2016,  Month.MARCH, 13);
		LocalTime time = LocalTime.of(1, 30);
		ZoneId zoneId = ZoneId.of("US/Eastern");
		ZonedDateTime dateTime1 = ZonedDateTime.of(date, time, zoneId);
		ZonedDateTime dateTime2 = dateTime1.plus(2, ChronoUnit.HOURS);
		
		long hours = ChronoUnit.HOURS.between(dateTime1, dateTime2);
		
		int clock1 = dateTime1.getHour();
		int clock2 = dateTime2.getHour();
		System.out.println("dateTime1 : " + dateTime1);
		System.out.println("dateTime2 : " + dateTime2);
		System.out.println(hours + "," + clock1 + "," + clock2);
		
	}

	private static void dateTime2() {
		System.out.println(Instant.now());
		
		System.out.println(ZonedDateTime.now());
		
		LocalDateTime d = LocalDateTime.of(2015,  5 , 10, 11, 22 , 33);
		Period p = Period.ofDays(1).ofYears(2);
		d = d.minus(p);
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		System.out.println(f.format(d));
	}

	private static void time1(LocalDateTime d) {
		Period p = Period.of(1, 2, 3);
		d = d.minus(p);
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(d.format(f));
	}

}
