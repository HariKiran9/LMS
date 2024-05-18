/**
 * 
 */
package thread.deadlock;

/**
 * @author Home
 *
 */
public class A {

	public synchronized void foo(B b) {
		System.out.println(" Entered into foo() of Class A ");
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			System.out.println("-- Exception Caught in Class A.foo()V --");
		}
		System.out.println("Class A trying to call lastB() of Class B");
		b.lastB();
	}

	public synchronized void lastA() {
		System.out.println(" Entered into lastA() of Class A");
	}
}
