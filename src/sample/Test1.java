package sample;

public class Test1 {

	static boolean check;

	public static void work() {
		int i;
		if (check == true) {
			i = 1;
		} else {
			i = 2;
		}
		if (i == 2) {
			i = i + 2;
		} else {
			i = i + 4;
		}
		System.out.println(i);
	}

	public static void work1() {
		char ch;
		String test2 = "abcd";
		String test = new String("abcd");
		if (test.equals(test2)) {
			if (test == test2) {
				ch = test.charAt(0);
			} else {
				ch = test.charAt(1);
			}
		} else {
			if (test == test2) {
				ch = test.charAt(2);
			} else {
				ch = test.charAt(4);
			}
		}

		System.out.println(ch);
	}

	public static void work2() {
		int i, j;
		i = j = 3;
		int n = 2 * ++i;
		int m = 2 * i++;
		System.out.println("i : " + i + " j : " + j + " n : " + n + " m : " + m);
	}

	public static void main(String[] args) {
		work2();
	}

}
