package algorithms.search.types;

public class LinearSearch {
	// This function returns index of element x in arr[]
	static int search(int arr[], int n, int x) {
		for (int i = 0; i < n; i++) {
			// Return the index of the element if the element is found
			if (arr[i] == x)
				return i;
		} // for
		// return -1 if the element is not found
		return -1;
	}

	public static void main(String[] args) {
		int[] num = new int[] { 10, 13, 14, 15, 19 };
		int retValue = search(num, 5, 14);
		System.out.println(retValue);
	}

}
