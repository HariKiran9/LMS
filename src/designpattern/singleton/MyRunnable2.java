/**
 * 
 */
package designpattern.singleton;

/**
 * @author Home
 *
 */
public class MyRunnable2 implements Runnable {

	private String threadName;

	public MyRunnable2(String threadName) {
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
			// System.out.println("MyRunnable2 : " +
			// EnumSingleton.INSTANCE.getInstance(this.threadName));
			System.out.println("MyRunnable2 : " + MySingleton.getInstance());
		}

	}

}
