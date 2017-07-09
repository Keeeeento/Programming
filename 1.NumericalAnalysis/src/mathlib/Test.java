package mathlib;

public class Test {
	public static void main(String[] args) {
		long start = System.nanoTime();
		int n = 10;
		double[][] aData = new double[n][n];
		aData[0][0] = aData[n - 1][n - 1] = 2;
		for (int i = 1; i < n - 1; i++) {
			aData[i][i] = 2;
			aData[i][i - 1] = -1;
			aData[i][i + 1] = -1;
		}
		Matrix a = new Matrix(aData);

		double[] bData = new double[n];
		for (int i = 0; i < n; i++) {
			bData[i] = 1;
		}

		Vector b = new Vector(bData);

		GaussianElimination.solve(a, b).print("Gauss");
		GaussianElimination.pivotSolve(a, b).print("PovotGauss");
		LUDecomposition.solve(a, b).print("LU");
		Jacobi.solve(a, b).print("Jacobi");
		GaussSeidel.solve(a, b).print("GasuuSeidel");

		// Vector c = new Vector(new double[] { 2, 3, 4 });
		// Vector d = new Vector(new double[] { 0, 4, 6 });
		//
		// // a.gaussianElimination(a, b).print("x");
		// // b.sub(b, c).print();
		// // System.out.println(b.getManhattanNorm());
		// // a.diagnal().print();
		// // System.out.println(b.innerProduct(b, c));
		//
		// // a.setEpsilon(1e-12);
		// // a.jacobi(a, b).print("jacobi");
		// // a.gaussSeidel(a, b).print("gaussSeidel");
		// // Jacobi.solve(a, d);
		// // a.gaussSeidel(a, d).print();
		//
		// c.deltaAddedVector().print();
		long end = System.nanoTime();
		System.out.println("Time:" + (end - start) / 1000000f + "ms");

		Matrix c = new Matrix(new double[][] { { 2, 3 }, { 3, 2 } });
		System.out.println(c.getDeterminant());

	}

}
