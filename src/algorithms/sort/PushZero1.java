package algorithms.sort;

public class PushZero1 {

	public static void solution1(int[] elements) {
		int swapCount = 0;
		int lastIndex = elements.length - 1;

		for (int i = lastIndex - 1; i >= 0; i--) { // skip the very last element
			if (elements[i] == 0) {
				elements[i] = elements[lastIndex - swapCount];
				elements[lastIndex - swapCount] = 0;
				swapCount++;
			}
		}

		for (int i : elements) {
			System.out.print(i + ", ");
		}
	}

	public static void solution2(int[] array) {
		// Maintaining count of non zero elements
		int count = -1;
		// Iterating through array and copying non zero elements in front of array.
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0)
				array[++count] = array[i];
		}
		// Replacing end elements with zero
		while (count < array.length - 1)
			array[++count] = 0;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

	public static void main(String[] args) {
		int[] elements = new int[] { 1, 2, 3, 4, 0, 5, 6, 0, 7, 8, 9 };
		solution1(elements);
//		solution2(elements);

	}

}
