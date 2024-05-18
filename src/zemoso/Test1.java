package zemoso;

public class Test1 {

	public static void main(String[] args) {
		int[] A = new int[6];
		A[0] = 1;
		A[1] = 3;
		A[2] = 6;
		A[3] = 4;
		A[4] = 1;
		A[5] = 2;
		
		int result1 = solutionPerm(A);

		int result2 = solutionMissing(A);
		
		int[] b = new int[6];
		b[0] = 1;
		b[1] = 4;
		b[2] = 7;
		b[3] = 3;
		b[4] = 3;
		b[5] = 5;
		
		int result3 = solution(b, b.length);
		System.out.println("====" + result3);
		

	}

	public static int solutionFrog(int X, int[] A) {
		int[] covered = new int[X + 1];

		int result = 0;
		for (int i = 0; i < A.length; i++) {
			if (covered[A[i]] == 0) {
				result = i;
			}
			covered[A[i]]++;
		}

		for (int i = 1; i < X + 1; i++) {
			if (covered[i] == 0) {
				return -1;
			}
		}

		return result;
	}

	public static int solutionPerm(int[] A) {
		int[] occurrences = new int[A.length];
		for (int aA : A) {
			if (aA > A.length) {
				return 0;
			}
			occurrences[aA - 1]++;
		}
		for (int i = 0; i < A.length; i++) {
			if (occurrences[i] != 1) {
				return 0;
			}
		}
		return 1;
	}

	public static int solutionMissing(int[] A) {
		final int maxN = 100000;
		int[] countRev = new int[maxN];
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0 && A[i] < maxN) {
				countRev[A[i]] = 1;
			}
		}

		// count all items > 0
		for (int i = 1; i < countRev.length; i++) {
			if (countRev[i] == 0) {
				return i;
			}
		}
		return 100001;
	}

	static int solution(int A[], int N) {
		// return 3 for [3,2,-5,1]
		int sum_prefix = 0;
		int sum_suffix = 0;
		int i, j;
		for (i = 0; i < N; i++) {
			// Check if is is the equilibrium point
			sum_prefix = 0;
			for (j = 0; j < i; j++) {
				sum_prefix += A[j];
			}
			sum_suffix = 0;
			for (j = i + 1; j < N; j++) {
				sum_suffix += A[j];
				// Compute suffix sum
			}
			if (sum_prefix == sum_suffix)
				return i;
		}
		return -1;
	}

}
