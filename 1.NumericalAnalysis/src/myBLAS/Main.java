package myBLAS;

public class Main {
	public static void main(String[] args) {
		int n = 5;
		double[][] a = new double[n][n];
		double[][] b = new double[n][n];
		double[] x = new double[n];
		double[] y = new double[n];

		// 適当な値の格納
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = i * i - 2 * j;
				b[i][j] = i * j;
			}
			x[i] = i;
			y[i] = 1.0 / (i + 1);
		}

		Calc.printVec(x);
		Calc.printMat(a);

		Calc.printVec(Calc.scalarMultiple(n, x));
		Calc.printVec(Calc.addVec(x, y));
		Calc.printVec(Calc.subVec(x, y));
		System.out.println(Calc.innProd(x, y));

		Calc.printVec(Calc.matVec(a, x));
		Calc.printVec(Calc.residual(a, x, y));

		Calc.printMat(Calc.addMat(a, b));
		Calc.printMat(Calc.subMat(a, b));
		Calc.printMat(Calc.multipleMat(a, b));

		System.out.println(Calc.vecNorm1(x));
		System.out.println(Calc.vecNorm2(x));
		System.out.println(Calc.vecNormInf(x));

		System.out.println(Calc.matNorm1(a));
		System.out.println(Calc.matNormInf(a));



	}
}
