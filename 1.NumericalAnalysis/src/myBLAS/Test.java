package myBLAS;

public class Test {
	public static void main(String[] args) {
		int n = 7;
		double[][] a = new double[n][n];
		double[][] b = new double[n][n];
		double[] x = new double[n];
		double[] y = new double[n];

		// 適当な値の格納
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = 1.0 / (2 + i + 5 * j);
				b[i][j] = i * j;
			}
			x[i] = 3 * i + 5;
			y[i] = 1.0 / (i + 1);
		}

		// Calc.printVec(x);
		// Calc.printMat(a);
		//
		// Calc.printVec(Calc.scalarMultiple(n, x));
		// Calc.printVec(Calc.addVec(x, y));
		// Calc.printVec(Calc.subVec(x, y));
		// System.out.println(Calc.innProd(x, y));
		//
		// Calc.printVec(Calc.matVec(a, x));
		// Calc.printVec(Calc.residual(a, x, y));
		//
		// Calc.printMat(Calc.addMat(a, b));
		// Calc.printMat(Calc.subMat(a, b));
		// Calc.printMat(Calc.multipleMat(a, b));
		//
		// System.out.println(Calc.vecNorm1(x));
		// System.out.println(Calc.vecNorm2(x));
		// System.out.println(Calc.vecNormInf(x));
		//
		// System.out.println(Calc.matNorm1(a));
		// System.out.println(Calc.matNormInf(a));

		// Calculation.forwardElimination(a, x);
		// Calculation.printe(a, 3);

		// Calculation.print(a);
		// Calculation.print(Calculation.luDecomposition(a));
		// Calculation.print(Calculation.Inverse(a));

		// double[][] mat = {{1,1,0,3},{2,1,-1,1},{3,-1,-1,2},{-1,2,3,-1}};
		// double [][] lu = Calculation.luDecomposition(mat);
		// Calculation.print(lu);
		// Calculation.print(Calculation.l(lu));
		// Calculation.print(Calculation.u(lu));
		// Calculation.print(Calculation.Inverse(mat));

		// double[][] copy = Calculation.copy(a);
		// Calculation.print(a);
		// Calculation.print(copy);

		// double[][] sample = { { 1, 3, 5 }, { 2, 4, 6 }, { 1, 5, 8 } };
		double[][] sample = { { 1.0, 2.0 }, { 3.0, 4.0 } };
		sample = Calculation.Inverse(sample);
		Calculation.print(sample);
		//
		// double[][] a1 = { { 1, 1, 9 }, { 0, -2, 3 }, { 2, 9, 1 } };
		// double[] b1 = { 1, 2, 3 };
		// double[] x1 = Calculation.gaussianElimination(a1, b1);
		// Calculation.print(x1);
	}
}
