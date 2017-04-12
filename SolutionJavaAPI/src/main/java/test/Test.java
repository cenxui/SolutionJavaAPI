package test;

public class Test {
	@Invarient private String name = "John";
	@PreCondition private int age = 20;
	@PostCondition private String result = "Nice to meet you";
	
	public static void main(String[] args) {
		Test test = new Test();
		new TestCondition() {
			{
				test.name = "Marry";
				test.age = 18;
				test.result = "Success";
			}
		};

	}

}
