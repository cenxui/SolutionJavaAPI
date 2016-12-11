package time;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class SolutionInstant {
	public static void main(String[] args) {
		Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
		System.out.println(instant);
		Instant nextDay = instant.plus(1, ChronoUnit.DAYS);
		System.out.println(nextDay);
		Instant nextHour = instant.plus(1, ChronoUnit.HOURS);
		System.out.println(nextHour);
//		Instant nextWeek = instant.plus(1, ChronoUnit.MONTHS); error
//		System.out.println(nextWeek);
	}
}
