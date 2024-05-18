package primenums;

public class PrimeNumbers2 {
	public static void main(String[] args) {
		// int i = 0;
		// int num = 0;
		// Empty String
		String primeNumbers = "";
		System.out.println("Enter the value of n:");
		int finalNo = 0;
		int n = 100;
		for (int i = 1; i <= n; i++) {
			int counter = 0;
			for (int num = i; num >= 1; num--) {
				// System.out.println(" num : " + num);
				if (i % num == 0) {
					counter = counter + 1;
					// System.out.println(" Counter [num" + "] : " + counter);
				}
			}
			if (counter == 2) {
				// Appended the Prime number to the String
				primeNumbers = primeNumbers + i + " ";
				finalNo = i;
			}
		}
		System.out.println("Prime numbers from 1 to n are :");
		System.out.println(primeNumbers);
		System.out.println(finalNo);
	}

}
