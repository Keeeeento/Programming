package mathlib;

public class Test {
	public static void main(String[] args) {

		int n = 3;
		Matrix a = new Matrix(new double[][] { { 1, 1, 1 }, { 1, 1 / 2, 1 / 2 }, { 1, 1 / 2, 1 / 3 } });
		Vector b = new Vector(n);
		b.allNumber(1);

		Vector x = new Vector(n);
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
		Vector x4 = Jacobi.solveWithOneNorm(a, b);
		System.out.println("relativeError4one = " + x4.getRelativeErrorOfOneNorm(x));
		System.out.println("relativeError4inf = " + x4.getRelativeErrorOfInfinityNorm(x));
		System.out.println("absoluteError4one = " + x4.getAbsoluteErrorOfOneNorm(x));
		System.out.println("absoluteError4inf = " + x4.getAbsoluteErrorOfInfinityNorm(x));
		System.out.println();

		System.out.println("-Gauss Seidel-");
		Vector x5 = GaussSeidel.solveWithOneNorm(a, b);
		System.out.println("relativeError5one = " + x5.getRelativeErrorOfOneNorm(x));
		System.out.println("relativeError5inf = " + x5.getRelativeErrorOfInfinityNorm(x));
		System.out.println("absoluteError5one = " + x5.getAbsoluteErrorOfOneNorm(x));
		System.out.println("absoluteError5inf = " + x5.getAbsoluteErrorOfInfinityNorm(x));
		System.out.println();

	}

}
