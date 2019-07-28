package com.sarvani;

import java.util.function.Predicate;

public class Sample {

	public static void main(String[] args) {
		String str = "ETV Gemini ZeeTV MaaTV Star Republic Tez AajTak Vissa Tollywood";
		System.out.println("  Input String : " + str);
		Sample sample = new Sample();
		String search2 = sample.search2(str, "Kiran");
		System.out.println(" Output search2 : " + search2);

		String search1 = sample.search1(str, "Star");
		System.out.println(" Output search1 : " + search1);
	}

	// Solution # 1 :
	private String search1(String str, final String inputChannelName) {
		str = str.replace(inputChannelName + " ", "");
		return inputChannelName + " " + str;
	}

	// Solution # 2 :
	private String search2(final String str, final String inputChannelName) {
		String retVal = "";
		String channels[] = str.split(" ");
		/**
		 * Scenario # 1 - Find whether the given exists - bring that value to beginning
		 * 
		 * Scenario # 2 - Find whether the given does not exists - bring that value to
		 * beginning and remove the tailing value
		 */

		retVal = checkIfExistsOrNot(channels, inputChannelName);

		return retVal;
	}

	private String checkIfExistsOrNot(final String[] inputChannelArray, final String inputChannelName) {
		String sb = null;
		int indexChannelFound = 0;
		for (int i = 0; i < inputChannelArray.length; i++) {
			final String channel = inputChannelArray[i];
			Predicate<String> predicate = eq -> channel.equalsIgnoreCase(inputChannelName);
			if (predicate.test(inputChannelArray[i])) {
				indexChannelFound = i;
			} // if
		} // for

		if (indexChannelFound > 0) {// If given Channel Found
			String temp = inputChannelArray[indexChannelFound];
			for (int i = indexChannelFound; i > 0; i--) {
				inputChannelArray[i] = inputChannelArray[i - 1];
			} // for
			inputChannelArray[0] = temp;
		} else {// If given Channel not Found
			for (int i = inputChannelArray.length - 1; i > 0; i--) {
				if (i > 0) {
					inputChannelArray[i] = inputChannelArray[i - 1];
				}
			} // for
			inputChannelArray[0] = inputChannelName;
		}

		for (int i = 0; i < inputChannelArray.length; i++) {
			// System.out.println(" Channel Name : [" + i + "]" + inputChannelArray[i]);
			if (sb != null && sb.toString().trim().length() > 0) {
				sb = sb + " " + inputChannelArray[i];
			} else {
				sb = inputChannelArray[i];
			}
		} // for
		return sb;
	}
}
