/**
 * 
 */
package techgig;

/**
 * @author Hari Kiran
 *
 */
public class SunTechTester1 extends Thread {

	int code = 9;

	@Override
	public void run() {
		this.code = 7;
	}

	public static void main(String[] args) {
		SunTechTester1 test = new SunTechTester1();
		test.start();

		for (int i = 0; i < 5; i++) {
			System.out.println(test.code);
		} // for
	}

}
