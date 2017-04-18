package clone;

public class SolutionClone3 {
	private int id ;
	private static String name; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionClone3 solutionClone3 = new SolutionClone3();
		try {
			solutionClone3.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static private class SolutionClone4 extends SolutionClone3 {
		@Override
		protected Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return super.clone();
		}
	}
}
