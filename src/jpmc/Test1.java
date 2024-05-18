package jpmc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test1 {

	public static void main(String[] args) {
//		String line = "A quick brown fox jumps over the lazy dog";
		String line = "A slow yellow fox crawls under the proactive dog";
		Map<Character, Integer> chMap = new HashMap<>();
		chMap.put('a', 0);
		chMap.put('b', 0);
		chMap.put('c', 0);
		chMap.put('d', 0);
		chMap.put('e', 0);
		chMap.put('f', 0);
		chMap.put('g', 0);
		chMap.put('h', 0);
		chMap.put('i', 0);
		chMap.put('j', 0);
		chMap.put('k', 0);
		chMap.put('l', 0);
		chMap.put('m', 0);
		chMap.put('n', 0);
		chMap.put('o', 0);
		chMap.put('p', 0);
		chMap.put('q', 0);
		chMap.put('r', 0);
		chMap.put('s', 0);
		chMap.put('t', 0);
		chMap.put('u', 0);
		chMap.put('v', 0);
		chMap.put('w', 0);
		chMap.put('x', 0);
		chMap.put('y', 0);
		chMap.put('z', 0);
		char[] ch = line.toLowerCase().toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ch.length; i++) {
			if (chMap.containsKey(ch[i])) {
				int count = chMap.get(ch[i]);
				chMap.put(ch[i], count + 1);
			} else {
				chMap.put(ch[i], 0);
			}
		} // for

		Set<Entry<Character, Integer>> set = chMap.entrySet();
		Iterator<Entry<Character, Integer>> itr = set.iterator();
		while (itr.hasNext()) {
			Entry<Character, Integer> mapEntry = itr.next();
			int value = mapEntry.getValue();
			char ch1 = mapEntry.getKey();
			if (value > 0) {

			} else {
				// System.out.println(mapEntry.getKey() + "" + mapEntry.getValue());
				sb.append(ch1);
			}
		} // while

		if (sb != null && !"".equals(sb.toString())) {
			System.out.println(sb.toString());
		} else {
			System.out.println("NULL");
		}

	}

}
