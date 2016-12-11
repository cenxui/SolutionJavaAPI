package clazz;

import static java.lang.System.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

enum Spy {
	BLACK, WHITE
}

public class FieldModifierSpy {

	volatile int share;
	int instance;

	class Inner {
	}

	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			String[] modify = {"public", "protect", "private", "static", "final", "transiant", "volatile"}; 
			

			method(modify, c);
	
		
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		}
	}

	private static void method(String[] args, Class<?> c) {
		int searchMods = 0x0;
		for (int i = 0; i < args.length; i++) {
			searchMods |= modifierFromString(args[i]);
			out.println("search method : " + searchMods);
		}

		Field[] flds = c.getDeclaredFields();
		out.format("Fields in Class '%s' containing modifiers:  %s%n", c.getName(), Modifier.toString(searchMods));
		boolean found = false;
		for (Field f : flds) {
			int foundMods = f.getModifiers();
			// Require all of the requested modifiers to be present
			if ((foundMods & searchMods) == searchMods) {
				out.format("%-8s [ synthetic=%-5b enum_constant=%-5b ]%n", f.getName(), f.isSynthetic(),
						f.isEnumConstant());
				found = true;
			}
		}

		if (!found) {
			out.format("No matching fields%n");
		}
	}

	private static int modifierFromString(String s) {
		int m = 0x0;
		if ("public".equals(s))
			m |= Modifier.PUBLIC;
		else if ("protected".equals(s))
			m |= Modifier.PROTECTED;
		else if ("private".equals(s))
			m |= Modifier.PRIVATE;
		else if ("static".equals(s))
			m |= Modifier.STATIC;
		else if ("final".equals(s))
			m |= Modifier.FINAL;
		else if ("transient".equals(s))
			m |= Modifier.TRANSIENT;
		else if ("volatile".equals(s))
			m |= Modifier.VOLATILE;
		return m;
	}

}
