/**
 * 
 */
package thread.deadlock;

/**
 * @author Home
 *
 */
public class DeadLockTest extends Thread {

	private A a = new A();
	private B b = new B();

	public DeadLockTest() {
		Thread thread = new Thread(this);
		thread.start();
		b.foo(a);
	}

	@Override
	public void run() {
		a.foo(b);
	}

	public static void main(String[] args) {
		new DeadLockTest();
	}

}
