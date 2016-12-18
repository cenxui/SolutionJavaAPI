package referance;

import java.lang.ref.WeakReference;
import java.util.HashMap;

public class SoluionWeakReference {
	private WeakReference<HashMap<String, Integer>> weakReference =
			new WeakReference<HashMap<String, Integer>>(new HashMap<>());

	public static void main(String[] args) {
		
	}
	
	public void getValue() {
		HashMap< String , Integer > map = weakReference.get();
	}
	
}
