package singleton;

import org.junit.runner.notification.RunListener.ThreadSafe;

/**
 * This singleton class is lazy initialize and thread safe with good efficiency.
 * 
 * Remember that the singleton class key point.
 * 
 * private constructor
 * 
 * static method to access static object.
 * 
 * lazy initialize when need and beware of thread safe
 * 
 * never implement cloneable, we means that never let it can be clone and instantiate.
 * 
 * 
 * @author cenxui
 *
 */

@ThreadSafe
public class SolutionSingletonLazy4 {
	
	private SolutionSingletonLazy4() {
		// TODO Auto-generated constructor stub
	}
	
	public static SolutionSingletonLazy4 getInstance() {
		return Resource.instance;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private static class Resource {
		private static SolutionSingletonLazy4 instance = new SolutionSingletonLazy4();
	}
}
