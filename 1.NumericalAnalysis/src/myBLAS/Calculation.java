package myBLAS;

public class Calculation {

	// ベクトルのコンソール出力
	// 指定が特にない場合は小数点以下10桁表示
	public static void print(double[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.printf("%.10f ", x[i]);
		}
		System.out.println();
	}

	// 桁数指定付き(小数点以下1~16桁まで)
	public static void printf(double[] x, int n) {
		switch (n) {
		case 0:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%d ", (int) x[i]);
			}
			System.out.println();
			break;
		case 1:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%.1f ", x[i]);
			}
			System.out.println();
			break;

		case 2:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%.2f ", x[i]);
			}
			System.out.println();
			break;
		case 3:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%.3f ", x[i]);
			}
			System.out.println();
			break;
		case 4:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%.4f ", x[i]);
			}
			System.out.println();
			break;
		case 5:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%.5f ", x[i]);
			}
			System.out.println();
			break;
		case 6:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%.6f ", x[i]);
			}
			System.out.println();
			break;
		case 7:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%.7f ", x[i]);
			}
			System.out.println();
			break;
		case 8:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%.8f ", x[i]);
			}
			System.out.println();
			break;
		case 9:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%.9f ", x[i]);
			}
			System.out.println();
			break;
		case 10:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%.10f ", x[i]);
			}
			System.out.println();
			break;
		case 11:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%.11f ", x[i]);
			}
			System.out.println();
			break;
		case 12:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%.12f ", x[i]);
			}
			System.out.println();
			break;
		case 13:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%.13f ", x[i]);
			}
			System.out.println();
			break;
		case 14:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%.14f ", x[i]);
			}
			System.out.println();
			break;
		case 15:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%.15f ", x[i]);
			}
			System.out.println();
			break;
		case 16:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%.16f ", x[i]);
			}
			System.out.println();
			break;
		default:
			for (int i = 0; i < x.length; i++) {
				System.out.print(x[i] + " ");
			}
			System.out.println();
			break;

		}

	}

	// 指数表記
	public static void printe(double[] x, int n) {
		switch (n) {
		case 2:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%.2e ", x[i]);
			}
			System.out.println();
			break;
		case 3:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%.3e ", x[i]);
			}
			System.out.println();
			break;
		default:
			for (int i = 0; i < x.length; i++) {
				System.out.printf("%.16e ", x[i]);
			}
			System.out.println();
			break;
		}

	}

	// 行列のコンソール出力
	// 指定が特にない場合は小数点以下10桁表示
	public static void print(double a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.printf("%.10f ", a[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	// 桁数指定付き(小数点以下1~16桁まで)
	public static void printf(double a[][], int n) {
		switch (n) {
		case 0:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%d ", (int) a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 1:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%.1f ", a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 2:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%.2f ", a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 3:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%.3f ", a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 4:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%.4f ", a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 5:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%.5f ", a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 6:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%.6f ", a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 7:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%.7f ", a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 8:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%.8f ", a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 9:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%.9f ", a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 10:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%.10f ", a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 11:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%.11f ", a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 12:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%.12f ", a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 13:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%.13f ", a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 14:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%.14f ", a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 15:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%.15f ", a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 16:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%.16f ", a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			break;

		}
	}

	// 指数表記
	public static void printe(double[][] a, int n) {
		switch (n) {
		case 3:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%.3e ", a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			break;

		default:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[0].length; j++) {
					System.out.printf("%.16e ", a[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			break;
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

	// ベクトルのコピー
	public static double[] copy(double[] b) {
		int n = b.length;
		double[] x = new double[n];
		for (int i = 0; i < n; i++) {
			x[i] = b[i];
		}
		return x;
	}

	// ベクトルの要素をすべてnに
	public static double[] allNumber(int n, double num) {
		double[] x = new double[n];
		for (int i = 0; i < n; i++) {
			x[i] = num;
		}
		return x;
	}

	// 2つのベクトルの加算
	public static double[] add(double x[], double y[]) {
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
	public static double[] sub(double[] x, double[] y) {
		return add(x, scalarMultiple(-1, y));
	}

	// 2つのベクトルの内積
	public static double innerProduct(double[] x, double[] y) {
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
	public static double[] multiple(double[][] a, double[] x) {
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
		return sub(multiple(a, x), b);
	}

	// 行列の演算
	// 行列のc倍
	public static double[][] scalarMultiple(double c, double a[][]) {
		int n = a.length;
		double[][] b = copy(a);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				b[i][j] *= c;
			}
		}
		return b;
	}

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

	// 行列のコピー
	public static double[][] copy(double[][] a) {
		int n = a.length;
		int m = a[0].length;
		double[][] copy = new double[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = a[i][j];
			}
		}
		return copy;
	}

	// 単位行列の作成
	public static void identity(double[][] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					a[i][j] = 1.0;
				} else {
					a[i][j] = 0.0;
				}
			}
		}

	}

	// 行列の条件数
	public static double oneConditionNumber(double[][] a) {
		return manhattanNorm(a) * manhattanNorm(Inverse(a));
	}

	public static double infinityConditionNumber(double[][] a) {
		return infinityNorm(a) * infinityNorm(Inverse(a));
	}

	// LU分解でのL
	public static double[][] l(double[][] a) {
		int n = a.length;
		double[][] l = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i > j) {
					l[i][j] = a[i][j];
				} else if (i == j) {
					l[i][j] = 1;
				}
			}
		}
		return l;
	}

	// LU分解でのU
	public static double[][] u(double[][] a) {
		int n = a.length;
		double[][] u = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i <= j) {
					u[i][j] = a[i][j];
				}
			}
		}
		return u;
	}

	// 2つの行列の加算
	public static double[][] add(double[][] a, double[][] b) {
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
	public static double[][] sub(double[][] a, double[][] b) {
		return add(a, scalarMultiple(-1, b));
	}

	// 2つの行列の積
	public static double[][] multiple(double[][] a, double[][] b) {
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
	public static double manhattanNorm(double x[]) {
		double norm = 0.0;
		for (int i = 0; i < x.length; i++) {
			norm += Math.abs(x[i]);
		}
		return norm;
	}

	// 2ノルム
	public static double euclideanNorm(double x[]) {
		double norm = 0.0;
		for (int i = 0; i < x.length; i++) {
			norm += x[i] * x[i];
		}
		return Math.sqrt(norm);
	}

	// 無限大ノルム
	public static double infinityNorm(double x[]) {
		double norm = 0.0;
		for (int i = 0; i < x.length; i++) {
			if (norm <= Math.abs(x[i])) {
				norm = Math.abs(x[i]);
			}
		}
		return norm;
	}

	// 行列ノルム
	// 1ノルム
	public static double manhattanNorm(double[][] a) {
		return infinityNorm(transpose(a));
	}

	// 無限大ノルム
	public static double infinityNorm(double[][] a) {
		double norm = 0.0;
		double sum = 0.0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				sum += Math.abs(a[i][j]);
			}
			if (sum > norm) {
				norm = sum;
			}
			sum = 0;
		}
		return norm;
	}

	// ガウス消去法
	// 前進消去
	public static void forwardElimination(double[][] a, double[] b) {
		int n = a.length;
		double alpha = 0.0;
		for (int k = 0; k < n - 1; k++) {
			for (int i = k + 1; i < n; i++) {
				alpha = a[i][k] / a[k][k];
				for (int j = k; j < n; j++) {
					a[i][j] -= alpha * a[k][j];
					if (i > j) {
						a[i][j] = 0.0;
					}
				}
				b[i] -= alpha * b[k];
			}
		}
	}

	// 前進消去(0とみなす)
	public static void forwardEliminationNonZero(double[][] a, double[] b) {
		int n = a.length;
		double alpha = 0.0;
		for (int k = 0; k < n - 1; k++) {
			for (int i = k + 1; i < n; i++) {
				alpha = a[i][k] / a[k][k];
				for (int j = k + 1; j < n; j++) {
					a[i][j] -= alpha * a[k][j];
				}
				b[i] -= alpha * b[k];
			}
		}
	}

	// ピボット選択付きガウス消去法
	public static double[] pivotGaussianElimination(double[][] a, double[] b) {
		int n = a.length;
		int ell = 0; // 絶対値最大成分の行番号
		double alpha = 0.0;
		double pivot = 0.0;

		// 前進消去過程
		for (int k = 0; k < n - 1; k++) {
			ell = k;
			pivot = Math.abs(a[k][k]);

			// pivot選択
			for (int i = k + 1; i < n; i++) {
				if (pivot < Math.abs(a[i][k])) {
					pivot = Math.abs(a[i][k]);
					ell = i;
				}
			}

			// 行の入れ替え
			for (int j = k; j < n; j++) {
				pivot = a[k][j];
				a[k][j] = a[ell][j];
				a[ell][j] = pivot;
			}
			pivot = b[k];
			b[k] = b[ell];
			b[ell] = pivot;

			// 第k列目の消去
			for (int i = k + 1; i < n; i++) {
				alpha = a[i][k] / a[k][k];
				for (int j = k + 1; j < n; j++) {
					a[i][j] -= alpha * a[k][j];
				}
				b[i] -= alpha * b[k];
			}

		}
		// 後退代入過程
		backwardSubstitution(a, b);
		return b;
	}

	// 前進代入
	// lは対角成分が1の下三角行列
	public static double[] forwardSubstitution(double[][] l, double[] b) {
		int n = b.length;
		double[] x = copy(b);
		for (int k = 0; k < n; k++) {
			for (int j = 0; j < k; j++) {
				x[k] -= l[k][j] * x[j];
			}
		}
		return x;
	}

	// 後退代入
	public static double[] backwardSubstitution(double[][] a, double[] b) {
		int n = a.length;
		double[] x = copy(b);
		for (int k = n - 1; k >= 0; k--) {
			for (int j = k + 1; j < n; j++) {
				x[k] -= a[k][j] * x[j];
			}
			x[k] /= a[k][k];
		}
		return x;
	}

	// ガウス消去法
	public static double[] gaussianElimination(double[][] a, double[] b) {
		forwardElimination(a, b);
		return backwardSubstitution(a, b);
	}

	// LU分解
	// 下三角行列がL, 上三角行列がUである行列を返す
	public static double[][] luDecomposition(double[][] a) {
		int n = a.length;
		double[][] lu = copy(a);
		for (int k = 0; k < n; k++) {
			for (int i = k + 1; i < n; i++) {
				double alpha = lu[i][k] / lu[k][k];
				for (int j = k + 1; j < n; j++) {
					lu[i][j] -= alpha * lu[k][j];
				}
				lu[i][k] = alpha;
			}
		}
		return lu;
	}

	// LU分解でxを求める
	public static double[] solveByLUDecomposition(double[][] a, double[] b) {
		int n = a.length;
		double[] x = new double[n];
		double[] y = new double[n];
		double[][] lu = new double[n][n];
		lu = luDecomposition(a);
		double[][] l = l(lu);
		double[][] u = u(lu);

		y = forwardSubstitution(l, b);
		x = backwardSubstitution(u, y);

		return x;
	}

	// 逆行列
	public static double[][] Inverse(double[][] a) {
		int n = a.length;
		double[][] inv = new double[n][n];
		double[][] lu = luDecomposition(a);
		double[][] l = l(lu);
		double[][] u = u(lu);
		double[][] e = new double[n][n];
		identity(e);
		double[] x = new double[n];
		double[] y = new double[n];
		for (int i = 0; i < n; i++) {
			y = forwardSubstitution(l, e[i]);
			x = backwardSubstitution(u, y);
			inv[i] = x;
		}

		return transpose(inv);
	}

}
