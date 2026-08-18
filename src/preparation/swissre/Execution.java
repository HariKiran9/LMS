package preparation.swissre;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import preparation.swissre.dto.BuildEmployee;
import preparation.swissre.dto.BuildTransaction;
import preparation.swissre.dto.Employee;
import preparation.swissre.dto.Transaction;

@Slf4j
public class Execution {

	public static void main(String[] args) {
		getTransactionByCategory();
		getEmployess();

		findDuplicateNumbers();

		getUniqueList();
	}

	private static void findDuplicateNumbers() {
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
		List<Integer> list2 = Arrays.asList(3, 4, 5, 6);

		List<Integer> duplicateNumbers = list2.stream().filter(ele -> list1.contains(ele)).toList();
		log.info("Approach #1: Duplicate Numbers: {}", duplicateNumbers);

		Set<Integer> numbers = new HashSet<>(list1);
		List<Integer> duplicateNumbersBySet = list2.stream().filter(ele -> numbers.contains(ele)).toList();
		log.info("Approach #2: Duplicate Numbers: {}", duplicateNumbersBySet);
	}

	private static void getUniqueList() {
		List<List<Integer>> listoflist = Arrays.asList(Arrays.asList(1, 2, 3, 4), Arrays.asList(3, 4, 5, 6),
				Arrays.asList(5, 6, 7, 8), Arrays.asList(7, 8, 9, 10));
		List<Integer> uniqueNumbersList = listoflist.stream().flatMap(innerList -> innerList.stream()).distinct()
				.toList();
		log.info("Unique Numbers from List of List: {}", uniqueNumbersList);

	}

	private static void getTransactionByCategory() {
		List<Transaction> transactions = BuildTransaction.getTransactions();

		Map<String, Integer> transType = transactions.stream().collect(
				Collectors.groupingBy(tran -> tran.getCategory(), Collectors.summingInt(tran -> tran.getAmount())));
		log.info("Transaction Type: {}", transType);
	}

	private static void getEmployess() {
		List<Employee> employees = BuildEmployee.getEmployess();

		Map<String, Double> averageSalaryByDepartment = employees.stream().collect(
				Collectors.groupingBy(tran -> tran.getDepartment(), Collectors.averagingInt(tran -> tran.getSalary())));
		log.info("Average Salary By Department: {}", averageSalaryByDepartment);

		Map<String, Optional<Employee>> departmentWiseHighestSalary = employees.stream().collect(Collectors.groupingBy(
				emp -> emp.getDepartment(), Collectors.maxBy(Comparator.comparing(emp -> emp.getSalary()))));
		log.info("Department Wise Highest Salary: {}", departmentWiseHighestSalary);

		String employeeNames = employees.stream().map(emp -> emp.getName()).collect(Collectors.joining(","));
		log.info("Approach #1: Employee Names: {}", employeeNames);

		String employeeNames2 = employees.parallelStream().map(emp -> emp.getName()).collect(Collectors.joining(","));
		log.info("Approach #2: Employee Names: {}", employeeNames2);

//		employees.parallelStream().map(emp -> emp.getName()).forEach(empName -> log.info("Employee Name: {}", empName));

		Integer totalSalary = employees.parallelStream().map(emp -> emp.getSalary()).reduce(0, (a, b) -> a + b);
		log.info("Total Salary: {}", totalSalary);

	}

}
