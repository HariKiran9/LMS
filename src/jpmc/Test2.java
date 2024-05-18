package jpmc;

public class Test2 {

	public static void main(String[] args) {
		String line = "ABCE";// A B C E

		char[][] matrix = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		char[] ch = line.toCharArray();
		int k = 0, j = 0;
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			matrix[k][j] = c;
			j++;

		}

		System.out.println();

	}

}
