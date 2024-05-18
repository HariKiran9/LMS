package sample;

public class Test {

	public static void check() {
		int i = 0;
		do {
			i++;
		} while (i < 0);
		System.out.println(i);
	}

	public static void main(String[] args) {

		check();
	}

}
