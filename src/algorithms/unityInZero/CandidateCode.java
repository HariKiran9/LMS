/**
* 
*/
package algorithms.unityInZero;

/**
 * @author Home
 *
 */
public class CandidateCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] i = new int[] { 1, 3, 0, 8, 12, 0, 4, 0, 7 };
		unityInZeros(i);

	}

	public static int[] unityInZeros(int[] input1) {
		int[] in1 = new int[input1.length];
		int[] in2 = new int[input1.length];

		for (int i = 0; i < input1.length; i++) {
			if (input1[i] == 0) {
				in2[i] = input1[i];
			} else {
				in1[i] = input1[i];
			}
		} // for

		for (int i = 0; i < in1.length; i++) {
			int j = in1[i];
			System.out.println(j);
		}

		return in1;
	}

}
