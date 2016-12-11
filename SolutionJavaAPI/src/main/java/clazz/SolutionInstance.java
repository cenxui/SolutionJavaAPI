package clazz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SolutionInstance {

	public static void main(String[] args) {
		try {
			Constructor<?> c = SolutionInstance.class.getConstructor();
			c.newInstance();
			
			Constructor<?> b = SolutionInstance.class.getConstructor(String.class);

			b.newInstance("Hi John");
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public SolutionInstance(String word) {
		System.out.println(word);
	}
	
	public SolutionInstance() {
		this("Hello World");
	}
	
}
