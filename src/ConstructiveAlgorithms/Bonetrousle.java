package ConstructiveAlgorithms;

public class Bonetrousle {
	public static void main(String[] args) {
		int t = 5;
		for (int z = 0; z < t; z++) {
			long n = 6;
			long k = 7;
			int b = 8;
			long diff = k - b;
			long[] selected = new long[b];
			long sum = 0;
			for (int i = 0; i < b; i++) {
				selected[i] = i + 1;
				sum += i + 1;
			}
			if (sum > n) {
				System.out.println(-1);
				continue;
			}
			long next = k + 1;
			for (int i = b - 1; i >= 0; i--) {
				sum += diff;
				if (sum < n) {
					selected[i] = --next;
				} else {
					sum -= diff;
					selected[i] = n - sum + selected[i];
					sum = n;
					break;
				}
			}
			if (sum < n) {
				System.out.println(-1);
				continue;
			}
			StringBuilder print = new StringBuilder();
			for (int i = 0; i < b; i++) {
				if (i > 0)
					print.append(" ");
				print.append(selected[i]);
			}
			System.out.println(print);
		}
	}
}