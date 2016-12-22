package enums;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Herb {
	enum Type {
		ABNUAL, PERENNIAL, BIENNIAL
	}
	
	final String name;
	final Type type;
	
	public Herb(String name, Type type) {
		this.name = name;
		this.type = type;
	}
	@Override
	public String toString() {
		return name;
	}
	
	public static void main(String[] args) {
		Herb[] garden  = new Herb[10];
		Map<Herb.Type, Set<Herb>> herbsByeType =
				new EnumMap<>(Herb.Type.class);
		for (Herb.Type t : Herb.Type.values())
			herbsByeType.put(t, new HashSet<Herb>());
		for (Herb herb : garden) 
			herbsByeType.get(herb.type).add(herb);
		
	}
	
	
	private static void error() {
		Herb[] garden  = new Herb[10];
		
		Set<Herb>[] herbByType = (Set<Herb>[]) new Set[Herb.Type.values().length];
		for (int i = 0; i < herbByType.length; i++) {
			herbByType[i] = new HashSet<>();
		}
		
		for (Herb herb : garden) {
			herbByType[herb.type.ordinal()].add(herb);
		}
		
		for (int i = 0; i < herbByType.length; i++) {
			
		}
	}
}
