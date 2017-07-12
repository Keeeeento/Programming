package mathlib;

public class GaussSeidel extends StationaryIterativeMethod {
	static int iteration; // 反復回数
	static int operation = 0; // 演算回数

	// 収束判定条件:1ノルム相対誤差による解
	public static Vector solveWithOneNorm(Matrix a, Vector b) {
		int n = b.getData().length;
		Vector x = new Vector(n);
		Vector xOld = new Vector(n);

		for (iteration = 0; iteration < maxIterationNumber; iteration++) {
			for (int i = 0; i < n; i++) {
				double sum = 0.0;
				for (int j = 0; j < n; j++) {
					if (j != i) {
						sum += a.getData()[i][j] * x.getData()[j];
						operation++;
					}
				}
				x.getData()[i] = (b.getData()[i] - sum) / a.getData()[i][i];
				operation++;
			}
			if (xOld.getRelativeErrorOfOneNorm(x) <= epsilon) {
				break;
			} else {
				xOld = x.copy();
				operation++;
			}
		}

		if (iteration >= maxIterationNumber) {
			System.out.println("収束しません");
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
				double sum = 0.0;
				for (int j = 0; j < n; j++) {
					if (j != i) {
						sum += a.getData()[i][j] * x.getData()[j];
						operation++;
					}
				}
				x.getData()[i] = (b.getData()[i] - sum) / a.getData()[i][i];
				operation++;
			}
			if (xOld.getRelativeErrorOfInfinityNorm(x) <= epsilon) {
				break;
			} else {
				xOld = x.copy();
				operation++;
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
		Vector x = GaussSeidel.solveWithOneNorm(a, b);
		if (iteration < maxIterationNumber) {
			x.print("x");
			System.out.println("iteration = " + iteration);
			System.out.println("operation = " + operation);
		} else {
			System.out.println("収束しません");
		}
		System.out.println();

	}

	// 使わない
	public Vector solveUncompleted(Matrix a, Vector b) { // 未完成
		int n = b.getData().length;
		int count;
		Vector x = new Vector(n);
		Vector xOld = new Vector(n);

		for (count = 0; count < maxIterationNumber; count++) {
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
		if (count < maxIterationNumber) {
			System.out.println("count = " + count);
		} else {
			System.out.println("収束しません");
		}

		return x;

	}

}
