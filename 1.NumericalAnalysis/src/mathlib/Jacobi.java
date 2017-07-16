package mathlib;

public class Jacobi extends StationaryIterativeMethod {
	static int iteration; // 反復回数
	static int plusOperation; // 演算回数
	static int multiplyOperation;

	// 演算回数が合わない！！！！！

	// 収束判定条件:1ノルム相対誤差による解
	public static Vector solveWithOneNorm(Matrix a, Vector b) {
		int n = b.getData().length;
		Vector x = new Vector(n);
		Vector xOld = new Vector(n);

		for (iteration = 0; iteration < maxIterationNumber; iteration++) {
			for (int i = 0; i < n; i++) {
				x.getData()[i] = b.getData()[i];
				for (int j = 0; j < n; j++) {
					if (i != j) {
						x.getData()[i] -= a.getData()[i][j] * xOld.getData()[j];
						plusOperation += 2;
					}
				}
				x.getData()[i] /= a.getData()[i][i];
				plusOperation++;
			}
			if (xOld.getRelativeErrorOfOneNorm(x) <= epsilon) { // 収束判定条件:1ノルム相対誤差
				break;
			} else {
				xOld = x.copy();
			}
		}

		return x;
	}

	// 収束判定条件:無限大ノルム相対誤差による解
	public static Vector solveWithInfinityNorm(Matrix a, Vector b) {
		int n = b.getData().length;
		Vector x = new Vector(n);
		Vector xOld = new Vector(n);

		for (iteration = 0; iteration < maxIterationNumber; iteration++) {
			for (int i = 0; i < n; i++) {
				x.getData()[i] = b.getData()[i];
				plusOperation++;
				for (int j = 0; j < n; j++) {
					if (i != j) {
						x.getData()[i] -= a.getData()[i][j] * xOld.getData()[j];
						plusOperation++;
					}
				}
				x.getData()[i] /= a.getData()[i][i];
				plusOperation++;
			}
			if (xOld.getRelativeErrorOfInfinityNorm(x) <= epsilon) { // 収束判定条件:無限大ノルム相対誤差
				break;
			} else {
				xOld = x.copy();
				plusOperation++;
			}
		}

		return x;
	}

	// 詳細を表示
	public static void solveAndShowDetail(Matrix a, Vector b) {
		System.out.println("- Jacobi -");
		Vector x = Jacobi.solveWithOneNorm(a, b);
		if (iteration < maxIterationNumber) {
			x.print("x");
			System.out.println("iteration = " + iteration);
			System.out.println("operation = " + plusOperation);
		} else {
			System.out.println("収束しません");
		}
		System.out.println();

	}

	// 反復回数
	public static int getIteration(Matrix a, Vector b) {
		Jacobi.solveWithOneNorm(a, b);
		if (iteration == maxIterationNumber) {
			iteration = 0;
		}
		return iteration;
	}

	// 演算回数
	public static int getOperation(Matrix a, Vector b) {
		Jacobi.solveBySum(a, b);
		if (iteration == maxIterationNumber) {
			plusOperation = multiplyOperation = 0;
		}
		return plusOperation + multiplyOperation;
	}

	// 使わない
	public static Vector solveBySum(Matrix a, Vector b) {
		int n = b.getData().length;
		Vector x = Vector.allNumber(n, 1); // 初期化
		Vector xOld = x.copy();
		int iteration;
		for (iteration = 0; iteration < maxIterationNumber; iteration++) {
			for (int i = 0; i < n; i++) {
				double sum = 0.0;
				for (int j = 0; j < n; j++) {
					if (i != j) {
						sum += a.getData()[i][j] * xOld.getData()[j];
						multiplyOperation++;
						plusOperation++;
					}
				}
				x.getData()[i] = (b.getData()[i] - sum) / a.getData()[i][i];
				plusOperation++;
				multiplyOperation++;
			}
			if (xOld.getRelativeErrorOfOneNorm(x) <= epsilon) {
				break;
			} else {
				xOld = x.copy();
			}
		}
		if (iteration < maxIterationNumber) {
			System.out.println("iteration = " + iteration);
		} else {
			System.out.println("収束しません");
		}
		// System.out.println(count);
		return x;
	}

	// 収束するまで相対誤差を検出し続ける
	public static Vector solveAndShowError(Matrix a, Vector b, Vector exactSolution, double norm) {
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
}