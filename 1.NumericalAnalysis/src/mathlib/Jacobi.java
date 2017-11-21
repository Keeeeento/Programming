package mathlib;

public class Jacobi extends LinearCondition {

	/**solve
	 * @param a 係数行列
	 * @param b 定数項ベクトル
	 * @return x 未知数ベクトル 近似解
	 */
	public static Vector solve() {
		Vector x = x0.copy();
		Vector xOld = new Vector(n);

		for (iteration = 0; iteration < maxIteration; iteration++) {
			for (int i = 0; i < n; i++) {
				x.getData()[i] = b.getData()[i];
				for (int j = 0; j < n; j++) {
					if (i != j) {
						x.getData()[i] -= a.getData()[i][j] * xOld.getData()[j];
					}
				}
				x.getData()[i] /= a.getData()[i][i];
			}
			if (xOld.getRelativeError(normNumber, x) <= epsilon || iteration >= maxIteration) { // 収束判定条件
				break;
			} else {
				xOld = x.copy();
			}
		}

		return x;
	}

	// 詳細を表示
	//	public static void solveAndShowDetail(Matrix a, Vector b) {
	//		System.out.println("- Jacobi -");
	//		Vector x = Jacobi.solve(a, b);
	//		if (iteration < maxIter) {
	//			x.print("x");
	//			System.out.println("iteration = " + iteration);
	//		} else {
	//			System.out.println("収束しません");
	//		}
	//		System.out.println();
	//	}

	/**
	 * getIter
	 * 反復回数
	 * 最大反復回数を超えた場合は0
	 * @param a
	 * @param b
	 * @return iteration
	 */
	public static int getIteration() {
		Jacobi.solve();
		if (iteration == maxIteration) {
			return 0;
		}
		return iteration;
	}

	//	// 収束するまで相対誤差を検出し続ける
	//	public static Vector solveAndShowError(double norm, Matrix a, Vector b, Vector exactSolution) {
	//		int n = b.getData().length;
	//		int iteration;
	//		Vector x = Vector.allNumber(n, 1); // 初期化
	//		Vector xOld = x.copy();
	//
	//		System.out.println("-- Jacobi --");
	//		System.out.println("iteration number,relative error of " + norm + " norm");
	//		for (iteration = 0; iteration < maxIter; iteration++) {
	//			for (int i = 0; i < n; i++) {
	//				double sum = 0.0;
	//				for (int j = 0; j < n; j++) {
	//					if (i != j) {
	//						sum += a.getData()[i][j] * xOld.getData()[j];
	//					}
	//				}
	//				x.getData()[i] = (b.getData()[i] - sum) / a.getData()[i][i];
	//			}
	//			if (xOld.getRelativeError(norm, x) <= epsilon) {
	//				break;
	//			} else {
	//				System.out.printf("%d, %.3e\n", iteration, x.getRelativeError(norm, exactSolution));
	//				xOld = x.copy();
	//			}
	//		}
	//		if (iteration >= maxIter) {
	//			System.out.println("収束しません");
	//		}
	//		System.out.println();
	//		return x;
	//	}

	// 反復行列
	public static Matrix getIterativeMatrix() {
		Matrix t = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j != i) {
					t.getData()[i][j] = a.getData()[i][j] / a.getData()[i][i];
				}
			}
		}
		return t.scalarMultiply(-1);
	}

	public static Vector getIterativeVector() {
		Vector c = new Vector(n);
		for (int i = 0; i < n; i++) {
			c.getData()[i] = b.getData()[i] / a.getData()[i][i];
		}
		return c;
	}

	/**
	 * ヤコビ行列
	 * @param a
	 * @return ヤコビ行列
	 */
	public static Matrix getJacobiMatrix() {
		Matrix l = a.getDiagonal().inverse().multiply(a.getLower());
		Matrix u = a.getDiagonal().inverse().multiply(a.getUpper());
		return l.add(u);
	}

}