package gap;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import preparation.swissre.dto.BuildEmployee;
import preparation.swissre.dto.Employee;

public class EmployeeSort {

	public static void main(String[] args) {
		List<Employee> empList = BuildEmployee.getEmployess();
//		for (Employee employee : empList) {
//			if (employee.getId() == 6) {
//				empList.remove(employee.getId());
//			}
//		}

		Set<Employee> setList = new HashSet<>(BuildEmployee.getEmployess());

		Set<Employee> treeList = new TreeSet<>((e1, e2) -> Integer.compare(e1.getId(), e2.getId()));
		treeList.add(new Employee(1, "Hari", 32, 10000, "IT", true));
		treeList.add(new Employee(2, "Hareesh", 30, 70000, "IT", true));
		treeList.add(new Employee(3, "Bala", 29, 100300, "HR", true));
		treeList.add(new Employee(4, "Kiran", 33, 10088, "HR", true));
		treeList.add(new Employee(5, "Bala", 29, 3500, "Finance", true));
		treeList.add(new Employee(6, "Kiran", 33, 4500, "Finance", true));
		treeList.add(new Employee(5, "Bala", 29, 3500, "Markerting", true));
		treeList.add(new Employee(6, "Kiran", 33, 4500, "Markerting", true));
		treeList.add(new Employee(5, "Bala", 29, 3500, "Sales", true));
		treeList.add(new Employee(6, "Kiran", 33, 4500, "Sales", true));

//		List<Employee> empList2 = empList.stream().sorted(Comparator.comparing(Employee::getAge))
//				.collect(Collectors.toList());
//		empList2.forEach(System.out::println);

//		System.out.println("-----------------");
//		List<Employee> empList3 = empList.stream()
//				.sorted(Comparator.comparing(Employee::getAge).thenComparing(Comparator.comparing(Employee::getSalary)))
//				.collect(Collectors.toList());
//		empList3.forEach(System.out::println);

//		System.out.println("----NULL----");
		Comparator<Employee> bySalary = new Comparator<Employee>() {
			@Override
			public int compare(Employee st1, Employee st2) {
				if (st1.getSalary() != null && st2.getSalary() != null) {
					return st2.getSalary() - st1.getSalary();
				} else if (st1.getSalary() != null) {
					return 1;
				} else {
					return -1;
				}
			}
		};

		List<Employee> empList4 = empList.stream()
				.sorted(Comparator.comparing(Employee::getAge).thenComparing(bySalary).reversed())
				.collect(Collectors.toList());
		empList4.forEach(System.out::println);

		// A&^B!CDE# --- E&^D!CBA#
		String strInput = "A&^B!CDE#";
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(strInput);
		System.out.println("Given String : " + strInput);
		int count = 0;
		while (m.find()) {
			count = count + 1;
			System.out.println("position " + m.start() + ": " + strInput.charAt(m.start()));
		}
		System.out.println("There are " + count + " special characters");

	}

	static char[] swap(String str, int i, int j) {
		char ch[] = str.toCharArray();
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
		return ch;
	}

}
