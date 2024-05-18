package zemoso;

class AreConsecutive {

	static int equilibrium(int arr[]) {
		int n = arr.length;
		int i, j;
		int leftsum, rightsum;

		/*
		 * Check for indexes one by one until an equilibrium index is found
		 */
		for (i = 0; i < n; ++i) {
			leftsum = 0; // initialize left sum for current index i
			rightsum = 0; // initialize right sum for current index i

			/* get left sum */
			for (j = 0; j < i; j++)
				leftsum += arr[j];

			/* get right sum */
			for (j = i + 1; j < n; j++)
				rightsum += arr[j];

			/* if leftsum and rightsum are same, then we are done */
			if (leftsum == rightsum)
				return i;
		}

		/* return -1 if no equilibrium index is found */
		return -1;
	}

	static int equi(int nInputArray[]) {
		if (nInputArray.length <= 0) {
			return -1;
		}

		int nPos2;
		int nDis;
		int nPos1 = (int) (nPos2 = nDis = nInputArray.length);

		for (int i = 0; i < nInputArray.length; i++) {
			int nNum1 = 0;
			int nNum2 = 0;
			if (nInputArray[i] == nNum1)
				nPos1 = i;
			else if (nInputArray[i] == nNum2)
				nPos2 = i;

			if (nPos1 < nInputArray.length && nPos2 < nInputArray.length) {
				if (nDis > Math.abs(nPos1 - nPos2))
					nDis = Math.abs(nPos1 - nPos2);
			}
		}

		return nDis == nInputArray.length ? -1 : nDis;

	}

	static int equi2(int A[]) {
		if (A == null || A.length < 3)
			throw new RuntimeException("Cannot find equilirbium");
		int pointer = 1;
		int lowerIndCount = A[0];
		int upperIndCount = 0;

		for (int i = 2; i < A.length; i++) {
			upperIndCount += A[i];
			if (lowerIndCount < 0) {
				if (upperIndCount > lowerIndCount && i != A.length - 1)
					continue;
				if (upperIndCount == lowerIndCount && i == A.length - 1)
					break;
				lowerIndCount += A[pointer];
				upperIndCount = 0;
				++pointer;
				i = pointer;
			} else {
				if (upperIndCount > lowerIndCount) {
					lowerIndCount += A[pointer];
					upperIndCount = 0;
					++pointer;
					i = pointer;
				}
			}
		}

		if (upperIndCount == lowerIndCount)
			return pointer;

		return -1;
	}

	/*
	 * The function checks if the array elements are consecutive If elements are
	 * consecutive, then returns true, else returns false
	 */
	boolean areConsecutive(int arr[], int n) {
		if (n < 1)
			return false;

		/* 1) Get the minimum element in array */
		int min = getMin(arr, n);

		/* 2) Get the maximum element in array */
		int max = getMax(arr, n);

		/* 3) max - min + 1 is equal to n, then only check all elements */
		if (max - min + 1 == n) {
			/*
			 * Create a temp array to hold visited flag of all elements. Note that, calloc
			 * is used here so that all values are initialized as false
			 */
			boolean visited[] = new boolean[n];
			int i;
			for (i = 0; i < n; i++) {
				/* If we see an element again, then return false */
				if (visited[arr[i] - min] != false)
					return false;

				/* If visited first time, then mark the element as visited */
				visited[arr[i] - min] = true;
			}

			/* If all elements occur once, then return true */
			return true;
		}
		return false; // if (max - min + 1 != n)
	}

	/* UTILITY FUNCTIONS */
	int getMin(int arr[], int n) {
		int min = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] < min)
				min = arr[i];
		}
		return min;
	}

	int getMax(int arr[], int n) {
		int max = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		AreConsecutive consecutive = new AreConsecutive();
		// int arr[] = { 5, 4, 2, 3, 1, 6 };
		int arr[] = { 1, 4, 7, 3, 3, 5 };

		// int n = arr.length;
		// int result = equilibrium(arr);
		// int result2 = equi(arr);
		int result3 = equi2(arr);
		System.out.println("result3 : " + result3);

		/*
		 * if (consecutive.areConsecutive(arr, n) == true) System.out.println(
		 * "Array elements are consecutive"); else System.out.println(
		 * "Array elements are not consecutive");
		 */
	}
}

// This code has been contributed by Mayank Jaiswal
