package preparation.swissre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private Integer id;

	private String name;

	private Integer age;

	private Integer salary;

	private String department;

	private boolean active;

}
