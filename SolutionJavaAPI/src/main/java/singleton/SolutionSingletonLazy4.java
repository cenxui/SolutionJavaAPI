package singleton;

import org.junit.runner.notification.RunListener.ThreadSafe;

/**
 * This singleton class is lazy initialize and thread safe with good efficiency/
 * @author cenxui
 *
 */

@ThreadSafe
class SolutionSingletonLazy4 {
	
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
