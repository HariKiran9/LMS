package org.tm;

import java.util.Map;

import org.tm.time.TimeCalculation;

public class App {
	public static void main(String[] args) {
		TimeCalculation time = new TimeCalculation();
		Map<String, String> resultMap = time.timeCalculation("D:\\HK\\interview\\transaction_log.txt");
		System.out.println(resultMap);
	}

}
