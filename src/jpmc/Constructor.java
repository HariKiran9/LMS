package jpmc;

public class Constructor {

	public Constructor() {
		this(10, 11);
	}

	public Constructor(int a, int b) {
		System.out.println("in parameter");
	}

	public static void main(String[] args) {
		new Constructor();
	}

}
