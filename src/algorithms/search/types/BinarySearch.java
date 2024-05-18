package algorithms.search.types;

public class BinarySearch {
	// Returns index of x if it is present in arr[l..r], else return -1
	int binarySearch(int inputGivenArray[], int startIndex, int givenArrayLength, int inputSearchNumber) {
		System.out.println(" binarySearch : " + startIndex);
		if (givenArrayLength >= startIndex) {
			int mid = startIndex + (givenArrayLength - startIndex) / 2;

			// If the element is present at the middle itself
			if (inputGivenArray[mid] == inputSearchNumber)
				return mid;

			// If element is smaller than mid, then it can only be present in left subarray
			if (inputGivenArray[mid] > inputSearchNumber)
				return binarySearch(inputGivenArray, startIndex, mid - 1, inputSearchNumber);

			// Else the element can only be present in right subarray
			return binarySearch(inputGivenArray, mid + 1, givenArrayLength, inputSearchNumber);
		} // if
		// We reach here when element is not present in array
		return -1;
	}

	// Driver method to test above
	public static void main(String args[]) {
		BinarySearch ob = new BinarySearch();
		int givenArray[] = { 2, 3, 4, 10, 40 };
		int givenArrayLength = givenArray.length;
		int givenNumber = 10;
		int result = ob.binarySearch(givenArray, 0, givenArrayLength - 1, givenNumber);
		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at index " + result);

	}
}