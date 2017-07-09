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

		Vector x = new Vector(new double[] { 0.5, 4.5, 7.5, 9.5, 10.5, 10.5, 9.5, 7.5, 4.5, 0.5 });

		Vector b = new Vector(bData);

		System.out.println("-Gaussian Elimination-");
		Vector x1 = GaussianElimination.solve(a, b);
		System.out.println("relativeError1one = " + x1.getRelativeErrorOfOneNorm(x));
		System.out.println("relativeError1inf = " + x1.getRelativeErrorOfInfinityNorm(x));
		System.out.println("absoluteError1one = " + x1.getAbsoluteErrorOfOneNorm(x));
		System.out.println("absoluteError1inf = " + x1.getAbsoluteErrorOfInfinityNorm(x));
		System.out.println();

		System.out.println("-Pivod Gaussian Elimination-");
		Vector x2 = GaussianElimination.pivotSolve(a, b);
		System.out.println("relativeError2one = " + x2.getRelativeErrorOfOneNorm(x));
		System.out.println("relativeError2inf = " + x2.getRelativeErrorOfInfinityNorm(x));
		System.out.println("absoluteError2one = " + x2.getAbsoluteErrorOfOneNorm(x));
		System.out.println("absoluteError2inf = " + x2.getAbsoluteErrorOfInfinityNorm(x));
		System.out.println();

		System.out.println("-LU Decomposition-");
		Vector x3 = LUDecomposition.solve(a, b);
		System.out.println("relativeError3one = " + x3.getRelativeErrorOfOneNorm(x));
		System.out.println("relativeError3inf = " + x3.getRelativeErrorOfInfinityNorm(x));
		System.out.println("absoluteError3one = " + x3.getAbsoluteErrorOfOneNorm(x));
		System.out.println("absoluteError3inf = " + x3.getAbsoluteErrorOfInfinityNorm(x));
		System.out.println();

		System.out.println("-Jacobi-");
		Vector x4 = Jacobi.solve(a, b);
		System.out.println("relativeError4one = " + x4.getRelativeErrorOfOneNorm(x));
		System.out.println("relativeError4inf = " + x4.getRelativeErrorOfInfinityNorm(x));
		System.out.println("absoluteError4one = " + x4.getAbsoluteErrorOfOneNorm(x));
		System.out.println("absoluteError4inf = " + x4.getAbsoluteErrorOfInfinityNorm(x));
		System.out.println();

		System.out.println("-Gauss Seidel-");
		Vector x5 = GaussSeidel.solve(a, b);
		System.out.println("relativeError5one = " + x5.getRelativeErrorOfOneNorm(x));
		System.out.println("relativeError5inf = " + x5.getRelativeErrorOfInfinityNorm(x));
		System.out.println("absoluteError5one = " + x5.getAbsoluteErrorOfOneNorm(x));
		System.out.println("absoluteError5inf = " + x5.getAbsoluteErrorOfInfinityNorm(x));
		System.out.println();

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

		// Matrix c = new Matrix(new double[][] { { 2, 3 }, { 3, 2 } });
		// System.out.println(c.getDeterminant());

	}

}
