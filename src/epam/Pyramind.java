/**
 * 
 */
package epam;

/**
 * @author Hari Kiran
 *
 */
public class Pyramind {

	public static void main(String[] args) {
		int[] values1 = new int[] { 3, 4, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6 };
		int[] values2 = new int[] { 4, 3, 3, 4, 1, 2, 2, 3, 6, 5, 4, 5 };
		boolean result = IsDominoPyramidValid(values2);
		System.out.println(result ? "YES" : "NO");
	}

	private static int DominoLength = 2;

	public static boolean IsDominoPyramidValid(int[] values) {
		int arrayLength = values.length;

		int offset = 0;
		int currentRow = 1; // Note: I'm using a 1-based value here as it helps the maths
		boolean result = true;
		while (result) {
			int currentRowLength = currentRow * DominoLength;

			// Avoid checking final row: there is no row below it
			if (offset + currentRowLength >= arrayLength) {
				break;
			}

			result = CheckValuesOnRowAgainstRowBelow(values, offset, currentRowLength);
			offset += currentRowLength;
			currentRow++;
		}

		return result;
	}

	private static boolean CheckValuesOnRowAgainstRowBelow(int[] values, int startOfCurrentRow, int currentRowLength) {
		int startOfNextRow = startOfCurrentRow + currentRowLength;
		int comparablePointOnNextRow = startOfNextRow + 1;
		for (int i = 0; i < currentRowLength; i++) {
			if (values[startOfCurrentRow + i] != values[comparablePointOnNextRow + i]) {
				return false;
			}
		}
		return true;
	}
}