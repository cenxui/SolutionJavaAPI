package meto;

import java.io.IOException;
import java.time.LocalDateTime;

public class SolutionMeto {

	public static void main(String[] args) throws IOException {
		System.out.println("饅頭早安");
		
		LocalDateTime time = LocalDateTime.now();
		System.out.println("現在時間" + time);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		System.out.println("經過時間 : " + Period.between(startDateInclusive, endDateExclusive));
		System.out.println("葛格早安");
	}

}
