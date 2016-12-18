package singleton;

public class SolutionSingleton {

	private static final SolutionSingleton instance = new SolutionSingleton();
	
	private SolutionSingleton() {
		//throw new AssertionError();
	}
	
	
	public static void main(String[] args) {
		SolutionSingleton singleton = getInstance();
		System.out.println("singleton");
	}

	public static SolutionSingleton getInstance() {
		
		return instance;
	}
}
