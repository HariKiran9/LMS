/**
 * 
 */
package designpattern.singleton;

/**
 * @author Home
 *
 */
public class MyRunnable1 implements Runnable {

	private String threadName;

	public MyRunnable1(String threadName) {
		this.threadName = threadName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			// System.out.println("MyRunnable1 : " +
			// EnumSingleton.INSTANCE.getInstance(this.threadName));
			System.out.println("MyRunnable1 : " + MySingleton.getInstance());
		}

		MySingleton my = EnumSingleton.INSTANCE.getInstance(this.threadName);

	}

}
