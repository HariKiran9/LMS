package palindrome;

import java.util.Arrays;

public class CompareArray {

	public static void main(String[] args) {
		int inarr1[] = { 1, 2, 3 };
		int inarr2[] = { 1, 2, 3 };
		Object[] arr1 = { inarr1 }; // arr1 contains only one element
		Object[] arr2 = { inarr2 }; // arr2 also contains only one element
		Object[] outarr1 = { arr1 }; // outarr1 contains only one element
		Object[] outarr2 = { arr2 }; // outarr2 also contains only one element
		if (Arrays.deepEquals(outarr1, outarr2))
			System.out.println("Same");
		else
			System.out.println("Not same");
	}

	public static boolean compareArray(Object[] a1, Object[] a2) {
		if (a1 == a2)
			return true;
		if (a1 == null || a2 == null)
			return false;
		int length = a1.length;
		if (a2.length != length)
			return false;

		for (int i = 0; i < length; i++) {
			Object e1 = a1[i];
			Object e2 = a2[i];

			if (e1 == e2)
				continue;
			if (e1 == null)
				return false;

			// Figure out whether the two elements are equal
			boolean eq = deepEquals0(e1, e2);

			if (!eq)
				return false;
		}
		return true;

	}

	static boolean deepEquals0(Object e1, Object e2) {
		assert e1 != null;
		boolean eq;
		if (e1 instanceof Object[] && e2 instanceof Object[])
			eq = compareArray((Object[]) e1, (Object[]) e2);
		// else if (e1 instanceof byte[] && e2 instanceof byte[])
		// eq = equals((byte[]) e1, (byte[]) e2);
		// else if (e1 instanceof short[] && e2 instanceof short[])
		// eq = equals((short[]) e1, (short[]) e2);
		else if (e1 instanceof int[] && e2 instanceof int[])
			eq = equals((int[]) e1, (int[]) e2);
		// else if (e1 instanceof long[] && e2 instanceof long[])
		// eq = equals((long[]) e1, (long[]) e2);
		// else if (e1 instanceof char[] && e2 instanceof char[])
		// eq = equals((char[]) e1, (char[]) e2);
		else if (e1 instanceof float[] && e2 instanceof float[])
			eq = equals((float[]) e1, (float[]) e2);
		// else if (e1 instanceof double[] && e2 instanceof double[])
		// eq = equals((double[]) e1, (double[]) e2);
		else if (e1 instanceof boolean[] && e2 instanceof boolean[])
			eq = equals((boolean[]) e1, (boolean[]) e2);
		else
			eq = e1.equals(e2);
		return eq;
	}

	public static boolean equals(boolean[] a, boolean[] a2) {
		if (a == a2)
			return true;
		if (a == null || a2 == null)
			return false;

		int length = a.length;
		if (a2.length != length)
			return false;

		for (int i = 0; i < length; i++)
			if (a[i] != a2[i])
				return false;

		return true;
	}

	public static boolean equals(int[] a, int[] a2) {
		if (a == a2)
			return true;
		if (a == null || a2 == null)
			return false;

		int length = a.length;
		if (a2.length != length)
			return false;

		for (int i = 0; i < length; i++)
			if (a[i] != a2[i])
				return false;

		return true;
	}

	public static boolean equals(float[] a, float[] a2) {
		if (a == a2)
			return true;
		if (a == null || a2 == null)
			return false;

		int length = a.length;
		if (a2.length != length)
			return false;

		for (int i = 0; i < length; i++)
			if (a[i] != a2[i])
				return false;

		return true;
	}

}
