package clazz;

import static java.lang.System.*;

import java.lang.reflect.Field;
import java.util.Arrays;

enum Tweedle { DEE, DUM }

public class Book {
	public long chapters = 0;
	public String[] characters = { "Alice", "White Rabbit" };
    public Tweedle twin = Tweedle.DEE;

	public static void main(String[] args) {
		Book book = new Book();
		
		String fmt = "%6S:   %-12s = %s%n";
		
		Class<?> c = book.getClass();
		
//		Class<?> c = Book.class.getClass(); //error
		
//		Class<?> c = Runtime.class.getClass(); //error
		
//		Class<?> c = null;
//		try {
//			c = Class.forName("clazz.Book");
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		try {
			Field chap = c.getDeclaredField("chapters");
			
			out.format(fmt, "before", "chapters", book.chapters);
			
			chap.setLong(book, 12);
			
			out.format(fmt, "after", "chapters", chap.getLong(book));
			
			Field chars = c.getDeclaredField("characters");
			
			out.format(fmt, "before", "characters", Arrays.asList(book.chapters));
			
			String[] newChars = { "Queen", "King"};
			
			chars.set(book, newChars);
			
			out.format(fmt, "after", "characters", Arrays.asList(book.characters));
			
			Field t = c.getDeclaredField("twin");
			
			out.format(fmt, "before", "twin", book.twin);
			
			t.set(book, Tweedle.DUM);
			
			out.format(fmt, "after", "twin", t.get(book));
			
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
