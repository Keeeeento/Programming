package myBLAS;

public class Example01 {

	public static void main(String[] args) {
		int N = 3;
		double[][] A = new double[N][N];
		double[][] B = new double[N][N];
		double[] a = new double[N];
		double[] b = new double[N];
		int i = 0, j = 0;

		for (i = 0; i < N; i++) {
			a[i] = i;
			b[i] = 1.0 / (i + 1);
			for (j = 0; j < N; j++) {
				A[i][j] = i + j;
				B[i][j] = i - j;
			}
		}

		System.out.println("a = ");
		Calc.printVec(a);
		System.out.println("b = ");
		Calc.printVec(b);
		System.out.println("A = ");
		Calc.printMat(A);
		System.out.println("B = ");
		Calc.printMat(B);

		System.out.println("20*a = ");
		Calc.printVec(Calc.scalarMultiple(20, a));

		System.out.println("a+b = ");
		Calc.printVec(Calc.addVec(a, b));

		System.out.println("a-b = ");
		Calc.printVec(Calc.subVec(a, b));

		System.out.println("a'*b = ");
		System.out.println(Calc.innProd(a, b));

		System.out.println("A*a = ");
		Calc.printVec(Calc.matVec(A, a));

		System.out.println("A*a - b = ");
		Calc.printVec(Calc.residual(A, a, b));

		System.out.println("A+B = ");
		Calc.printMat(Calc.addMat(A, B));

		System.out.println("A*B = ");
		Calc.printMat(Calc.multipleMat(A, B));

		System.out.println("||a||_1 = ");
		System.out.println(Calc.vecNorm1(a));

		System.out.println("||a||_2 = ");
		System.out.println(Calc.vecNorm2(a));

		System.out.println("||a||_Inf = ");
		System.out.println(Calc.vecNormInf(a));

		B[1][1] = -100;
		B[0][1] = 10;

		Calc.printMat(B);

		System.out.println("||B||_1 = ");
		System.out.println(Calc.matNorm1(B));

		System.out.println("||B||_Inf = ");
		System.out.println(Calc.matNormInf(B));

	}

}