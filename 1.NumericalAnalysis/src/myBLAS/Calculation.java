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

	// ベクトルに関する演算
	// ベクトルxをc倍する
	public static double[] scalarMultiple(double c, double x[]) {
		for (int i = 0; i < x.length; i++) {
			x[i] *= c;
		}
		return x;
	}

	// 2つのベクトルの加算
	public static double[] add(double x[], double y[]) {
		for (int i = 0; i < x.length; i++) {
			x[i] += y[i];
		}
		return x;
	}

	// 2つのベクトルの減算
	public static double[] sub(double[] x, double[] y) {
		return add(x, scalarMultiple(-1, y));
	}

	// 2つのベクトルの内積
	public static double innerProduct(double[] x, double[] y) {
		double innerProduct = 0.0;
		for (int i = 0; i < x.length; i++) {
			innerProduct += x[i] * y[i];
		}
		return innerProduct;
	}

	// 行列,ベクトルに関する演算
	// 行列Aとベクトルxの積
	public static double[] multiple(double[][] a, double[] x) {
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
		return sub(multiple(a, x), b);
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

	// 2つの行列の加算
	public static double[][] add(double[][] a, double[][] b) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j] += b[i][j];
			}
		}
		return a;
	}

	// 2つの行列の減算
	public static double[][] sub(double[][] a, double[][] b) {
		return add(a, scalarMultiple(-1, b));
	}

	// 2つの行列の積
	public static double[][] multiple(double[][] a, double[][] b) {
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

	// ガウス消去法
	// 前進消去
	public static void forwardEliminationWithoutSubstitutingZero(double[][] a, double[] b) {
		int n = a.length;
		double alpha = 0.0;
		for (int k = 0; k < n - 1; k++) {
			for (int i = k + 1; i < n; i++) {
				alpha = a[i][k] / a[k][k];
				for (int j = k + 1; j < n; j++) {
					a[i][j] += -alpha * a[k][j];
				}
				b[i] += -alpha * b[k];
			}
		}
	}

	public static void forwardElimination(double[][] a, double[] b) {
		int n = a.length;
		double alpha = 0.0;
		for (int k = 0; k < n - 1; k++) {
			for (int i = k + 1; i < n; i++) {
				alpha = a[i][k] / a[k][k];
				for (int j = k + 1; j < n; j++) {
					a[i][j] += -alpha * a[k][j];
				}
				b[i] += -alpha * b[k];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i > j) {
					a[i][j] = 0;
				}
			}
		}

	}

	// 後退代入
	public static double[] backsubstitution(double[][] a, double[] b) {
		int n = a.length;
		for (int k = n - 1; k >= 0; k--) {
			for (int j = k + 1; j < n; j++) {
				b[k] += -a[k][j] * b[j];
			}
			b[k] /= a[k][k];

		}
		return b;
	}

	// ガウス消去法
	public static double[] gaussianElimination(double[][] a, double[] b) {
		forwardElimination(a, b);
		return backsubstitution(a, b);
	}

}
