package stream;

import java.util.Arrays;
import java.util.List;

public class SolutionString {

	public static void main(String[] args) {
		 List<Integer> list = Arrays.asList(4,6,12,66,3);
		    
		    String s = list.stream().map(i -> {
		    	return ""+ (i+1);
		    }).reduce("", String:: concat);
		    System.out.println(s);

	}

}
