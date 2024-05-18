package designpattern.singleton;

import org.apache.log4j.Logger;

public class MySingleton {

	public static final Logger log = Logger.getLogger(MySingleton.class);

	private String threadName;

	private static MySingleton mySingleton = null;

	private MySingleton() {
		System.out.println(".. in MySingleton constructor...");
		// this.threadName = threadName;
	}

	public static MySingleton getInstance() {
		if (mySingleton == null) {
			synchronized (MySingleton.class) {
				if (mySingleton == null) {
					System.out.println("...IF...");
					mySingleton = new MySingleton();
				}
			}

		}
		System.out.println("...ELSE...");
		return mySingleton;
	}

	@Override
	public String toString() {
		return this.threadName;
	}

}
