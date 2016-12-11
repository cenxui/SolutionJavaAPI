package stream;

import java.io.Console;
import java.io.FileReader;
import java.io.OptionalDataException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import relation2.Test.staticclass;

public class SolutionStream {

	public static void main(String[] args) {
//		String[] in = new String[3];
//		String op1 = Optional.of(int[2])
//		Stream<String> stream = Stream.iterate("", (s) -> s + "1");
//		stream.forEach(System.out::println);
//		System.out.println(stream.limit(2).map(x -> x +"2"));
		
//		Predicate<? super String> p = s-> s.startsWith("g");
//		Stream<String> stream1 = Stream.generate(()-> "grow! ");
//		stream1.forEach(System.out::print);
//		Stream<String> stream2 = Stream.generate(()-> "grow! ");
//		boolean b1 = stream1.anyMatch(p);
//		boolean b2 = stream2.allMatch(p);
//		System.out.println(b1 + " " );
		
//		Predicate<? super String> predicate = s -> s.length() >3;
//		Stream<String> stream = Stream.iterate("-", (s) -> s+s);
//		boolean b1 = stream.noneMatch(predicate);
//		System.out.println(b1);
// 		boolean b2 = stream.anyMatch(predicate);
// 		System.out.println(b2);
// 		IntStream is = IntStream.empty();
		
//		List<Integer> l1 = Arrays.asList(1, 2, 3);
//		List<Integer> l2 = Arrays.asList(4, 5, 6);
//		List<Integer> l3 = Arrays.asList();
//		Stream.of(l1,l2,l3).map(x-> x+1).
//		
//		Stream<Integer> s= Stream.of(1);
//		IntStream is = s.mapToInt(x -> x);
//		DoubleStream ds = s.mapToDouble(x->x);
//		Stream<Integer> s2 = ds.mapToInt(x->x);
//		
		Stream<String> s = Stream.empty();
		Stream<String> s2 = Stream.empty();
		Map<Boolean, List<String>> p = s.collect(Collectors.partitioningBy(b -> b.startsWith("c")));
		Map<Object, List<String>> g = s2.collect(Collectors.groupingBy(b-> b.startsWith("c")));
		
		System.out.println(p );
		System.out.println(g);
 		
		
		
		System.out.println(Stream.iterate(1,  x-> ++x).limit(5).map(x->"" + x).collect(Collectors.joining("")));
	}

	private static void stream2() {
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
