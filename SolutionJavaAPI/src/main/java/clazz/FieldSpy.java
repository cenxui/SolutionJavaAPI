package clazz;

import java.lang.reflect.Field;
import java.util.List;

public class FieldSpy <T>{
	public boolean[][] b = { { false, false }, { true, true } };
	public String name = "Alice";
	public List<Integer> list;
	public T val;

	public static void main(String[] args) {
		try {
			System.out.println("args " + args[0] + " , " + args[1]);
			Class<?> c = Class.forName(args[0]);
			Field f = c.getField(args[1]);
			System.out.format("Type: %s%n", f.getType());
			System.out.format("GenericType: %s%n", f.getGenericType());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

}
