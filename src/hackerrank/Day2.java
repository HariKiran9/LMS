package hackerrank;

import java.util.Scanner;

public class Day2 {

	public static void main(String[] args) {
		int i = 4;
		double d = 4.0;
		String s = "HackerRank";

		Scanner scan = new Scanner(System.in);

		int rollno = scan.nextInt();
		System.out.println(i + rollno);
		double salary = scan.nextDouble();
		System.out.println(d + salary);
		// char[] name = scan.next().toCharArray();
		// String name1 = new String(name);
		StringBuffer sb = new StringBuffer();
		while (scan.hasNextLine()) {
			sb.append(scan.next());
		}

		System.out.println(s + " " + sb.toString());

		scan.close();
	}

}
