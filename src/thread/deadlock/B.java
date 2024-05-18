/**
 * 
 */
package thread.deadlock;

/**
 * @author Home
 *
 */
public class B {

	public synchronized void foo(A a) {
		System.out.println(" Entered into foo() of Class B ");
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Class B trying to call lastA() of Class A");
		a.lastA();
	}

	public synchronized void lastB() {
		System.out.println(" Entered into lastB() of Class B");
	}

}
