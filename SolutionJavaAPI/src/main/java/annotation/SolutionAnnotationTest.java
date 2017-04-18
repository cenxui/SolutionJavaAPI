package annotation;

import java.lang.annotation.Native;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

import com.google.gson.internal.Streams;

import annotation.interfaces.ClassInterface;
import annotation.interfaces.Fresh;
import annotation.interfaces.FruitType;
import annotation.interfaces.Fruits;
import annotation.interfaces.RunWith;
import annotation.interfaces.TypeCast;

@RunWith(SolutionAnnotationTest.class)
public class SolutionAnnotationTest {

	public static void main(String[] args) {
		Class<Apple> apple  = Apple.class;
		
//		Object object =  new @ClassInterface Object();
//		
//		String string = (@TypeCast String)object;
		
		System.out.println("AnnotatedInterfaces : " + apple.getAnnotatedInterfaces().length);
		
		System.out.println("Annotations : " + apple.getAnnotations().length); 
		
		System.out.println("" + apple.getConstructors().length);
		
		
		
		
		Arrays.asList(apple.getConstructors()[0].getAnnotations()).forEach(System.out::println);

	}

	@Fruits(type = FruitType.APPLE, regions = "Japan")
	private static class Apple {
		
		@RunWith(Apple.class)
		@Fruits(type = FruitType.APPLE, regions = "Japen")
		public Apple() {
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * 
		 */
		@Fresh
		public void eat(String food) {
			
		}
	}
	
	private static class JapanApple extends Apple {
	
	}
}
