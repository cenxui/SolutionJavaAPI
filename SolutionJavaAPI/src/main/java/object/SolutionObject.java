package object;

public class SolutionObject {

	public static void main(String[] args) {
		Object object = SolutionObject.class;
		
		Class<SolutionObject> solutionObject = SolutionObject.class;
		
		
		
		System.out.println(SolutionObject.class.isInstance(object));
		
	}
	
	
	
}
