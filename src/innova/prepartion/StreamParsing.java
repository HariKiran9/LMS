package innova.prepartion;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamParsing {

	public static void main(String[] args) {
		// 1. Get your generated dataset of 100 employees
		List<EmployeeGenerator.Employee> dataset = EmployeeGenerator.generate100Employees();

		// 2. Stream execution pipeline
		Map<String, List<EmployeeGenerator.Employee>> top3PaidActiveByDept = dataset.stream()
				// Step A: Filter out anyone who is not active
				.filter(EmployeeGenerator.Employee::isActive)

				// Step B: Group by Department
				.collect(Collectors.groupingBy(EmployeeGenerator.Employee::department,

						// Step C: Downstream aggregation to sort and truncate each group
						Collectors.collectingAndThen(Collectors.toList(), list -> list.stream()
								// Sort by salary in descending order
								.sorted(Comparator.comparingDouble(EmployeeGenerator.Employee::salary).reversed())
								// Keep only the top 3
								.limit(3).toList())));

		// 3. Print the results to verify
		top3PaidActiveByDept.forEach((dept, empList) -> {
			System.out.println("\n========================================");
			System.out.println("DEPARTMENT: " + dept + " (Top " + empList.size() + " Active)");
			System.out.println("========================================");
			empList.forEach(System.out::println); // Correct Java Method Reference syntax
		});
	}

}
