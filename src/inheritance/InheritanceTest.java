package inheritance;

public class InheritanceTest {

	public static void main(String[] args) {
		A a = new A();
		a.method1();

		B b = new B();
		b.method1();

		A ab = new B();
		ab.method1();
		
//		B ab2 = new A();

	}

}
