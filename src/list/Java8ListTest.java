/**
 * 
 */
package list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Sarvani
 *
 */
public class Java8ListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Person> personList = new ArrayList<>();

		personList.add(new Person("Alice", "alice@gmail.com", Gender.FEMALE, 16, "HR"));
		personList.add(new Person("Bob", "bob@gmail.com", Gender.MALE, 15, "Sales And Marketing"));
		personList.add(new Person("Carol", "carol@gmail.com", Gender.FEMALE, 23, "Security And Transport"));
		personList.add(new Person("David", "david@gmail.com", Gender.MALE, 19, "Infrastructure"));
		personList.add(new Person("Eric", "eric@gmail.com", Gender.MALE, 26, "Account And Finance"));
		personList.add(new Person("Anuj Chettiar", "anun@gmail.com", Gender.MALE, 30, "Product Development"));

		System.out.println("--------Filterd based on FEMALE--------");

		/*
		 * The filter() operation returns a new stream that consists elements matching a
		 * given condition which is typically a boolean test in form of a Lambda
		 * expression.
		 * 
		 * The following code lists only female persons:
		 */
		personList.stream().filter(p -> p.getGender().equals(Gender.FEMALE)).forEach(System.out::println);

		System.out.println("\n--------Filterd based on Male and Age<=25--------");

		/*
		 * The following code shows only male who are under 25:
		 */
		personList.stream().filter(p -> p.getGender().equals(Gender.MALE) && p.getAge() <= 25)
				.forEach(System.out::println);

		Map<Gender, Long> noOfMaleAndFemale = personList.stream()
				.collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));

		System.out.println(noOfMaleAndFemale);

		Optional<Person> youngestMaleEmployeeInProductDevelopmentWrapper = personList.stream()
				.filter(e -> e.getGender() == Gender.MALE && e.getDepartment() == "Product Development")
				.min(Comparator.comparingInt(Person::getAge));

		Person youngestMaleEmployeeInProductDevelopment = youngestMaleEmployeeInProductDevelopmentWrapper.get();

		System.out.println("Details Of Youngest Male Employee In Product Development");

		System.out.println("----------------------------------------------");

		System.out.println("ID : " + youngestMaleEmployeeInProductDevelopment.getAge());

	}

}
