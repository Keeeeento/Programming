package mathlib;

public class OldCholeskyDecomposition {

	// 下三角行列を取得
	public static Matrix getL(Matrix a) {

		int n = a.getN();
		Matrix l = new Matrix(n);

		for (int j = 0; j < n; j++) {
			for (int i = j; i < n; i++) {
				for (int k = 0; k <= j - 1; k++) {
					l.getData()[i][j] -= l.getData()[i][k] * l.getData()[j][k];
				}
				l.getData()[i][j] += a.getData()[i][j];
				if (j == i) {
					l.getData()[i][j] = Math.sqrt(l.getData()[i][j]);
				} else {
					l.getData()[i][j] /= l.getData()[j][j];
				}
			}
		}

		return l;

	}

	public static Matrix getLBySum(Matrix a) {

		int n = a.getN();
		Matrix l = new Matrix(n);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				double sum = 0.0;
				for (int k = 0; k < j; k++) {
					sum += l.getData()[i][k] * l.getData()[j][k];
				}
				if (j == i) {
					l.getData()[i][j] = Math.sqrt(a.getData()[i][j] - sum);
				} else {
					l.getData()[i][j] = 1.0 / l.getData()[j][j] * (a.getData()[i][j] - sum);
				}
			}
		}
		return l;
	}

	// 解を求める
	public static Vector solve(Matrix a, Vector b) {
		if (!a.isSymmetric()) {
			throw new RuntimeException("Matrix is not symmetric");
		}
		Matrix l = getLBySum(a);
		Vector y = LUDecomposition.forwardSubstitution(l, b);
		Vector x = LUDecomposition.backwardSubstitution(l.transpose(), y);
		return x;
	}
}
