package autobox;

public class SolutionAutoBox {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		System.out.println("autoboxing");
		Long sum = 1L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum++;
		}
		System.out.println("time" + (System.currentTimeMillis() - time));
		time = System.currentTimeMillis();
		long psum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			psum++;
		}
		System.out.println("time" + (System.currentTimeMillis() - time));
	}

}
