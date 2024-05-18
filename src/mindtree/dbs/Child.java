/**
 * 
 */
package mindtree.dbs;

/**
 * @author Hari Kiran
 *
 */
public class Child extends Parent {
	public String show(String str) {
		System.out.println("Child : " + str);
		return str;
	}

	public int calculate(int i) {
		System.out.println("Child : " + i);
		return i;
	}

}
