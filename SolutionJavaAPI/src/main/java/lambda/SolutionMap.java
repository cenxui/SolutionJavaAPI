package lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class SolutionMap {

	public static void main(String[] args) {
		BiFunction<String, String, String> mapper = 
				(v1, v2) -> v1.length()> v2.length()? v1:v2;
			
		Map<String, String> fa = new HashMap<>();
		fa.put("Sam", null);
		fa.merge("Tom", "Skyride", mapper);
		fa.merge("Sam", "Skyride", mapper);
		System.out.println(fa);
	}

}
