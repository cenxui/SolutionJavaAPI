package system;

public class SolutionSecurityManager {

	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();
		
		ClassLoader.getSystemClassLoader();
		
		
		System.out.println(SecurityManager.class == SecurityManager.class);
		
		try {
			System.out.println(SecurityManager.class == Class.forName("java.lang.SecurityManager"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Class<SecurityManager> class1 = SecurityManager.class;
		
		System.out.println(class1);
		try {
			System.out.println(Class.forName("java.lang.SecurityManager"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
