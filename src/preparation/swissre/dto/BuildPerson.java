package preparation.swissre.dto;

import java.util.ArrayList;
import java.util.List;

public class BuildPerson {

	public static List<Person> getPersons() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("Alice", "alice@gmail.com", Gender.FEMALE, 16, "HR"));
		personList.add(new Person("Bob", "bob@gmail.com", Gender.MALE, 15, "Sales And Marketing"));
		personList.add(new Person("Carol", "carol@gmail.com", Gender.FEMALE, 23, "Security And Transport"));
		personList.add(new Person("David", "david@gmail.com", Gender.MALE, 19, "Infrastructure"));
		personList.add(new Person("Eric", "eric@gmail.com", Gender.MALE, 26, "Account And Finance"));
		personList.add(new Person("Anuj Chettiar", "anun@gmail.com", Gender.MALE, 30, "Product Development"));
		return personList;
	}

}
