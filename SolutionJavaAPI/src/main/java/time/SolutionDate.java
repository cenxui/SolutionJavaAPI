package time;

import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.ForkJoinTask;

public class SolutionDate {

	public static void main(String[] args) {
		Period period = Period.of(1, 2, 1);
		LocalDate localDate = LocalDate.of(2015, 1, 1);
		localDate = localDate.plusDays(period.getDays());
		System.out.println("Local date" + localDate);	
	}

}
