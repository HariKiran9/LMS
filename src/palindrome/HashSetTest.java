package palindrome;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	private static final HashSet<Employee> set = new HashSet<>();

	public HashSetTest() {
		// for (int i = 0; i < 10; i++) {
		// set.add(new Employee(i, "Hari", 1000));
		// set.add(new Employee(i, "Hari", 1000));
		// }

		set.add(new Employee(1, "Hari", 1000));
		set.add(new Employee(1, "Hari", 1000));
	}

	public static void main(String[] args) {
		new HashSetTest();

		set.parallelStream().forEach((item) -> {
			System.out.println(" Java 8 : " + item);
		});

		for (Iterator<Employee> iterator = set.iterator(); iterator.hasNext();) {
			System.out.println(" Java 7 : " + iterator.next());
		}
		System.out.println(" HashSet Size : " + set.size());
	}

}
