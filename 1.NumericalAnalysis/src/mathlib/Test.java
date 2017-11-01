package mathlib;

public class Test {
	public static void main(String[] args) {

		int n = 10;
		double[][] adata = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				adata[i][j] = i + j + 1;
			}
		}
		// i = 2
		// 0.9594929736144973

		Matrix a = new Matrix(new double[][] { { 4, 1, 1 }, { 1, 5, 3 }, { 1, 3, 15 } });
		Vector b = new Vector(new double[] { 5, 4, 3 });

		//		Vector x = GaussianElimination.pivotSolve(a, b);
		//		x.print("x");
		//		a.print("a");
		//		System.out.println(a.getNorm(2));

		//		LUDecomposition.solve(a, b).print("LUDecomposition");
		//		CholeskyDecomposition.getL(a).multiply(CholeskyDecomposition.getL(a).transpose()).print();
		//		CholeskyDecomposition.getLBySum(a).print("L");
		//		CholeskyDecomposition.solve(a, b).print("CholeskyDecomposition");

		a.printTeX("a");

		System.out.println(returnAddedX(1));

	}

	public static void changeX(double x) {
		x += 1.0;
	}

	public static double returnAddedX(double x) {
		changeX(x);
		return x;
	}
}