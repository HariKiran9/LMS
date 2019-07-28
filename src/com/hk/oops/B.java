/**
 * 
 */
package com.hk.oops;

/**
 * @author Hari Kiran
 *
 */
public class B extends A {

	/**
	 * 
	 */
	public B() {
		System.out.println(" B ()");
	}

	/**
	 * @param x
	 */
	public B(int x) {
		super(x);
		System.out.println(" B (" + x + ")");
	}

	/**
	 * @param x
	 * @param y
	 */
	public B(int x, int y) {
		super(x, y);
		System.out.println(" B (" + x + ", y " + y + ")");
	}

}
