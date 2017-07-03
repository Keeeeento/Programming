package mathlib;

public class GaussianElimination {

	// 前進消去
	public void forwardElimination(Matrix a, Vector b) {
		int n = a.getData().length;
		double alpha = 0.0;
		for (int k = 0; k < n - 1; k++) {
			for (int i = k + 1; i < n; i++) {
				alpha = a.getData()[i][k] / a.getData()[k][k];
				for (int j = k; j < n; j++) {
					a.getData()[i][j] -= alpha * a.getData()[k][j];
				}
				b.getData()[i] -= alpha * b.getData()[k];
			}
		}
	}

	// 前進消去過程後のA
	public Matrix forwardEliminatedMatrix(Matrix a, Vector b) {
		int n = a.getData().length;
		double alpha = 0.0;
		Matrix a2 = a.copy();
		Vector b2 = b.copy();
		for (int k = 0; k < n - 1; k++) {
			for (int i = k + 1; i < n; i++) {
				alpha = a2.getData()[i][k] / a2.getData()[k][k];
				for (int j = k; j < n; j++) {
					a2.getData()[i][j] -= alpha * a2.getData()[k][j];
				}
				b2.getData()[i] -= alpha * b2.getData()[k];
			}
		}
		return a2;
	}

	// 前進消去過程後のb
	public Vector forwardEliminatedVector(Matrix a, Vector b) {
		int n = a.getData().length;
		double alpha = 0.0;
		Matrix a2 = a.copy();
		Vector b2 = b.copy();
		for (int k = 0; k < n - 1; k++) {
			for (int i = k + 1; i < n; i++) {
				alpha = a2.getData()[i][k] / a2.getData()[k][k];
				for (int j = k; j < n; j++) {
					a2.getData()[i][j] -= alpha * a2.getData()[k][j];
				}
				b2.getData()[i] -= alpha * b2.getData()[k];
			}
		}
		return b2;
	}

	// ピボット選択付き前進消去
	public void pivotingForwardElimination(Matrix a, Vector b) {
		int n = a.getData().length;
		int ell = 0; // 絶対値最大成分の行番号
		double alpha = 0.0;
		double pivot = 0.0;

		// 前進消去過程
		for (int k = 0; k < n - 1; k++) {
			ell = k;
			pivot = Math.abs(a.getData()[k][k]);

			// pivot選択
			for (int i = k + 1; i < n; i++) {
				if (pivot < Math.abs(a.getData()[i][k])) {
					pivot = Math.abs(a.getData()[i][k]);
					ell = i;
				}
			}

			// 行の入れ替え
			for (int j = k; j < n; j++) {
				pivot = a.getData()[k][j];
				a.getData()[k][j] = a.getData()[ell][j];
				a.getData()[ell][j] = pivot;
			}
			pivot = b.getData()[k];
			b.getData()[k] = b.getData()[ell];
			b.getData()[ell] = pivot;

			// 第k列目の消去
			for (int i = k + 1; i < n; i++) {
				alpha = a.getData()[i][k] / a.getData()[k][k];
				for (int j = k + 1; j < n; j++) {
					a.getData()[i][j] -= alpha * a.getData()[k][j];
				}
				b.getData()[i] -= alpha * b.getData()[k];
			}
		}

	}

	// 後退代入
	public Vector backwardSubstitution(Matrix a, Vector b) {
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

	// ガウス消去法
	public Vector solve(Matrix a, Vector b) {
		Matrix a2 = a.copy(a);
		Vector b2 = b.copy(b);
		forwardElimination(a2, b2);
		return backwardSubstitution(a2, b2);
	}

	// ピボット選択付きガウス消去法
	public Vector pivotSolve(Matrix a, Vector b) {
		Matrix a2 = a.copy(a);
		Vector b2 = b.copy(b);
		pivotingForwardElimination(a2, b2);
		return backwardSubstitution(a2, b2);
	}
}
