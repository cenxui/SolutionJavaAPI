package clone;

public class SolutionClone2 {
	public static void main(String[] args) {
		System.out.println("Master");
		System.out.println("check stashes");
		
		A a = new A();
		System.out.println("a : " + a.getName());
		A a1 = a.clone();
		System.out.println("a1 : " + a1.getName());
		a.setName("new name");
		System.out.println("a set new name");
		System.out.println("a : " + a.getName());
		System.out.println("a1 : " + a1.getName());
		System.out.println("a.b : " + a.getB().getName());
		System.out.println("a1.b : " + a1.getB().getName());
		a.getB().setName("new name");
		System.out.println("a.b set new name");
		System.out.println("a.b : " + a.getB().getName());
		System.out.println("a1.b : " + a1.getB().getName());// if you don't implement the clone method recursively, this will print new name

	}
	
	static class A implements Cloneable {
		private String name = "A";
		private B b = new B();
		@Override
		protected A clone()  {
			A result = null;
			try {
				 result = (A) super.clone();
				 result.b = b.clone(); // if you don't implement this this object only clone the reference value
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return result;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public B getB() {
			return b;
		}
		
	}
	
	static class B implements Cloneable {
		private String name = "B";
		@Override
		protected B clone() {
			B result = null;
			try {
				result = (B)super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return result;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
}
