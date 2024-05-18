package algorithms.search.types;

public class PatternSearch {

	public static void main(String[] args) {
		String text = "AABAACAADAABAAABAABA";
		String pattern = "AABA";
		search(pattern, text);
	}

	public static void search(String pattern, String text) {
		char[] patterArray = pattern.toCharArray();
		char[] textArray = text.toCharArray();
		int M = pattern.length();
		int N = text.length();
		/* A loop to slide pat[] one by one */
		for (int i = 0; i <= N - M; i++) {
			int j;

			/* For current index i, check for pattern match */
			for (j = 0; j < M; j++)
				if (textArray[i + j] != patterArray[j])
					break;

			if (j == M) // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
				System.out.println("Pattern found at index : " + i);
		} // for

	}

}
