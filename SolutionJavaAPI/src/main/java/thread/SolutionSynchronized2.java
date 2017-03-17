package thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class SolutionSynchronized2 {
	
	private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	private final ReadLock readLock = readWriteLock.readLock();
	
	private final WriteLock writeLock = readWriteLock.writeLock();
	
	private volatile long sum = 0L;
	
	public long add(long value) {
		try {		
			System.out.println("write lock");
			writeLock.lock();
			sum = sum + value;
		} finally {
			System.out.println("write unlock");
			writeLock.unlock();
		}
		
		return sum;
	}
	
	public long subtract(long value) {
		try {
			System.out.println("write lock");
			writeLock.lock();
			sum = sum - value;
		} finally {
			System.out.println("write unlock");
			writeLock.unlock();
		}
		return sum;
	}
	
	public long getSum() {
		try {
			System.out.println("read lock");
			readLock.lock();
			return sum;
		} finally {
			System.out.println("read unlock");
			readLock.unlock();
		}
	}

}
