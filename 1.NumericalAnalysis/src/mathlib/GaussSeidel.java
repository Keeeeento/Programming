package mathlib;

public class GaussSeidel extends SuccessiveOverRelaxation {

	// @return x
	public static Vector solve(Matrix a, Vector b) {
		SuccessiveOverRelaxation.setOmega(1);
		return SuccessiveOverRelaxation.solve(a, b); // SOR法において ω = 1
	}

	// @return iteration
	public static int getIteration(Matrix a, Vector b) {
		SuccessiveOverRelaxation.setOmega(1);
		return SuccessiveOverRelaxation.getIter(a, b); // SOR法において ω = 1
	}

	private static void solve(Matrix a, Vector x, Vector b) {
		int n = b.getData().length;
		Vector xOld = new Vector(n);
		for (iteration = 0; iteration < maxIterationNumber; iteration++) {
			for (int i = 0; i < n; i++) {
				double sum = 0.0;
				for (int j = 0; j < n; j++) {
					if (j != i) {
						sum += a.getData()[i][j] * x.getData()[j];
					}
				}
				x.getData()[i] = (b.getData()[i] - sum) / a.getData()[i][i];
			}
			if (xOld.getRelativeError(normNumber, x) <= epsilon) {
				break;
			} else {
				xOld = x.copy();
			}
		}

	}

	// 収束判定条件:無限大ノルム相対誤差による解
	public static Vector solveWithInfinityNorm(Matrix a, Vector b) {
		int n = b.getData().length;
		Vector x = new Vector(n);
		Vector xOld = new Vector(n);
		int iteration;
		for (iteration = 0; iteration < maxIterationNumber; iteration++) {
			for (int i = 0; i < n; i++) {
				double sum = 0.0;
				for (int j = 0; j < n; j++) {
					if (j != i) {
						sum += a.getData()[i][j] * x.getData()[j];
					}
				}
				x.getData()[i] = (b.getData()[i] - sum) / a.getData()[i][i];
			}
			if (xOld.getRelativeErrorOfInfinityNorm(x) <= epsilon) {
				break;
			} else {
				xOld = x.copy();
			}
		}

		if (iteration >= maxIterationNumber) {
			System.out.println("収束しません");
		}
		return x;

	}

	// 詳細を表示
	public static void solveAndShowDetail(Matrix a, Vector b) {
		System.out.println("- Gauss Seidel -");
		int n = b.getData().length;
		Vector x = new Vector(n);
		Vector xOld = new Vector(n);
		int iteration;
		for (iteration = 0; iteration < maxIterationNumber; iteration++) {
			for (int i = 0; i < n; i++) {
				double sum = 0.0;
				for (int j = 0; j < n; j++) {
					if (j != i) {
						sum += a.getData()[i][j] * x.getData()[j];
					}
				}
				x.getData()[i] = (b.getData()[i] - sum) / a.getData()[i][i];
			}
			if (xOld.getRelativeErrorOfOneNorm(x) <= epsilon) {
				break;
			} else {
				xOld = x.copy();
			}
		}

		if (iteration >= maxIterationNumber) {
			System.out.println("収束しません");
		}
		if (iteration < maxIterationNumber) {
			x.print("x");
			System.out.println("iteration = " + iteration);
		} else {
			System.out.println("収束しません");
		}
		System.out.println();

	}

	//	// 反復回数
	//	public static double getIteration(Matrix a, Vector b) {
	//		GaussSeidel.solveWithOneNorm(a, b);
	//		if (iteration == maxIterationNumber) {
	//			iteration = 0;
	//		}
	//		return iteration;
	//	}
	//
	//	// 演算回数
	//	public static double getOperation(Matrix a, Vector b) {
	//		GaussSeidel.solveBySum(a, b);
	//		if (iteration == maxIterationNumber) {
	//			operation = 0;
	//		}
	//		return operation;
	//	}

	// 使わない
	public static Vector solveBySum(Matrix a, Vector b) { // 未完成？
		int n = b.getData().length;
		int iteration;
		Vector x = Vector.allNumber(n, 1);
		Vector xOld = x.copy();

		for (iteration = 0; iteration < maxIterationNumber; iteration++) {
			for (int i = 0; i < n; i++) {
				double sum1 = 0.0;
				double sum2 = 0.0;
				for (int j = 0; j < n; j++) {
					if (j > i) {
						sum1 += a.getData()[i][j] * x.getData()[j];
					} else if (j < i) {
						sum2 += a.getData()[i][j] * xOld.getData()[j];
					}
				}

				x.getData()[i] = (b.getData()[i] - sum1 - sum2) / a.getData()[i][i];
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

		return x;
	}

	// 収束するまで相対誤差を検出し続ける
	public static Vector solveAndShowError(double norm, Matrix a, Vector b, Vector exactSolution) {
		int n = b.getData().length;
		int iteration;
		Vector x = Vector.allNumber(n, 1); // 初期化
		Vector xOld = x.copy();

		System.out.println("-- Gauss Seidel--");
		System.out.println("iteration number,relative error of " + norm + " norm");
		for (iteration = 0; iteration < maxIterationNumber; iteration++) {
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
		if (iteration >= maxIterationNumber) {
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

		for (iteration = 0; iteration < maxIterationNumber; iteration++) {
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
		if (iteration >= maxIterationNumber) {
			System.out.println("収束しません");
			iteration = 0;
		}
		return iteration;
	}

}
