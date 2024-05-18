package algorithms.search.types;

public class BubbleSort {

	public void bubbleSort1(int[] unsorted) {

		for (int i = 0; i < unsorted.length; i++) {
			for (int j = 0; j < unsorted.length; j++) {
				if (unsorted[i] < unsorted[j]) {
					int temp = unsorted[i];
					unsorted[i] = unsorted[j];
					unsorted[j] = temp;
				}
			}
		}
	}

	public void bubbleSort2(int[] unsorted) {
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 0; i < unsorted.length - 1; i++) {
				if (unsorted[i] > unsorted[i + 1]) {
					int temp = unsorted[i];
					unsorted[i] = unsorted[i + 1];
					unsorted[i + 1] = temp;
					swapped = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		BubbleSort s = new BubbleSort();
		int[] arr = new int[] { 5, 3, 8, 9, 2, 1, 7, 10 };
		s.bubbleSort1(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
