package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionUnmodifiableList {
	private List<String> list = new ArrayList<>();

	public static void main(String[] args) {
		SolutionUnmodifiableList list = new SolutionUnmodifiableList();
		
		list.add("hello");
		list.add("word");
		list.add("val");
		
		System.out.println(list);
		
		List<String> result = list.getList();
		result.add("hi");//throw exception
		result.add("hello");
		System.out.println(result);
		
		

	}
	
	public List<String> getList() {
		return Collections.unmodifiableList(list);
	}
	
	public void add(String val) {
		list.add(val);
	}
	
	public String get(int index) {
		return list.get(index);
	}
	
	@Override
	public String toString() {
		return list.toString();
	}
	
}
