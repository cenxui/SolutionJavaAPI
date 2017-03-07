package stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class SolutionCollectors {

	public static void main(String[] args) {
		String[] words = {"a", "b","c", "d","e","f","ff"};
		String[] dupWords = {"a", "b","c", "d","e","f","ff","d","e","f","ff"};
		
		Arrays.asList(words).stream().collect(Collectors.toSet()).forEach(action);;
		
		
	}

}
