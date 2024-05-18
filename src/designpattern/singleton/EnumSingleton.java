/**
 * 
 */
package designpattern.singleton;

import java.io.Serializable;

/**
 * @author Home
 *
 */
public enum EnumSingleton implements Serializable {
	INSTANCE;

	private MySingleton singleTon = null;

	int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public MySingleton getInstance(String threadName) {
		if (singleTon == null) {
//			return singleTon = new MySingleton("...IF..." + threadName);
		} else {
			System.out.println("...ELSE...");
		}
		return singleTon;
	}

}
