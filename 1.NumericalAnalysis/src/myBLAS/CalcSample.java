package myBLAS;

public class CalcSample {

	public static void printVec(double x[]){
		for (int i = 0; i < x.length; i++){
			System.out.printf("%.5e   ", x[i]);
		}
		System.out.println();
	}

	public static void printMat(double A[][]){
		for (int i = 0; i < A.length; i++){
			for(int j = 0; j< A[i].length;j++){
				// i 行目の成分を出力する
				// printf("format   ", 成分)で出力すると行列の成分がきれいに並びます.
				// 各成分の間にスペース("  ")を置きます.
			}
			// i 行目の成分を出力した. println() で新たな行に移す.
		}
	}


	public static double[] scalarMultiple(double c, double x[]){
		double[] y = new double[x.length];

		for (int i = 0; i<x.length; i++){
			y[i] = c*x[i];
		}

		return y;
	}

	public static double[] addVec(double[] x, double y[]){
		double[] z = new double[x.length];

		// z = x+y,  z[i] = x[i] + y[i];

		return z;
	}

	public static double[] subVec(double[] x, double y[]){
		double[] z = new double[x.length];

		// z = x-y,  z[i] = x[i] - y[i];

		return z;
	}

	public static double innProd(double[] x, double y[]){
		double z = 0;
		// z = x^T * y, z = x[1]*y[1] + ... + x[n]*y[n];

		return z;
	}

	public static double[] matVec(double[][] A, double[] x){
		double[] y = new double[A.length];

		// y[i] = A[i][1] * x[1] + ... + A[i][n] * x[n]

		return y;

	}

	public static double[] residual(double A[][], double x[], double b[]){
		double[] r = new double[b.length];

		// matVec() を使って, Ax を計算する.
		// さらに, subVec() を用いて, Ax - b　を計算する.
		r = subVec(matVec(A,x),b);

		return r;
	}

	public static double[][] addMat(double A[][], double B[][]){
		double[][] C = new double[A.length][A[0].length];

		// C[i][j] = A[i][j] + B[i][j];

		return C;
	}

	public static double[][] multipleMat(double A[][], double B[][]){

		double[][] C = new double[A.length][A[0].length];

		// C[i][j] = A[i][1]*B[1][j] + A[i][2]*B[2][j] + ... + A[i][n]*B[n][j];

		return C;
	}

	public static double  vecNorm1(double[] x){
		double norm = 0;

		// norm = |x[1]| + ... + |x[n]|

		return norm;
	}

	public static double  vecNorm2(double[] x){
		double norm = 0;

		// norm = sqrt(|x[1]|^2 + ... + |x[n]|^2)

		return norm;
	}

	public static double vecNormInf(double x[]){
		double norm = 0;

		// norm = max_{i=0,1,..,n-1} |x[i]|

		for (int i = 0; i< x.length; i++){
			// もし, |x[i]| > norm;
			// norm = |x[i]|
		}

		return norm;
	}


	public static double matNorm1(double[][] A){
		double norm = 0;

		// norm = 最大列和, 教科書の Page 44

		return norm;
	}


	public static double matNormInf(double[][] A){
		double norm = 0;

		// norm = 最大行和, 教科書の Page 44

		return norm;
	}


}


