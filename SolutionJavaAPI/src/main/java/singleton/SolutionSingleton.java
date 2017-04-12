package singleton;

import org.junit.runner.notification.RunListener.ThreadSafe;

@ThreadSafe
public class SolutionSingleton {

	private static final SolutionSingleton instance = new SolutionSingleton();
	
	private SolutionSingleton() {
	}
	
	
	public static void main(String[] args) {
		SolutionSingleton singleton = getInstance();
		System.out.println("singleton");
	}

	public static SolutionSingleton getInstance() {
		
		return instance;
	}
}
