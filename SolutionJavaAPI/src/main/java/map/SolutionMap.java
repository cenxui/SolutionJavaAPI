package map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class SolutionMap {

	public static void main(String[] args) {
		Map map = new HashMap<>();
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);
		map.put("Four", 4);
		TreeMap<String, Integer> treeMap = new TreeMap<>(map);
		System.out.println(treeMap.ceilingKey("O"));
	}
}
