package lambda;

import java.util.Comparator;

public class SolutionCompare {

	public static void main(String[] args) {
		Comparator<Integer> comparator = Comparator.nullsLast(Integer::compare);
		System.out.println(comparator.compare(null, 10));

	}

}
