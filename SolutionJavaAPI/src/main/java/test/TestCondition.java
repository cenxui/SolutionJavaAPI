package test;

public class TestCondition {
	
	@Invarient
	@PreCondition
	@PostCondition
	private String name = "Hello";
	
	public TestCondition() {
		System.out.println(TestCondition.class.getDeclaredFields().length);
		System.out.println(TestCondition.class.getAnnotation(PostCondition.class));
		System.out.println(TestCondition.class.getAnnotation(Invarient.class));
	}
	
	

}
