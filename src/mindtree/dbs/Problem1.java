/**
 * 
 */
package mindtree.dbs;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Hari Kiran
 *
 */
public class Problem1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Child child = new Child();
		child.show();
		child.show("Hello");
		child.calculate(10);
		copyOnArrayTest();
		arryListTest1();
		optionalTest();
	}

	public static void copyOnArrayTest() {
		CopyOnWriteArrayList<String> copy = new CopyOnWriteArrayList<>(Arrays.asList("1", "2", "3", "4"));
		System.out.println("1" + copy);

		new Thread() {
			public void run() {
				copy.set(0, "a");
				copy.set(1, "b");
				copy.set(2, "c");
				copy.set(3, "d");
			}
		}.start();
		System.out.println("2" + copy);

		new Thread() {
			public void run() {
				copy.set(0, "A");
				copy.set(1, "B");
				copy.set(2, "C");
				copy.set(3, "D");
			}
		}.start();
		System.out.println("3" + copy);

		new Thread() {
			public void run() {
				copy.set(0, "000");
				copy.set(1, "111");
				copy.set(2, "222");
				copy.set(3, "333");
			}
		}.start();
		System.out.println("4" + copy);

		new Thread().start();
		System.out.println("5" + copy);
	}

	public static void arryListTest1() {
		List<Integer> list = Arrays.asList(2, 4, 6, 7, 8);
		list.stream().peek(System.out::println);
	}

	public static void arryListTest2() {
		List<Integer> list = Arrays.asList(2, 4, 6, 7, 8);
		list.stream().filter(i -> i % 2 == 0);
	}

	public static void optionalTest() {
		List<String> companyNames = Arrays.asList("paypal", "oracle", "", "microsoft", "", "apple");
		Optional<List<String>> listOptional = Optional.of(companyNames);

		int size = listOptional.map(List::size).orElse(0);
		System.out.println("Size : " + size);

		boolean isPresent1 = listOptional.filter(i -> i.equals("Bala")).isPresent();
		System.out.println("isPresent1 : " + isPresent1);

		List<String> companyNames2 = Arrays.asList("Hari");
		List<String> companyNames3 = Optional.of(companyNames).filter(i -> i.contains("Bala")).orElse(companyNames2);
		System.out.println("companyNames3 : " + companyNames3);

		String isPresent2 = Optional.of("microsot").orElse("N/A");
		System.out.println("isPresent2 : " + isPresent2);

		String name = null;
		Optional<String> opt = Optional.ofNullable(name);
		System.out.println("isPresent : " + opt.isPresent());

	}

}
