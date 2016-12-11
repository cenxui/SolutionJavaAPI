package locale;

import java.io.Console;
import java.lang.reflect.Executable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class SoutionLocale {

	public static void main(String[] args) {
		Locale locale = Locale.getDefault();
		System.out.println(locale);
		
		Locale hi = new Locale("hi");
		Locale hiIN = new Locale("hi", "IN");
		
	   

	}

}
