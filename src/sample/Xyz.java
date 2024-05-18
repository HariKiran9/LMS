package sample;

public class Xyz {

	static int i = 0;

	public static void check() {
		int i, j, k;
		for (i = 0; i < 3; i++) {
			System.out.println(" Start of i = " + i);
			for (j = 1; j < 4; j++) {
				System.out.println(" Start of j = " + j);
				for (k = 2; k < 5; k++) {
					System.out.println(" Start of k = " + k);
					if ((i == j) && (j == k)) {
						System.out.println(i);
					}
				}

			}

		}
	}

	public static void check1() {
		while (i < 0) {
			i--;
		}
		System.out.println(i);
	}

	public static void main(String[] args) {
		check();
	}

}
