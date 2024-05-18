package cipher;

public class ShiftCiper {
//	char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
//			't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public static void main(String[] args) {
		System.out.println(cipher("nrfzh", 3));

	}

	public static String cipher(String msg, int shift) {
		String s = "";
		int len = msg.length();
		for (int x = 0; x < len; x++) {
			char c = (char) (msg.charAt(x) + shift);
			System.out.println(cipher("nrfzh", 3));
			if (c > 'z')
				s += (char) (msg.charAt(x) - (26 - shift));
			else
				s += (char) (msg.charAt(x) + shift);
		}
		return s;
	}

}
