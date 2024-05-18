package algorithms;

public class MissingNumberInArray {

	// Method to calculate sum of 'n' numbers
	static int sumOfNnumbers(int n) {
		int sum = (n * (n + 1)) / 2;
		return sum;
	}

	// Method to calculate sum of all elements of array

	static int sumOfElements(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int n = 5;
		int[] a = { 1, 4, 5, 6, 7};

		// Step 1
		int sumOfNnumbers = sumOfNnumbers(n);
		System.out.println(" sumOfNnumbers = " + sumOfNnumbers);

		// Step 2
		int sumOfElements = sumOfElements(a);
		System.out.println(" sumOfElements = " + sumOfElements);

		// Step 3
		int missingNumber = sumOfNnumbers - sumOfElements;
		System.out.println("Missing Number is = " + missingNumber);
	}
}