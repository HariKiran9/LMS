package point72;

public class TestThreads {

	public static void main(String[] args) {
		Thread t = new MyThread() {
			public void run() {
				System.out.print(" foo");
			}
		};
		t.start();

	}

}
