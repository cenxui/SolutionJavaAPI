package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author cenxui
 * {@link http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html}
 */

public class SolutionRegular {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("a*b");
		Matcher m = pattern.matcher("aaaaab");
		System.out.println(m.matches());
		
	}

}
