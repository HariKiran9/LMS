/**
 * 
 */
package uhg;

/**
 * @author Hari Kiran
 *
 */
public class Program {
	/*
	 * Method to find what to hit to get the score. Example: if the score is 23:
	 * During the first loop "i" will be 0 and "j" will start at 0 and iterate up to
	 * 61 -- it won't find a match of that score because hits[23] in the "if"
	 * statement is "null". Next, "i" will increment to 1 and j will start at 0.
	 * While i is 1 and j gets to 22, i + j will equal 23, matching the "else if"
	 * statement and because hits[i] and hits[j] of index 1 and 22 are not null, it
	 * will look up those values and print the output.
	 */
	public static void darts(int points, String[] hits) {

		for (int i = 0; i < hits.length; i++) {

			for (int j = 0; j < hits.length; j++) {

				if (j == points && hits[j] != null) {
					System.out.println("Throw on " + (hits[j]));
					return;
				} else if (i + j == points && hits[j] != null && hits[i] != null && points != 60) {
					System.out.println("Throw on " + (hits[j]));
					System.out.println("Throw on " + (hits[i]));
					return;
				}
			}
		}
		System.out.println("Throw on triple 20");
		points -= 60;

	}

	public static void main(String[] args) {
		int points = 301;
		System.out.println(points);

		/*
		 * Create Array that contains possible Dart Scores from 1 to 60 For numbers 1 to
		 * 20, 25, and 50, you can hit that exact number, but if it's divisible by 2 or
		 * 3 then it will show double or triple of a smaller number.
		 */

		String[] hits = new String[61];
		for (int i = 1; i < 21; i++) {
			hits[i] = Integer.toString(i);
			if (i % 2 == 0) {
				hits[i] = "double " + Integer.toString(i / 2);
			} else {
				hits[i] = Integer.toString(i);
				hits[i * 2] = "double " + Integer.toString(i);
				hits[i * 3] = "triple " + Integer.toString(i);

			}
		}
//		 System.out.println(hits[23]);
		hits[25] = "bullseye";
		hits[50] = "doublebull";

		darts(points, hits);

	}
}
