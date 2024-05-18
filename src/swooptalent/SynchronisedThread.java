package swooptalent;

public class SynchronisedThread {

	String str1 = "swoop";
	String str2 = "talent";

	Thread t1 = new Thread("My Thread1") {
		@Override
		public void run() {
			synchronized (str1) {
				synchronized (str2) {
					System.out.println("Entered into Thread1");
				}

			}
		}
	};

	Thread t2 = new Thread("My Thread2") {
		@Override
		public void run() {
			synchronized (str2) {
				synchronized (str1) {
					System.out.println("Entered into Thread2");
				}

			}
		}
	};

	public static void main(String[] args) {
		SynchronisedThread thread = new SynchronisedThread();
		thread.t1.start();
		thread.t2.start();

	}

}
