package DynamicProgramming;

import java.util.*;
import java.math.BigInteger;

/*
 * @author -- rajatgoyal715
 */

public class FibonacciModified {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		int n = sc.nextInt();
		BigInteger temp = BigInteger.valueOf(1);
		for (int i = 3; i <= n; i++) {
			temp = (b.multiply(b)).add(a);
			a = b;
			b = temp;
		}
		System.out.println(temp);
		sc.close();
	}
}
