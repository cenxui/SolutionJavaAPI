package lambda;

import static java.lang.System.out;

import java.util.Optional;

public class SolutionOptional {

	public static void main(String[] args) {
		
		out.println(average(100,90));
		out.println(average(new int[0]));		
		
		Optional<Double> opt = average(90,100);
		
		if (opt.isPresent()) {
			out.println(opt.get());
		}
		opt = average();
		opt.ifPresent(out::println);
		out.println(opt.orElse(Double.NaN));
		out.println(opt.orElseGet(()-> Math.random()));
		out.println(opt.orElseThrow(()->new IllegalStateException()));

	}

	public static Optional<Double> average(int... scores ) {
		if (scores.length == 0) {
			return Optional.empty();
		}
		int sum = 0;
		for (int score: scores) sum += score;
		return Optional.of((double) sum/scores.length);
	}
}
