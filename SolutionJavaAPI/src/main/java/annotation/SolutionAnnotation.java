package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class SolutionAnnotation {

	public static void main(String[] args) {
		// TODO Auto-gener;
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	public @interface Test {
	}

	@Test
	public static void m1() {

	}

	public static void m2() {

	}

	@Test
	public static void m3() {
		throw new RuntimeException("Boom");
	}

	public static void m4() {
	}

	@Test
	public void m5() {
	} // INVALID USE: nonstatic method 
	public static void m6() { } 
	@Test public static void m7() { // Test should fail
		throw new RuntimeException("Crash"); }
	public static void m8() { }
}
