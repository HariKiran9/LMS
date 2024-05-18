package swooptalent;

import java.util.Map;
import java.util.TreeMap;

public class UniqueString {

	public static void main(String[] args) {
		String input = "Welcome to Java Session Java Session Session Java"; // Input String
		String[] words = input.split(" "); // Split the word from String
		for (int i = 0; i < words.length; i++) {// Outer loop for Comparison
			if (words[i] != null) {

				for (int j = i + 1; j < words.length; j++) {// Inner loop for Comparison

					if (words[i].equals(words[j])) { // Checking for both strings are equal
						words[j] = null; // Delete the duplicate words
					}
				}
			}
		}
		for (int k = 0; k < words.length; k++) { // Displaying the String without duplicate words

			if (words[k] != null) {
				System.out.println(words[k]);
			}

		}

		String input1 = input;
		String[] words1 = input1.split(" ");
		Map<String, Integer> map = new TreeMap<String, Integer>();
		for (int i = 0; i < words1.length; i++) {
			String string = words1[i];
			if (map.containsKey(string)) {
				int count = map.get(string);
				map.put(string, count + 1);
			} else {
				map.put(string, 1);
			}
		} // for

		StringBuffer sb = new StringBuffer();
		map.forEach((key, value) -> {
			System.out.println("Item : " + key + " Count : " + value);

			if (value > 1) {

			} else {
				sb.append(key).append(" ");
			}
		});

		System.out.println(sb.toString());
	}

}
