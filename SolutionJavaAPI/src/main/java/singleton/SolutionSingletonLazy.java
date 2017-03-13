package singleton;

/**
 * This singleton class is lazy initialize but not thread safe.
 * @author cenxui
 *
 */

@NotThreadSafe
public class SolutionSingletonLazy {
	private static SolutionSingletonLazy instance = null;
	
	private SolutionSingletonLazy() {
		
	}
	
	public static SolutionSingletonLazy getInstance() {
		if (instance == null) {
			instance = new SolutionSingletonLazy();
		}
		return instance;
	}

}
