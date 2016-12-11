package time;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.xml.crypto.Data;

public class SolutionOldNew {

	public static void main(String[] args) {

		System.out.println(Instant.now());
		System.out.println(LocalDateTime.now());
		
	}

	private static void newWay() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd-hh:mm:ss");
		System.out.println(LocalDateTime.now().format(f));
	}

	private static void oldWay() {
		Date date = new Date();	
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
		System.out.println(sf.format(date));
	}

}
