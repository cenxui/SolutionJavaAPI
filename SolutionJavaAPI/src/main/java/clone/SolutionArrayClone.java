package clone;

public class SolutionArrayClone {

	private int number;
	public static void main(String[] args) {
		Thing[] things = {new Thing(), new Thing(), new Thing()};
		
		Thing[] cloneThings = things.clone();
		
		
		System.out.println(things[0].id + " : " + cloneThings[0].id);
		
		cloneThings[0].id = 100;
		
		System.out.println(things[0].id + " : " + cloneThings[0].id);
		
		
	}

	private static class Thing implements Cloneable {
		static int count = 0;
		int id;
		
		public Thing () {
			id = count++;
		}
	}
}
