/**
 * 
 */
package designpattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Member;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.out;

import org.apache.log4j.Logger;

/**
 * @author Home
 *
 */
public class EnumSingletonTest {
	public static final Logger log = Logger.getLogger(EnumSingletonTest.class);

	private static final String fmt = "  %11s:  %s %s%n";

	public EnumSingletonTest() {
	}

	public static void main(String[] args) {
		new EnumSingletonTest();

		 Thread t1 = new Thread(new MyRunnable1("Thread1"));
		 Thread t2 = new Thread(new MyRunnable2("Thread2"));
		 t1.start();
		 t2.start();

		/*try {
			Class<?> c = (args.length == 0 ? EnumSingleton.class
					: Class.forName("designpattern.singleton.EnumSingleton"));
			out.format("Enum name:  %s%nEnum constants:  %s%n", c.getName(), Arrays.asList(c.getEnumConstants()));
			if (c == EnumSingleton.class)
				out.format("  Eon.values():  %s%n", Arrays.asList(EnumSingleton.values()));

			// production code should handle this exception more gracefully

			Field[] flds = c.getDeclaredFields();
			List<Field> cst = new ArrayList<Field>(); // enum constants
			List<Field> mbr = new ArrayList<Field>(); // member fields
			for (Field f : flds) {
				if (f.isEnumConstant())
					cst.add(f);
				else
					mbr.add(f);
			}
			if (!cst.isEmpty())
				print(cst, "Constant");
			if (!mbr.isEmpty())
				print(mbr, "Field");

			Constructor[] ctors = c.getDeclaredConstructors();
			for (Constructor ctor : ctors) {
				out.format(fmt, "Constructor", ctor.toGenericString(), synthetic(ctor));
			}

			Method[] mths = c.getDeclaredMethods();
			for (Method m : mths) {
				out.format(fmt, "Method", m.toGenericString(), synthetic(m));
			}

		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		}
*/
	}

	private static void print(List<Field> lst, String s) {
		for (Field f : lst) {
			out.format(fmt, s, f.toGenericString(), synthetic(f));
		}
	}

	private static String synthetic(Member m) {
		return (m.isSynthetic() ? "[ synthetic ]" : "");
	}
}
