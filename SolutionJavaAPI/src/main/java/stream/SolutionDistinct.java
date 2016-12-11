package stream;

import static java.lang.System.out;

import java.util.stream.Stream;

public class SolutionDistinct {

	public static void main(String[] args) {
		Stream<String> s = Stream.of("duck","duck", "duck", "goose");
		s.distinct().forEach(out::println);

	}

}
