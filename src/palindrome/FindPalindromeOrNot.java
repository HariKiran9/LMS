package palindrome;

public class FindPalindromeOrNot {

	public static void main(String[] args) {
		String inputString = "liril";
		
		String s = "0111000";
		
		int k = Integer.parseInt(s, 2);
		System.out.println("----------"+ k); 

		boolean isPalindrome = true;
		char[] inputStringArr = inputString.toCharArray();
		int length = inputStringArr.length;
		int temp = length;
		for (int n = 0; n < length; n++) {
			temp -= 1;
			if (inputStringArr[n] != inputStringArr[temp]) {
				isPalindrome = false;
			} // if
		} // for
		System.out.println("Is Palindrome = " + isPalindrome);

	}

}
