package sample12;

public class MatrixVectorMethods {

	public static void main(String[] args) {

		int[] x = { 2, -3, 5 };
		int[] y = { -4, 1, 7 };

		int[][] A = { { 1, 0, 2 }, { -2, 1, 4 }, { 0, 3, 2 } };
		int xTy = seki1(x, y);
		int[] Ax = seki2(A, x);
		int[][] xyT = seki3(x, y);

	}

	public static int seki1(int x[], int y[]) {
		int val = 0;
		for (int i = 0; i < x.length; i++) {
			val += x[i] * y[i];
		}
		return val;	
	}

	public static int[] seki2(int[][] A, int[] x) {
		int val[] = { 0, 0, 0 };
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x.length; i++) {
				val[i] += A[i][j] * x[j];
			}
		}
		return val;
	}

	public static int[][] seki3(int[] x, int[] y) {
		int val[][] = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x.length; j++) {
				val[i][j] = x[i] * y[j];
			}
		}
		return val;
	}

}
