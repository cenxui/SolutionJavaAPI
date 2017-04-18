package annotation;

import java.lang.annotation.Retention;

import javax.swing.text.AsyncBoxView.ChildLocator;

public class SolutionInherite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child child = new Child();
		child.name();
		
	}
	
	private static class Parent {
		
		@Deprecated
		public void name() {
			
		}
	}
	
	private static class Child  extends Parent {
		@Override
		public void name() {
			// TODO Auto-generated method stub
			super.name();
		}
	}
}
