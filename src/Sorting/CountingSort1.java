package Sorting;

import java.util.Scanner;

/*
 * @author -- rajatgoyal715
 */

public class CountingSort1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int c[] = new int[100];
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			c[num]++;
		}
		for (int i = 0; i < 100; i++) {
			System.out.print(c[i] + " ");
		}
	}
}
