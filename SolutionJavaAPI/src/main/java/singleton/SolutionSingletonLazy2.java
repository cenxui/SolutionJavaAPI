package singleton;

import org.junit.runner.notification.RunListener.ThreadSafe;

/**
 * This singleton class is lazy initialize and thread safe but not efficiently.
 * @author cenxui
 *
 */

@ThreadSafe
public class SolutionSingletonLazy2 {
	private static SolutionSingletonLazy2 instance = null;
	
	private SolutionSingletonLazy2() {
		
	}
	
	public static SolutionSingletonLazy2 getInstance() {
		synchronized (instance) {
			if (instance == null) {
				instance = new SolutionSingletonLazy2();
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
