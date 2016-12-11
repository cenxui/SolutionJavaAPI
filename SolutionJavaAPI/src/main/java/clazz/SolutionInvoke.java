package clazz;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SolutionInvoke {

	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("clazz.SolutionInvok");
			
			Object object = c.newInstance();
			
			Method[] methods = c.getDeclaredMethods();
			
			
			for (Method method : methods) {
				System.out.println(method.getName());
			}
			
			c.getMethod("show", String.class).invoke(object, "Hi John");
			
			System.out.println(c.getMethod("getName").invoke(object));
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	public String getName() {
		return "Hello World";
	}
	
	public void show(String word) {
		System.out.println(word);
	}
	
}
