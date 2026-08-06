package innova.prepartion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeGenerator {

	// Using a Java Record for a clean, immutable, boiler-free data model
	public record Employee(String name, String department, double salary, boolean isActive) {
		@Override
		public String toString() {
			return String.format("Employee[Name='%s', Dept='%s', Salary=$%,.2f, Active=%s]", name, department, salary,
					isActive);
		}
	}

	public static List<Employee> generate100Employees() {
		List<Employee> employeeList = new ArrayList<>();
		Random random = new Random();

		// Arrays to generate diverse mock data
		String[] firstNames = { "Liam", "Olivia", "Noah", "Emma", "Oliver", "Ava", "Elijah", "Charlotte", "William",
				"Sophia", "James", "Amelia", "Benjamin", "Isabella", "Lucas", "Mia", "Henry", "Evelyn", "Alexander",
				"Harper" };

		String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis",
				"Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor",
				"Moore", "Jackson", "Martin" };

		String[] departments = { "IT", "HR", "Finance", "Operations" };

		for (int i = 1; i <= 100; i++) {
			// Build a random unique name combination
			String name = firstNames[random.nextInt(firstNames.length)] + " "
					+ lastNames[random.nextInt(lastNames.length)] + " (" + i + ")";

			String department = departments[random.nextInt(departments.length)];

			// Random salary between $50,000 and $150,000
			double salary = 50000 + (100000 * random.nextDouble());
			// Round to 2 decimal places
			salary = Math.round(salary * 100.0) / 100.0;

			// 80% chance of being active to ensure a good mix
			boolean isActive = random.nextDouble() < 0.8;

			employeeList.add(new Employee(name, department, salary, isActive));
		}

		return employeeList;
	}

}
