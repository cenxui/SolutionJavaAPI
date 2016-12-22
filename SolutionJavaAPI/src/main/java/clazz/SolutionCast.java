package clazz;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;

public class SolutionCast {
	
	private Map<Class<?>, Object> map = new HashMap<>();

	public static void main(String[] args) {
		

	}
	
	public <T> void putMap(Class<T> type, T instance) {
		if (type == null) {
			throw new NullPointerException("Type is null");
		}
		map.put(type, instance);
	}
	
	public <T> T getMap(Class<T> type) {
		return type.cast(map.get(type));
	}
	
	static Annotation getAnnotation(AnnotatedElement element, String typeName) {
		Class<?> type = null;
		
		try{
			type = Class.forName(typeName);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
		return element.getAnnotation(type.asSubclass(Annotation.class));
		
	}
	
}
