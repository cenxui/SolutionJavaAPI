package stream;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class SolutionComparator {

	public static void main(String[] args) {
		TreeSet<E>
	}

	private static void example6() {
		BinaryOperator<Integer> op  = (a,b) ->a*b;
		Stream<Integer> stream = Stream.of(3,5,6);
		out.println(stream.reduce(1, op,op));
	}

	private static void example5() {
		BinaryOperator<Integer> op = (a, b) -> a*b;
		Stream<Integer> empty = Stream.empty();
		Stream<Integer> oneElement = Stream.of(3);
		Stream<Integer> threeElement = Stream.of(3,5,6);
		empty.reduce(op).ifPresent(out::println);
		oneElement.reduce(op).ifPresent(out::println);
		threeElement.reduce(op).ifPresent(out::println);
	}

	private static void example4() {
		List<String> list = Arrays.asList("monkey", "2", "chimp");
		Stream<String> infinite = Stream.generate(()-> "chimp");
		Predicate<String> pred = x-> Character.isLetter(x.charAt(0));
		out.println(list.stream().anyMatch(pred));
		out.println(list.stream().allMatch(pred));
		out.println(list.stream().noneMatch(pred));
		out.println(infinite.anyMatch(pred));
	}

	private static void example3() {
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		Stream<String> infinite = Stream.generate(()-> "chimo");
		s.findAny().ifPresent(out::println);
		infinite.findAny().ifPresent(out::println);
	}

	private static void example2() {
		Optional<?> minEmpty = Stream.empty().min((s1,s2)->0);
		out.println(minEmpty.isPresent());
	}

	private static void example1() {
		Stream<String> s = Stream.of("monkey", "ape", "bonabo");
		Optional<String> min = s.min((s1,s2)-> s1.length() - s2.length());
		min.ifPresent(out::println);
	}
	


}
