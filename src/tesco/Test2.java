/**
 * 
 */
package tesco;

/**
 * @author Home
 *
 */
public class Test2 {

	static int minimumMoves(int[] a, int[] m) {
		// Do the Increment for 1st array
		StringBuffer sb = new StringBuffer();
		int aCounter = 0;
		for (int i = 0; i < a.length; i++) {
			char[] s = String.valueOf(a[i]).toCharArray();
			int diff = s[1] - s[0];
			System.out.println("diff : " + diff);
			for (int j = 0; j < s.length; j++) {
				sb.append(s[j] + diff);
				aCounter = aCounter + 1;
			}
		}

		// Do the Increment for 2nd array
		StringBuffer sb2 = new StringBuffer();
		int bCounter = 0;
		int finalCounter = 0;
		for (int i = 0; i < m.length; i++) {
			char[] s = String.valueOf(m[i]).toCharArray();
			int diff = Math.abs(s[1] - s[0]);
			System.out.println("diff : " + diff);
			for (int j = 0; j < s.length; j++) {
				if (bCounter != m.length - 1) {
					sb2.append(m[i] - diff);
				} else if (bCounter == m.length - 1) {
					sb2.append(m[i] + bCounter);
					finalCounter = bCounter * 2;
				}
				bCounter = bCounter + 1;

			}

		}
		return finalCounter + aCounter;

	}

	public static void main(String[] args) {
		// int[] a = new int[] { 1234, 4321 };
		// int[] m = new int[] { 2345, 3214 };

		int[] a = new int[] { 2468 };
		int[] m = new int[] { 8642 };

		System.out.println("Final Counter : " + minimumMoves(a, m));

	}

}
