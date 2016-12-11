package clazz;

import static java.lang.System.*;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class SolutionClazz {

	public static void main(String[] args) {
		try {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		
		Class<?> clazz = classLoader.loadClass("clazz.SolutionClazz.MyField");
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			out.println(field.getName());
		}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public static class MyField {
		private int id;
		private String name;
		private LocalDate date;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public LocalDate getDate() {
			return date;
		}
		public void setDate(LocalDate date) {
			this.date = date;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
}

