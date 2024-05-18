package sample;

import java.io.UnsupportedEncodingException;

public class UnicodeConvertion {

	public static void main(String[] args) {
		try {
			String myString = new String("\\u0070\\u0075\\u0062\\u006c\\u0069\\u0063\\u0020\\u0020\\u0020\\u0020\r\n"
					+ "\\u0063\\u006c\\u0061\\u0073\\u0073\\u0020\\u0055\\u0067\\u006c\\u0079\r\n"
					+ "\\u007b\\u0070\\u0075\\u0062\\u006c\\u0069\\u0063\\u0020\\u0020\\u0020\r\n"
					+ "\\u0020\\u0020\\u0020\\u0020\\u0073\\u0074\\u0061\\u0074\\u0069\\u0063\r\n"
					+ "\\u0076\\u006f\\u0069\\u0064\\u0020\\u006d\\u0061\\u0069\\u006e\\u0028\r\n"
					+ "\\u0053\\u0074\\u0072\\u0069\\u006e\\u0067\\u005b\\u005d\\u0020\\u0020\r\n"
					+ "\\u0020\\u0020\\u0020\\u0020\\u0061\\u0072\\u0067\\u0073\\u0029\\u007b\r\n"
					+ "\\u0053\\u0079\\u0073\\u0074\\u0065\\u006d\\u002e\\u006f\\u0075\\u0074\r\n"
					+ "\\u002e\\u0070\\u0072\\u0069\\u006e\\u0074\\u006c\\u006e\\u0028\\u0020\r\n"
					+ "\\u0022\\u0048\\u0065\\u006c\\u006c\\u006f\\u0020\\u0077\\u0022\\u002b\r\n"
					+ "\\u0022\\u006f\\u0072\\u006c\\u0064\\u0022\\u0029\\u003b\\u007d\\u007d");

			String myString1 = "\u0048\u0065\u006C\u006C\u006F World";

			byte[] utf8Bytes = myString.getBytes("UTF8");
			String text = new String(utf8Bytes, "UTF8");
			System.out.println(text);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
