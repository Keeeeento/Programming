package mathlib;

public class LUDecomposition {

	static int operation = 0;

	// LU分解
	// 下三角行列がL, 上三角行列がUである行列を返す
	public static Matrix luDecomposition(Matrix a) {
		int n = a.getN();
		Matrix lu = a.copy();
		for (int k = 0; k < n; k++) {
			for (int i = k + 1; i < n; i++) {
				double alpha = lu.getData()[i][k] / lu.getData()[k][k];
				operation++;
				for (int j = k + 1; j < n; j++) {
					lu.getData()[i][j] -= alpha * lu.getData()[k][j];
					operation++;
				}
				lu.getData()[i][k] = alpha;
				operation++;
			}
		}
		return lu;
	}

	// LU分解後のL
	public static Matrix l(Matrix a) {
		int n = a.getData().length;
		Matrix lu = luDecomposition(a);
		Matrix l = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i > j) {
					l.getData()[i][j] = lu.getData()[i][j];
				} else if (i == j) {
					l.getData()[i][j] = 1;
				}
			}
		}
		return l;
	}

	// LU分解後のU
	public static Matrix u(Matrix a) {
		int n = a.getData().length;
		Matrix lu = luDecomposition(a);
		Matrix u = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i <= j) {
					u.getData()[i][j] = lu.getData()[i][j];
				}
			}
		}
		return u;
	}

	// 前進代入
	// lは対角成分が1の下三角行列
	public static Vector forwardSubstitution(Matrix l, Vector b) {
		int n = l.getData().length;
		Vector x = new Vector(b.getN());
		x = x.copy(b);
		for (int k = 0; k < n; k++) {
			for (int j = 0; j < k; j++) {
				x.getData()[k] -= l.getData()[k][j] * x.getData()[j];
				operation++;
			}
		}
		return x;
	}

	// 後退代入
	public static Vector backwardSubstitution(Matrix a, Vector b) {
		int n = a.getData().length;
		Vector x = b.copy(b);
		for (int k = n - 1; k >= 0; k--) {
			for (int j = k + 1; j < n; j++) {
				x.getData()[k] -= a.getData()[k][j] * x.getData()[j];
			}
			x.getData()[k] /= a.getData()[k][k];
		}
		return x;
	}

	// LU分解でxを求める
	public static Vector solve(Matrix a, Vector b) {
		int n = a.getData().length;
		Vector x = new Vector(n);
		Vector y = new Vector(n);
		Matrix l = l(a);
		Matrix u = u(a);
		y = forwardSubstitution(l, b);
		x = backwardSubstitution(u, y);
		System.out.println("count = " + operation);
		return x;
	}

}
