/**
 * 
 */
package tesco;

/**
 * @author Home
 *
 */
public class Test1 {

	static int maximumGroups(int[] predators) {
		int retValue = 0;
		for (int i = 0; i < predators.length; i++) {
			for (int j2 = i + 1; j2 < predators.length; j2++) {
				System.out.println("" + i + "" + j2);

			}
		}

		return retValue;
	}

	public static void main(String[] args) {
		int[] predators = new int[] { 3, -1, 0, 1 };
		maximumGroups(predators);

	}

}
