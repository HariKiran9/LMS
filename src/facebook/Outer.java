/**
 * 
 */
package facebook;

/**
 * @author Sarvani
 *
 */
public class Outer {

	private int data = 15;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A inner = new A() {
			int data = 5;

			@Override
			public int getData() {
				return data;
			}

			public int getValue() {
				return data;
			}

		};

		Outer obj = new Outer();
//		System.out.println(inner.getData() + inner.getValue() + obj.data);
		System.out.println(inner.getData() + ", " + obj.data);
	}

}
