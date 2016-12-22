package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import annotation.SolutionAnnotation.Test;

public class RunTest {
	public static void main(String[] args) throws ClassNotFoundException {
		int tests = 0;
		int passed = 0;
		Class testClass = Class.forName("annotation.SolutionAnnotation");
		for(Method m:testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(Test.class)) {
				tests++;
				try {
					m.invoke(null);
					passed++;
				} catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					System.out.println(m + " failed: " + exc);
				} catch (Exception exc) {
					System.out.println("INVALID @Test: " + m);

				}
			}
		}System.out.printf("Passed: %d, Failed: %d%n",passed,tests-passed);
	}
	
}
