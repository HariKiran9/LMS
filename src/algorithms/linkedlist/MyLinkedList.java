package algorithms.linkedlist;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MyLinkedList {

	private static final int MAX_ENTRIES = 5;

	private static void restrictMap() {
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>(MAX_ENTRIES + 1, .75F, false) {
			private static final long serialVersionUID = 1L;

			protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
				return size() > MAX_ENTRIES;
			}
		};
		lhm.put(0, "H");
		lhm.put(1, "E");
		lhm.put(2, "L");
		lhm.put(3, "L");
		lhm.put(4, "O");

		System.out.println("" + lhm);
	}

	private static void restrictSet() {
		Set<String> mySet = Collections.newSetFromMap(new LinkedHashMap<String, Boolean>() {
			private static final long serialVersionUID = 1L;

			protected boolean removeEldestEntry(Map.Entry<String, Boolean> eldest) {
				return size() > MAX_ENTRIES;
			}
		});
	}

	public static void main(String[] args) {
		MyLinkedList.restrictMap();
	}

}
