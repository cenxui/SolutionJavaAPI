package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class SolutionAtomicInMultithread {

	private final AtomicInteger atomicInteger = new AtomicInteger();
	
	public static void main(String[] args) {
		final SolutionAtomicInMultithread s = new SolutionAtomicInMultithread();
		new Thread(() -> {
			for (int i = 0; i < 10000; i++)
				s.add();
		}).start();
		
		new Thread(() -> {
			for (int i = 0; i < 10000; i++)
				s.add();
		}).start();
		
		new Thread(() -> {
			for (int i = 0; i < 10000; i++)
				s.add();
		}).start();
		
		new Thread(() -> {
			for (int i = 0; i < 10000; i++)
				s.add();
		}).start();
		
		new Thread(() -> {
			for (int i = 0; i < 10000; i++)
				s.add();
		}).start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		s.show();

	}

	public void add() {
		atomicInteger.getAndAdd(10);
	}

	public void show() {
		System.out.println(atomicInteger);
	}

}
