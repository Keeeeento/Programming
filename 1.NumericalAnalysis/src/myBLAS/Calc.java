package myBLAS;

public class Calc {

	// ベクトルのコンソール出力
	public static void printVec(double x[]) {
		for (int i = 0; i < x.length; i++) {
			System.out.printf("%.10f ", x[i]);
		}
		System.out.println();
	}

	// 行列のコンソール出力
	public static void printMat(double a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.printf("%.10f ", a[i][j]);
			}
			System.out.println();
		}
	}

	// ベクトルに関する演算
	// ベクトルxをc倍する
	public static double[] scalarMultiple(double c, double x[]) {
		int n = x.length;
		double[] z = new double[n];
		for (int i = 0; i < n; i++) {
			z[i] = c * x[i];
		}
		return z;
	}

	// 2つのベクトルの加算
	public static double[] addVec(double x[], double y[]) {
		int n = x.length;
		int m = y.length;
		double[] z = new double[n];
		try {
			for (int i = 0; i < Math.max(n, m); i++) {
				z[i] = x[i] + y[i];
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("ベクトルのサイズが違います");
		}
		return z;
	}

	// 2つのベクトルの減算
	public static double[] subVec(double[] x, double[] y) {
		return addVec(x, scalarMultiple(-1, y));
	}

	// 2つのベクトルの内積
	public static double innProd(double[] x, double[] y) {
		int n = x.length;
		int m = y.length;
		double innerProduct = 0.0;
		try {
			for (int i = 0; i < Math.max(n, m); i++) {
				innerProduct += x[i] * y[i];
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("ベクトルのサイズが違います");
		}
		return innerProduct;
	}

	// 行列,ベクトルに関する演算
	// 行列Aとベクトルxの積
	public static double[] matVec(double[][] a, double[] x) {
		int n = a.length;
		int m = a[0].length;
		int k = x.length;
		double[] y = new double[n];
		try {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < Math.max(m, k); j++) {
					y[i] += a[i][j] * x[j];
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("行列の列数とベクトルのサイズが違います");
		}
		return y;
	}

	// 行列Aとベクトルx,bに対して,残差 Ax-b
	public static double[] residual(double[][] a, double[] x, double[] b) {
		return subVec(matVec(a, x), b);
	}

	// 行列同士の演算
	// 自作
	// 行列のc倍
	public static double[][] scalarMultiple(double c, double a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j] *= c;
			}
		}
		return a;
	}

	// 自作
	// 行列の転置
	public static double[][] transpose(double[][] a) {
		double[][] b = new double[a[0].length][a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				b[i][j] = a[j][i];
			}
		}
		return b;
	}

	// 2つの行列の加算
	public static double[][] addMat(double[][] a, double[][] b) {
		int n1 = a.length;
		int m1 = a[0].length;
		int n2 = b.length;
		int m2 = b[0].length;
		double[][] c = new double[n1][m2];
		try {
			for (int i = 0; i < Math.max(n1, n2); i++) {
				for (int j = 0; j < Math.max(m1, m2); j++) {
					c[i][j] = a[i][j] + b[i][j];
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("行列のサイズが違います");
		}
		return c;
	}

	// 2つの行列の減算
	public static double[][] subMat(double[][] a, double[][] b) {
		return addMat(a, scalarMultiple(-1, b));
	}

	// 2つの行列の積
	public static double[][] multipleMat(double[][] a, double[][] b) {
		int n1 = a.length;
		int m1 = a[0].length;
		int n2 = b.length;
		int m2 = b[0].length;
		double[][] c = new double[n1][m2];
		try {
			for (int i = 0; i < n1; i++) {
				for (int j = 0; j < Math.max(m1, n2); j++) {
					for (int k = 0; k < m2; k++) {
						c[i][j] += a[i][k] + b[k][j];
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("行列のサイズが積を定義できません");
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

	// 行列ノルム
	// 1ノルム
	public static double matNorm1(double[][] a) {
		return matNormInf(transpose(a));
	}

	// 無限大ノルム
	public static double matNormInf(double[][] a) {
		double norm = 0.0;
		for (int i = 0; i < a.length; i++) {
			double sum = 0.0;
			for (int j = 0; j < a[0].length; j++) {
				sum += Math.abs(a[i][j]);
			}
			norm = Math.max(norm, sum);
		}
		return norm;
	}
}
