package palindrome;

import org.junit.Test;

public class PalindromeChecker {
	/*
	 * This method check if a given String is palindrome or not using recursion
	 */
	public static boolean isPalindrome(String input) {
		if (input == null) {
			return false;
		}
		String reversed = reverse(input);

		return input.equals(reversed);
	}

	public static String reverse(String str) {
		if (str == null) {
			return null;
		}

		if (str.length() <= 1) {
			return str;
		}

		return reverse(str.substring(1)) + str.charAt(0);
	}

	/*
	 * Iterative algorithm to check if given String is palindrome or not
	 */
	public static boolean checkPalindrome(String text) {

		StringBuilder sb = new StringBuilder(text);
		char[] contents = text.toCharArray();

		for (int i = text.length() - 1; i >= 0; i--) {
			sb.append(contents[i]);
		}

		String reversed = sb.toString();

		/*
		 * char v1[] = text.toCharArray(); char v2[] = contents;
		 * System.out.println(myEquals(v1, v2));
		 */

		return text.equals(reversed);
	}

	public static boolean myEquals(char[] input, char[] converted) {
		int i = 0;
		int n = input.toString().length();
		while (n-- != 0) {
			if (input[i] != converted[i])
				return false;
			i++;
		}
		return true;
	}

	@Test
	public void testPalindromeRecursive() {
		org.junit.Assert.assertTrue(isPalindrome("madam"));
		org.junit.Assert.assertFalse(isPalindrome("programming"));
		org.junit.Assert.assertTrue(isPalindrome(""));
		org.junit.Assert.assertTrue(isPalindrome("AIA"));
	}

	@Test
	public void testPalindrome() {
		org.junit.Assert.assertFalse(isPalindrome("wonder"));
		org.junit.Assert.assertFalse(isPalindrome("cat"));
		org.junit.Assert.assertTrue(isPalindrome("aaa"));
		org.junit.Assert.assertTrue(isPalindrome("BOB"));
	}

	private static void checkPalindromeNumber() {
		int remaninder, sum = 0, temp;
		int inputNumber = 454;// It is the number variable to be checked for palindrome
		int counter = 0;
		temp = inputNumber;
		while (inputNumber > 0) {
			remaninder = inputNumber % 10; // getting remainder
			sum = (sum * 10) + remaninder;
			inputNumber = inputNumber / 10;
			counter++;
		}
		if (temp == sum)
			System.out.println("palindrome number ");
		else
			System.out.println("not palindrome");

		System.out.println("Conter : " + counter);
	}

	public static void main(String[] args) {
		// PalindromeChecker p = new PalindromeChecker();
		String text = "wonder";
		boolean check = checkPalindrome(text);
		System.out.println(check);
		checkPalindromeNumber();

	}

}
