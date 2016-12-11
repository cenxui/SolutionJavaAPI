package collection;

import java.util.ArrayDeque;
import java.util.concurrent.ForkJoinTask;

public class SolutionDeque {

	public static void main(String[] args) {
		ArrayDeque<Integer> ad = new ArrayDeque<>();
		ad.add(6);
		System.out.println("add 6 : " + ad);
		ad.add(2);
		System.out.println("add 2 : " + ad);
		ad.offerLast(3);
		System.out.println("offerlast 3 : " + ad);
		ad.offer(4);
		System.out.println("offer 4 : " + ad);
		ad.poll();
		System.out.println("poll : " + ad);
		ad.remove();
		System.out.println("remove : " + ad);
		ad.push(10);
		System.out.println("push 10 : " + ad);
		ad.push(11);
		System.out.println("push 11 : " + ad);
		
	}

}
