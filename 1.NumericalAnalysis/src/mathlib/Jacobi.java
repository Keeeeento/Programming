package mathlib;

public class Jacobi extends StationaryIterativeMethod {

	/**solve
	 * 一般的なprivateな解法
	 * @param a
	 * @param x
	 * @param b
	 * @param iteration
	 * @return なし
	 */
	private static void solve(Matrix a, Vector x, Vector b) {
		int n = a.getN();
		Vector xOld = new Vector(n);
		for (iteration = 0; iteration < maxIterationNumber; iteration++) {
			for (int i = 0; i < n; i++) {
				x.getData()[i] = b.getData()[i];
				for (int j = 0; j < n; j++) {
					if (i != j) {
						x.getData()[i] -= a.getData()[i][j] * xOld.getData()[j];
					}
				}
				x.getData()[i] /= a.getData()[i][i];
			}
			if (xOld.getRelativeError(normNumber, x) <= epsilon) { // 収束判定条件
				break;
			} else {
				xOld = x.copy();
			}
		}
	}

	private static void solveDoWhile(Matrix a, Vector x, Vector b, int iteration) {
		int n = a.getN();
		Vector xOld = new Vector(n);
		do {
			for (int i = 0; i < n; i++) {
				x.getData()[i] = b.getData()[i];
				for (int j = 0; j < n; j++) {
					if (i != j) {
						x.getData()[i] -= a.getData()[i][j] * xOld.getData()[j];
					}
				}
				x.getData()[i] /= a.getData()[i][i];
			}
			iteration++;
			xOld = x.copy();
		} while (xOld.getRelativeError(normNumber, x) > epsilon && iteration < maxIterationNumber);
	}

	/**solve
	 * xを求める
	 * @param a
	 * @param b
	 * @return x 近似解
	 */
	public static Vector solve(Matrix a, Vector b) {
		int n = a.getN();
		Matrix a2 = a.copy();
		Vector b2 = b.copy();
		Vector x = new Vector(n);
		solve(a2, x, b2);
		return x;

	}

	/**getIter
	 * 反復回数を求める
	 * @param a
	 * @param b
	 * @return iteration 反復回数
	 */
	public static int getIter(Matrix a, Vector b) {
		int n = a.getN();
		Matrix a2 = a.copy();
		Vector b2 = b.copy();
		Vector x = new Vector(n);
		solve(a2, x, b2);
		return iteration;
	}

	public static Matrix getMatrix(Matrix a, Vector b) {
		int n = a.getN();
		int iteration = 0;
		Matrix a2 = a.copy();
		Vector b2 = b.copy();
		Vector x = new Vector(n);
		solve(a2, x, b2);
		return a2;
	}

	// 詳細を表示
	public static void solveAndShowDetail(Matrix a, Vector b) {
		System.out.println("- Jacobi -");
		Vector x = Jacobi.solve(a, b);
		if (iteration < maxIterationNumber) {
			x.print("x");
			System.out.println("iteration = " + iteration);
		} else {
			System.out.println("収束しません");
		}
		System.out.println();

	}

	// 収束するまで相対誤差を検出し続ける
	public static Vector solveAndShowError(double norm, Matrix a, Vector b, Vector exactSolution) {
		int n = b.getData().length;
		int iteration;
		Vector x = Vector.allNumber(n, 1); // 初期化
		Vector xOld = x.copy();

		System.out.println("-- Jacobi --");
		System.out.println("iteration number,relative error of " + norm + " norm");
		for (iteration = 0; iteration < maxIterationNumber; iteration++) {
			for (int i = 0; i < n; i++) {
				double sum = 0.0;
				for (int j = 0; j < n; j++) {
					if (i != j) {
						sum += a.getData()[i][j] * xOld.getData()[j];
					}
				}
				x.getData()[i] = (b.getData()[i] - sum) / a.getData()[i][i];
			}
			if (xOld.getRelativeError(norm, x) <= epsilon) {
				break;
			} else {
				System.out.printf("%d, %.3e\n", iteration, x.getRelativeError(norm, exactSolution));
				xOld = x.copy();
			}
		}
		if (iteration >= maxIterationNumber) {
			System.out.println("収束しません");
		}
		System.out.println();
		return x;
	}

	// 反復行列
	public static Matrix IterativeMatrixOf(Matrix a) {
		int n = a.getData().length;
		Matrix t = new Matrix(n);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j != i) {
					t.getData()[i][j] = a.getData()[i][j] / a.getData()[i][i];
				}
			}
		}

		return t.multiply(-1);
	}

	public static Vector IterativeVectorOf(Matrix a, Vector b) {
		int n = a.getData().length;
		Vector c = new Vector(n);

		for (int i = 0; i < n; i++) {
			c.getData()[i] = b.getData()[i] / a.getData()[i][i];
		}

		return c;
	}

	public static void main(String[] args) {
		Matrix a = new Matrix(new double[][] { { 3, 1, 1 }, { 1, 3, 1 }, { 1, 1, 3 } });
		Vector b = new Vector(new double[] { 0, 4, 6 });
		solve(a, b).print("X");
		System.out.println(getIter(a, b));
		getMatrix(a, b).print();

	}

}