package stream;

import java.io.Console;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.stream.Stream;

public class SolutionStream {

	public static void main(String[] args) {
		Stream<Integer> ints = Stream.of(1,2,3);
		ints.forEach((Integer i) -> {System.out.print(i*2);});
		ints.forEach(System.out::print);
		
		
	}

	private static void method1() {
		SolutionStream solutionStream = new SolutionStream();
		Stream<String> fruitStream = Stream.of("apple", "banana", "pear", "kiwi", "orange");
		fruitStream.filter(s -> s.contains("a"))			
			.map(SolutionStream::add)
			.map(solutionStream::edit)
			.forEach(System.out::println);
	}
	
	public static String add(String s) {
		return "a " + s;
	}
	
	public String edit(String s) {
		return "This is " + s;
	}
}
