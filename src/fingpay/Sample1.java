/**
 * 
 */
package fingpay;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sarvani
 *
 */
public class Sample1 {

	public static void main(String[] args) {
		// the=0,6 , over=5, quick=1, lazy=7, jumps=4, brown=2, dog=8, fox=3
		String str = "The quick brown fox jumps over the lazy dog";

		String[] words = str.split(" ");

		Map<String, String> indexMap = new HashMap<String, String>();
		for (int i = 0; i < words.length; i++) {
			String string = words[i].trim();
//			System.out.println("Word : " + string);
//			System.out.println(indexMap + "," + indexMap.containsKey(indexMap.get(string)));
			if (indexMap.containsKey(string)) {
//				String index = indexMap.get(string);
				indexMap.put(string, String.valueOf(i));
//				indexMap.put(string, index + "," + String.valueOf(i));
			} else {
				indexMap.put(string, String.valueOf(i));
			}

		} // for

		System.out.println(indexMap);

	}

}
