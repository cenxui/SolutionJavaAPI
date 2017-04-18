package clazz;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.CellEditor;

public class SolutionArray<E> {
	Cell<E> head;
	

	public static void main(String[] args) {
		String[] strings = (String[]) Array.newInstance(String.class, 10);
		
		strings = new String[10];
		
		int[] dim = {4,4};
		double[][] metrix = (double[][]) Array.newInstance(double.class, dim);
		metrix = new double[4][4];

	}
	
	public E[] toArray_v1(Class<E> type) {
		int size = size();
		E[] attr = (E[])Array.newInstance(type, size);
		int i = 0;
		for (Cell<E> c : head) {
			
		}
		
		
		
		
	}
	
	public int size() {
		return 10;
	}
	
	private class Cell<E> implements Iterable<E>{
		private Cell<E> next;
		private E element;
		private Iterator<E> iterator;
		
		public Cell<E> getNext() {
			
			return next;
		}
		
		public E getElement() {
			return element;
		}

		
		private class CellIterator<E> implements Iterator<E> {

			@Override
			public boolean hasNext() {
				
				return next == null ? false : true;
			}

			@SuppressWarnings("unchecked")
			@Override
			public E next() {

				return (E) element;
			}
			
		}


		@Override
		public Iterator<E> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
