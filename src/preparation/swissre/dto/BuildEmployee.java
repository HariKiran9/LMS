package preparation.swissre.dto;

import java.util.ArrayList;
import java.util.List;

public class BuildEmployee {

	public static List<Employee> getEmployess() {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "Hari", 32, 10000, "IT", true));
		empList.add(new Employee(2, "Hareesh", 30, 70000, "IT", true));
		empList.add(new Employee(3, "Bala", 29, 100300, "HR", true));
		empList.add(new Employee(4, "Kiran", 33, 10088, "HR", true));
		empList.add(new Employee(5, "Bala", 29, 3500, "Finance", true));
		empList.add(new Employee(6, "Kiran", 33, 4500, "Finance", true));
		empList.add(new Employee(5, "Bala", 29, 3500, "Markerting", true));
		empList.add(new Employee(6, "Kiran", 33, 4500, "Markerting", true));
		empList.add(new Employee(5, "Bala", 29, 3500, "Sales", true));
		empList.add(new Employee(6, "Kiran", 33, 4500, "Sales", true));
		return empList;
	}

}
