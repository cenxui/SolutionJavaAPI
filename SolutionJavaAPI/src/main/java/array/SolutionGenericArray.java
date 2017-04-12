package array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SolutionGenericArray {

	public static void main(String[] args) {
		System.out.print("work");
	}
	
	static  <E> Object reduce(List<E> list, Function<E> function, E initial) {
		List<E> snap;
		synchronized (list) {
			snap = new ArrayList<>();
			
		}
		
		E result = initial;
		
		for (E e : snap) {
			result = function.apply(result, e);
		}
		return result;
	}

	interface Function<T> {
		T apply(T arg1, T arg2);
	}
	
	static <T extends Comparable<? super T>> T max(List<? extends T>  list) {
		Iterator<? extends T> iterator = list.iterator();
		T result = iterator.next();
		while (iterator.hasNext()) {
			T t = iterator.next();
			if (t.compareTo(result) > 0) {
				result = t;
			}
			return result;
		}
		
	}
}
