package mathlib;

public class LUDecomposition extends LinearCondition {

	// LU分解
	// 単位下三角行列がL, 上三角行列がUである行列を返す
	public static Matrix luDecomposition(Matrix a) {
		Matrix lu = a.copy();
		for (int k = 0; k < n; k++) {
			for (int i = k + 1; i < n; i++) {
				double alpha = lu.getData()[i][k] / lu.getData()[k][k];
				for (int j = k + 1; j < n; j++) {
					lu.getData()[i][j] -= alpha * lu.getData()[k][j];
				}
				lu.getData()[i][k] = alpha;
			}
		}
		return lu;
	}

	/**
	 * @param a
	 * @return L LU分解後の行列L
	 */
	public static Matrix getL(Matrix a) {
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

	/**
	 * @param a
	 * @return U LU分解後のU
	 */
	public static Matrix getU(Matrix a) {
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

	/**
	 * 前進代入
	 * @param l
	 * @param b
	 * @return y 前進代入後のベクトル
	 */
	public static Vector forwardSubstitution(Matrix l, Vector b) {
		Vector x = new Vector(n);
		x = x.copy(b);
		for (int k = 0; k < n; k++) {
			for (int j = 0; j < k; j++) {
				x.getData()[k] -= l.getData()[k][j] * x.getData()[j];
			}
			x.getData()[k] /= l.getData()[k][k];
		}
		return x;
	}

	/**
	 * 後退代入
	 * @param u
	 * @param y
	 * @return x
	 */
	public static Vector backwardSubstitution(Matrix u, Vector y) {
		Vector x = y.copy(y);
		for (int k = n - 1; k >= 0; k--) {
			for (int j = k + 1; j < n; j++) {
				x.getData()[k] -= u.getData()[k][j] * x.getData()[j];
			}
			x.getData()[k] /= u.getData()[k][k];
		}
		return x;
	}

	// LU分解でxを求める
	public static Vector solve(Matrix a, Vector b) {
		Vector x = new Vector(n);
		Vector y = new Vector(n);
		Matrix l = getL(a);
		Matrix u = getU(a);
		y = forwardSubstitution(l, b);
		x = backwardSubstitution(u, y);
		return x;
	}

}
