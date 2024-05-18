package palindrome;

public class CompareArrayAndSwap {

	public static void main(String[] args) {
		int[] numbers = { 4, 5, 1, 6, 2, 7, 3, 8 };
		int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8 };

		if (numbers.length == expected.length) {
			boolean tempA = swapArray(numbers);
			// System.out.println(" input of tempA : " + tempA);
			boolean tempB = swapArray(expected);
			// System.out.println(" input of tempB : " + tempB);
		}
	}

	public static boolean swapArray(int[] a) {
		System.out.print(" input ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		if (a.length == 0) {
			return false;
		}
		// walk towards the middle, from both sides
		for (int frontIndex = 0; frontIndex < a.length / 2; frontIndex++) {
			// System.out.println("frontIndex : " + messageChars.length / 2);
			int backIndex = a.length - frontIndex - 1;

			// swap the front char and back char
			int temp = a[frontIndex];
			a[frontIndex] = a[backIndex];
			a[backIndex] = temp;
		} // for

		System.out.print(" output ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		return true;
	}

}
