/**
 * 
 */
package org.tm.time;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TimeCalculation {

	public Map<String, String> timeCalculation(String filePath) {
		Map<String, String> resultMap = new HashMap<String, String>();

		Map<String, Date> stMap = new HashMap<String, Date>();
		Map<String, Date> edMap = new HashMap<String, Date>();

		InputStream inputStream = null;
		BufferedReader bufferedReader = null;
		try {
			inputStream = new FileInputStream(filePath);
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy - MM - dd h:mm a");
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				int index = line.lastIndexOf(",");
				String status = line.substring(index + 1, line.length()).trim();
				String dateTimeArr[] = line.substring(0, index).trim().split(",");
				String strDateTime = dateTimeArr[1].trim() + " " + dateTimeArr[2].trim();
				Date date = sdf.parse(strDateTime);

				if (status.equals("End")) {
					edMap.put(dateTimeArr[0], date);
				}
				if (status.equals("start")) {
					stMap.put(dateTimeArr[0], date);
				}
			} // while

			Set<Entry<String, Date>> set = stMap.entrySet();
			Iterator<Entry<String, Date>> itr = set.iterator();
			while (itr.hasNext()) {
				Entry<String, Date> entry = itr.next();
				String taskId = entry.getKey();
				Date taskStDate = entry.getValue();
				if (edMap.containsKey(taskId)) {
					Date taskEdDate = edMap.get(taskId);
					long diff = taskEdDate.getTime() - taskStDate.getTime();
					long diffSeconds = diff / 1000 % 60;
					long diffMinutes = diff / (60 * 1000) % 60;
					long diffHours = diff / (60 * 60 * 1000) % 24;
					long diffDays = diff / (24 * 60 * 60 * 1000);

					StringBuilder sb = new StringBuilder();
					sb.append(diffDays).append(" days, ");
					sb.append(diffHours).append(" hours, ");
					sb.append(diffMinutes).append(" minutes, ");
					sb.append(diffSeconds).append(" seconds");
					resultMap.put(taskId, sb.toString());
				}
			} // while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // finally
		return resultMap;
	}

}
