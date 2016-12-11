package exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.internal.Streams;

public class SolutionArrayStoreException {

	public static void main(String[] args) {
		List<Integer> q = new LinkedList<>();
		q.add(10);
		q.add(12);
		q.remove(1);
		System.out.println(q);
		
		Collectors.toSet();
	
		
	}

	private static void method2() {
		List list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add(7);
		System.out.println(list);
	}

	private static void method1() {
		Integer[] numbers = {new Integer(10)};
		Object[] objects = numbers;
		objects[0] = "forty two";
	}

}
