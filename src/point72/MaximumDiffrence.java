package point72;

public class MaximumDiffrence {
	int maxDiff(int a[]) {
		int arr_size = a.length;
		int max_diff = a[1] - a[0];
		int i, j;
		for (i = 0; i < arr_size; i++) {
			for (j = i + 1; j < arr_size; j++) {
				if (a[j] - a[i] > max_diff)
					max_diff = a[j] - a[i];
			}
		}
		return max_diff;
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		MaximumDiffrence maxdif = new MaximumDiffrence();
		// int arr[] = { 1, 2, 90, 10, 110 };

		// int arr[] = {7, 9, 5, 6, 3, 2};
		int arr[] = { 2, 3, 10, 2, 4, 8, 1 };
		System.out.println("Maximum differnce is " + maxdif.maxDiff(arr));
	}

}
