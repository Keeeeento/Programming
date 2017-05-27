package exercise10;
// 行列の行の入れ替え
public class Problem2 {

	public static void main(String[] args) {
		int n = 10;
		int a[][] = new int[n][n];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = i + j; // 行列a_(n*n)の第(i,j)成分をi+j.
			}
		}
		printMatrix(a);

		int k = 1;
		int ell = 3;
		Change(a, k, ell);

		System.out.println();
		System.out.println(k + "行目と" + ell + "行目を交換");

		printMatrix(a);
	}

	// 行列の第k行目と
	public static void Change(int[][] a, int k, int ell) {
		int temp = 0;
		for (int j = 0; j < a.length; j++) {
			temp = a[k - 1][j];
			a[k - 1][j] = a[ell - 1][j];
			a[ell - 1][j] = temp;
		}
		return;
	}

	public static void printMatrix(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		return;
	}
}
