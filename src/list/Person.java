/**
 * 
 */
package list;

import java.io.Serializable;

/**
 * @author Sarvani
 *
 */

enum Gender {
	MALE, FEMALE
}

public class Person implements Serializable {

	private static final long serialVersionUID = -5473365794868741028L;

	private String name;

	private String email;

	private Gender gender;

	private int age;

	private String department;

	public Person() {
	}

	public Person(String name, String email, Gender gender, int age, String department) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.age = age;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", age=" + age + ", department=" + department + "]";
	}

}
