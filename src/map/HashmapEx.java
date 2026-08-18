/**
 * 
 */
package map;

import java.util.HashMap;
import java.util.Map;

import preparation.swissre.dto.Employee;

/**
 * @author Sarvani
 *
 */
public class HashmapEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee e1 = new Employee(3, "Bala", 29, 100300, "IT", true);
		Employee e2 = new Employee(4, "Kiran", 33, 10088, "HR", true);
		Employee e3 = new Employee(3, "Bala", 29, 100300, "Networking", true);

		Map<Employee, String> map = new HashMap<>();
		map.put(e1, "Hai");
		map.put(e2, "Hello");
		map.put(e3, "Kiran");

		System.out.println("Size : " + map.size());

		System.out.println("e1 : " + map.get(e1));
		System.out.println("e3 : " + map.get(e3));

	}

}
