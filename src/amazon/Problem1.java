package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem1 {

	public static void main(String[] args) {
		int numFeatures = 6;
		int topFeatures = 2;
		List<String> possibleFeatures = Arrays.asList("storage", "battery", "hover", "alexa", "waterproof", "solar");
		int numFeatureRequests = 7;
		List<String> featureRequests = Arrays.asList("I wish my Kindle had even more storage!",
				"I wish the battery life on my Kindle lasted 2 years.",
				"I read in the bath and would enjoy a waterproof Kindle",
				"Waterproof and increased battery are my top two requests.",
				"I want to take my Kindle into the shower. Waterproof please waterproof !",
				"It would be neat if my Kindle would hover on my desk when not in use.",
				"How cool would it be if my Kindle charged in the sun via solar power?");

		popularNFeatures(numFeatures, topFeatures, possibleFeatures, numFeatureRequests, featureRequests);
		popularNFeatures2(numFeatures, topFeatures, possibleFeatures, numFeatureRequests, featureRequests);
		popularNFeatures3(numFeatures, topFeatures, possibleFeatures, numFeatureRequests, featureRequests);
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static ArrayList<String> popularNFeatures(int numFeatures, int topFeatures, List<String> possibleFeatures,
			int numFeatureRequests, List<String> featureRequests) {
		ArrayList<String> list = new ArrayList<String>();

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String feature : possibleFeatures) {
			map.put(feature, 0);
		}
		for (int i = 0; i < featureRequests.size(); i++) {
			String input = featureRequests.get(i);
			String[] inputStr = input.split(" ");
			for (int j = 0; j < inputStr.length; j++) {
				for (String feature : possibleFeatures) {
					if (feature.toLowerCase().contains(inputStr[j].toLowerCase())) {
						if (map.containsKey(inputStr[j])) {
							Integer count = map.get(inputStr[j]);
							map.put(inputStr[j], count + 1);
						} // if
					} // if
				} // for
			} // for
		} // for
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			if (e.getValue() == Collections.max(map.values())) {/* The max value of count */
				list.add(e.getKey());
			}
		}
		System.out.println("Output1 : " + list);
		return list;
	}
	// METHOD SIGNATURE ENDS

	public static ArrayList<String> popularNFeatures2(int numFeatures, int topFeatures, List<String> possibleFeatures,
			int numFeatureRequests, List<String> featureRequests) {

		HashSet<String> set = new HashSet<String>();
		for (String s : possibleFeatures) {
			set.add(s.toLowerCase());
		}

		HashMap<String, Integer> words = new HashMap<>();
		for (String s : featureRequests) {
			Set<String> seen = new HashSet<>();
			for (String str : s.split("\\W")) {
				if (set.contains(str.toLowerCase()) && !seen.contains(str.toLowerCase())) {
					words.put(str.toLowerCase(), words.getOrDefault(str.toLowerCase(), 0) + 1);
					seen.add(str.toLowerCase());
				} // if
			} // for
		} // for

		ArrayList<String> list = new ArrayList<>(words.keySet());
		Collections.sort(list,
				(a, b) -> (words.get(a).equals(words.get(b))) ? a.compareTo(b) : (words.get(b) - words.get(a)));
		if (topFeatures > numFeatures) {
			return list;
		}
		list.subList(0, topFeatures);
		System.out.println("Output2 : " + list);
		return list;
	}

	public static ArrayList<String> popularNFeatures3(int numFeatures, int topFeatures, List<String> possibleFeatures,
			int numFeatureRequests, List<String> featureRequests) {
		ArrayList<String> list = new ArrayList<String>();

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String feature : possibleFeatures) {
			map.put(feature, 0);
		}
		for (int i = 0; i < featureRequests.size(); i++) {
			String input = featureRequests.get(i);
			List<String> inputList = Arrays.asList(input.split(" "));
			for (String feature : possibleFeatures) {
				if (inputList.contains(feature)) {
					if (map.containsKey(feature)) {
						Integer count = map.get(feature);
						map.put(feature, count + 1);
					} // if
				} // if
			} // for
		} // for
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			if (e.getValue() == Collections.max(map.values())) {/* The max value of count */
				list.add(e.getKey());
			}
		}
		System.out.println("Output3 : " + list);
		return list;
	}

}
