/**
 * 
 */
package uhg;

/**
 * @author Hari Kiran
 *
 */
public class UHGTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] input = new String[] { "D20", "T20", "T20", "T20", "T10", "1", "D16", "17" };
		System.out.println("Output : " + calculateScore(input));
	}

	private static int calculateScore(String[] inputStrArray) {
		int retValue = 301;
		if (inputStrArray.length > 0) {
			int previousIndex = 0;
			for (String inputStr : inputStrArray) {
				try {
					Integer.parseInt(inputStr);
				} catch (Exception e) {
					String str = inputStr.substring(0, 1);
					if (str.equalsIgnoreCase("D")) {
						String previousVaues = inputStrArray[previousIndex];
						String previous = previousVaues.substring(0, 1);
						if (previous.equalsIgnoreCase("T")) {
							int previousValue = Integer.parseInt(previous.substring(1));
							retValue = retValue + (previousValue * 3);
						}
						int inputValue = Integer.parseInt(inputStr.substring(1));
						retValue = retValue - (inputValue * 2);
					} else if (str.equalsIgnoreCase("T")) {
						int inputValue = Integer.parseInt(inputStr.substring(1));
						retValue = retValue - (inputValue * 3);
					}
				} // catch
				previousIndex++;
			} // for
		} else {

		} // else
		return retValue;
	}

}
