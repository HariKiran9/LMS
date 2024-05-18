package gap;

import java.util.Objects;

public class Employee {

	private int id;

	private String name;

	private int age;

	private Integer salary;

	public Employee() {
		super();
	}

	public Employee(int id, String name, int age, Integer salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee{id:" + this.getId() + ", name:" + this.getName() + ", age:" + this.getAge() + ", salary:"
				+ this.getSalary() + "}";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, id, name, salary);
//		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		return age == other.age && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(salary, other.salary);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the salary
	 */
	public Integer getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
