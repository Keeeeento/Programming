package kadai12;

public class Kuku {

	public static void main(String[] args) {
		int[][] a = new int[9][9];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (i + 1) * (j + 1);
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();

		}
	}

}
