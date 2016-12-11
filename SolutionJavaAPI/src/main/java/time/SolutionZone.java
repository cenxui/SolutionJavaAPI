package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class SolutionZone {
	public static void main(String[] args) {
		LocalDateTime localDateTime = LocalDateTime.now();
		ZoneId zone = ZoneId.of("US/Eastern");
		
		System.out.println(ZonedDateTime.of(localDateTime, zone));
		
	}
}
