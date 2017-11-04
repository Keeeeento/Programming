package mathlib;

public class GaussSeidel extends StationaryIterativeMethod {
	static int iteration; // 反復回数
	static double normNumber = 0;

	// 収束判定条件:1ノルム相対誤差による解
	public static Vector solve(Matrix a, Vector b) {
		int n = b.getData().length;
		Vector x = x0.copy();
		Vector xOld = new Vector(n);

		for (iteration = 0; iteration < maxIter; iteration++) {
			for (int i = 0; i < n; i++) {
				double sum = 0.0;
				for (int j = 0; j < n; j++) {
					if (j != i) {
						sum += a.getData()[i][j] * x.getData()[j];
					}
				}
				x.getData()[i] = (b.getData()[i] - sum) / a.getData()[i][i];
			}
			if (xOld.getRelativeError(normNumber, x) <= epsilon || iteration >= maxIter) {
				break;
			} else {
				xOld = x.copy();
			}
		}

		return x;

	}

	// 詳細を表示
	public static void solveAndShowDetail(Matrix a, Vector b) {
		System.out.println("- Gauss Seidel -");
		Vector x = GaussSeidel.solve(a, b);
		if (iteration < maxIter) {
			x.print("x");
			System.out.println("iteration = " + iteration);
		} else {
			System.out.println("収束しません");
		}
		System.out.println();

	}

	// 反復回数
	public static int getIter(Matrix a, Vector b) {
		GaussSeidel.solve(a, b);
		if (iteration == maxIter) {
			return 0;
		}
		return iteration;
	}

	// 収束するまで相対誤差を検出し続ける
	public static Vector solveAndShowError(double norm, Matrix a, Vector b, Vector exactSolution) {
		int n = b.getData().length;
		int iteration;
		Vector x = Vector.allNumber(n, 1); // 初期化
		Vector xOld = x.copy();

		System.out.println("-- Gauss Seidel--");
		System.out.println("iteration number,relative error of " + norm + " norm");
		for (iteration = 0; iteration < maxIter; iteration++) {
			for (int i = 0; i < n; i++) {
				double sum = 0.0;
				for (int j = 0; j < n; j++) {
					if (i != j) {
						sum += a.getData()[i][j] * x.getData()[j];
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
		if (iteration >= maxIter) {
			System.out.println("収束しません");
		}
		System.out.println();
		return x;
	}

	// 反復回数を返す
	public static int getIterationNumber(double norm, Matrix a, Vector b, Vector exactSolution) {
		int n = b.getData().length;
		int iteration;
		Vector x = Vector.allNumber(n, 1); // 初期化
		Vector xOld = x.copy();

		for (iteration = 0; iteration < maxIter; iteration++) {
			for (int i = 0; i < n; i++) {
				double sum = 0.0;
				for (int j = 0; j < n; j++) {
					if (i != j) {
						sum += a.getData()[i][j] * x.getData()[j];
					}
				}
				x.getData()[i] = (b.getData()[i] - sum) / a.getData()[i][i];
			}
			if (xOld.getRelativeError(norm, x) <= epsilon) {
				break;
			} else {
				xOld = x.copy();
			}
		}
		if (iteration >= maxIter) {
			System.out.println("収束しません");
			iteration = 0;
		}
		return iteration;
	}

}