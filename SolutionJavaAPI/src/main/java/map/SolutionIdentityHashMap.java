package map;

import java.awt.print.Printable;
import java.util.IdentityHashMap;
import java.util.Map;

public class SolutionIdentityHashMap {

	public static void main(String[] args) {
		Map<Object, String> map = new IdentityHashMap<>();
		
		for (int i = 0; i <10 ; i++)
			print();
		
		
		
	}
	
	public static void print() {
		System.out.println("Object : " + System.identityHashCode(new Object()));
	}
	
	
	private class MyThread extends Thread {
		
	}
	


}
