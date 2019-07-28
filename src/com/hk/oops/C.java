/**
 * 
 */
package com.hk.oops;

/**
 * @author Hari Kiran
 *
 */
public class C extends B {

	/**
	 * 
	 */
	public C() {
		System.out.println(" C ()");
	}

	/**
	 * @param x
	 */
	public C(int x) {
		super(x);
		System.out.println(" C (" + x + ")");
	}

	/**
	 * @param x
	 * @param y
	 */
	public C(int x, int y) {
		super(x, y);
		System.out.println(" C (" + x + ", y " + y + ")");
	}

}
