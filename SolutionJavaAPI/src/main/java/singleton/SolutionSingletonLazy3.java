package singleton;

import org.junit.runner.notification.RunListener.ThreadSafe;

/**
 * This  singleton class is lazy initialize and thread safe with good efficiency.
 * @author cenxui
 * 2017/3/13
 */

@ThreadSafe
public class SolutionSingletonLazy3 {
	private static SolutionSingletonLazy3 instance = null;
	
	private SolutionSingletonLazy3() {
		
	}
	
	public static SolutionSingletonLazy3 getInstance() {
		if (instance == null) {
			synchronized (instance) {
				if (instance == null) {
					instance = new SolutionSingletonLazy3();
				}
			}
		}
		return instance;
	}
	
}
