package time;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class SolutionPeriod {

	public static void main(String[] args) {
		System.out.println(Duration.of(1, ChronoUnit.MINUTES));
		System.out.println(Duration.ofMinutes(1));
		System.out.println(Duration.of(60, ChronoUnit.SECONDS));
		System.out.println(Duration.ofDays(1));
		System.out.println(Period.ofDays(1));
	
	}

	private static void period1() {
		Instant now = Instant.now();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Instant later = Instant.now();
		
		Duration duration = Duration.between(now, later);
		System.out.println(duration.toMinutes());
	}

}
