package techgig;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class DateTimeTest {

	public static void main(String[] args) {
		HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();

		String[] strArrDates1 = new String[] { "31/12/1998 12:01#31/12/1998 12:02", "31/12/1998 12:01#31/12/1998 12:02",
				"31/12/1998 12:01#31/12/1998 12:05", "31/12/1998 12:03#31/12/1998 12:04" };

		String[] strArrDates2 = new String[] { "31/12/1998 14:03#31/12/1998 12:04" };
		String[] strArrDates3 = new String[] { "31/12/1998 12:01#31/12/1998 12:02" };

		List<Integer> intList = new ArrayList<Integer>();

		for (int j = 0; j < strArrDates1.length; j++) {
			String givenDate = strArrDates1[j];
			String[] givenDateAerr = givenDate.split("#");

			String[] arrDates = new String[2];
			for (int i = 0; i < givenDateAerr.length; i++) {
				arrDates[i] = givenDateAerr[i];
			}

			String outTimeDiff = getDateDifference(arrDates[0], arrDates[1]);
			System.out.println("outTimeDiff" + outTimeDiff);
			if (Integer.valueOf(outTimeDiff) > 0) {
				intList.add(Integer.valueOf(outTimeDiff));
			} else {
				System.out.println("outTimeDiff" + outTimeDiff);
			}
		} // for
		if (!intList.isEmpty()) {

			for (int i = 0; i < intList.size(); i++) {
				Integer num = intList.get(i);
				if (hMap.containsKey(num)) {
					int count = hMap.get(num);
					count += 1;
					hMap.put(num, count);
				} else {
					hMap.put(num, 1);
				}
			} // for

			int[] maxArr = new int[hMap.size()];
			int count = 0;
			for (Integer key : hMap.keySet()) {
				maxArr[count] = hMap.get(key);
				count++;
			}

			int result = getMax(maxArr);
			System.out.println(" Result : " + result);
		}

	}

	public static int getMax(int[] numbers) {
		int largest = Integer.MIN_VALUE;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > largest) {
				largest = numbers[i];
			}
		}
		return largest;
	}

	private static String getDateDifference(String startDateTime, String endDateTime) {
		String dateFormat = "";
		try {
			String format = "dd/MM/yyyy HH:mm";
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date fromDate = sdf.parse(startDateTime);
			Date toDate = sdf.parse(endDateTime);

			long diff = toDate.getTime() - fromDate.getTime();

			int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
			if (diffDays > 0) {
				dateFormat += diffDays + " day ";
			}
			diff -= diffDays * (24 * 60 * 60 * 1000);

			int diffhours = (int) (diff / (60 * 60 * 1000));
			if (diffhours > 0) {
				dateFormat += diffhours + " hour ";
			}
			diff -= diffhours * (60 * 60 * 1000);

			int diffmin = (int) (diff / (60 * 1000));
			if (diffmin > 0) {
				dateFormat += diffmin;
			}
			diff -= diffmin * (60 * 1000);

			int diffsec = (int) (diff / (1000));
			if (diffsec > 0) {
				dateFormat += diffsec + " sec";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != dateFormat && !"".equals(dateFormat)) {
			return dateFormat;
		} else {
			return "-1";
		}

	}

}
