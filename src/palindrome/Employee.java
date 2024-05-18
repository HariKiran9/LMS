package palindrome;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private int empId;
	private String name;
	private int salary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String name, int salary) {
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		String retValue = this.getEmpId() + " " + this.getName() + " " + this.getSalary() + " "
				+ this.getClass().getName();
		return retValue;
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		System.out.println(" Hash Code : " + result);
		return result;
	}

	@Override
	public boolean equals(Object object) {
		boolean result = false;
		if (object == null || object.getClass() != getClass()) {
			System.out.println("   IF : 1 : ");
			result = false;
		} else {
			Employee emp = (Employee) object;
			System.out.println(" ELSE : 1 : " + emp.getName());
			if (this.name == emp.getName()) {
				System.out.println("   IF : 2 : ");
				result = true;
			} else {
				System.out.println(" ELSE : 2 : ");
			}
		}
		return result;
	}

	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * @param empId
	 *            the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

}
