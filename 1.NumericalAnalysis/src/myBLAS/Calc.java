package myBLAS;

class UndifinedMatrixOperation extends Exception {
	public UndifinedMatrixOperation() {
	}

	public static void main(String[] args) {
		System.out.println("演算が定義できません");
	}
}

public class Calc {

	// ベクトルのコンソール出力
	public static void printVec(double x[]) {
		System.out.println();
		for (int i = 0; i < x.length; i++) {
			System.out.printf("%.10f ", x[i]);
		}
	}

	// 行列のコンソール出力
	public static void printMat(double A[][]) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				System.out.printf("%.10f ", A[i][j]);
			}
			System.out.println();
		}
	}

	// ベクトルに関する演算
	// ベクトルxをc倍する
	public static double[] scalarMultiple(double c, double x[]) {
		for (int i = 0; i < x.length; i++) {
			x[i] *= c;
		}
		return x;
	}

	// 2つのベクトルの加算
	public static double[] addVec(double x[], double y[]) {
		for (int i = 0; i < x.length; i++) {
			x[i] += y[i];
		}
		return x;
	}

	// 2つのベクトルの減算
	public static double[] subVec(double[] x, double[] y) {
		return addVec(x, scalarMultiple(-1, y));
	}

	// 2つのベクトルの内積
	public static double innProd(double[] x, double[] y) {
		double innerProduct = 0.0;
		for (int i = 0; i < x.length; i++) {
			innerProduct += x[i] * y[i];
		}
		return innerProduct;
	}

	// 行列,ベクトルに関する演算
	// 行列Aとベクトルxの積
	public static double[] matVec(double[][] a, double[] x) {
		double[] y = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				y[i] += a[i][j] * x[j];
			}
		}
		return y;
	}

	// 行列Aとベクトルx,bに対して,残差 Ax-b
	public static double[] residual(double[][] a, double[] x, double[] b) {
		return subVec(matVec(a, x), b);
	}

	// 行列同士の演算
	// 2つの行列の加算
	public static double[][] addMat(double[][] a, double[][] b) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j] += b[i][j];
			}
		}
		return a;
	}

	// 2つの行列の減算
	public static double[][] subMat(double[][] a, double[][] b) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j] -= b[i][j];
			}
		}
		return a;
	}

	// 2つの行列の積
	public static double[][] multipleMat(double[][] a, double[][] b) {
		double[][] c = new double[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				for (int k = 0; k < b[0].length; k++) {
					c[i][j] += a[i][k] + b[k][j];
				}
			}
		}
		return c;
	}

	// ベクトルノルム
	// 1ノルム
	public static double vecNorm1(double x[]) {
		double norm = 0.0;
		for (int i = 0; i < x.length; i++) {
			norm += Math.abs(x[i]);
		}
		return norm;
	}

	// 2ノルム
	public static double vecNorm2(double x[]) {
		double norm = 0.0;
		for (int i = 0; i < x.length; i++) {
			norm += x[i] * x[i];
		}
		return Math.sqrt(norm);
	}

	// 無限大ノルム
	public static double vecNormInf(double x[]) {
		double norm = 0.0;
		for (int i = 0; i < x.length; i++) {
			if (norm <= x[i]) {
				norm = x[i];
			}
		}
		return norm;
	}

}
