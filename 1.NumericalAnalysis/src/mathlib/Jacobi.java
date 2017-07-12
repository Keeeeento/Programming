package mathlib;

public class Jacobi extends StationaryIterativeMethod {
	static int iteration; // 反復回数
	static int operation = 0; // 演算回数

	// 収束判定条件:1ノルム相対誤差による解
	public static Vector solveWithOneNorm(Matrix a, Vector b) {
		int n = b.getData().length;
		Vector x = new Vector(n);
		Vector xOld = new Vector(n);

		for (iteration = 0; iteration < maxIterationNumber; iteration++) {
			for (int i = 0; i < n; i++) {
				x.getData()[i] = b.getData()[i];
				operation++;
				for (int j = 0; j < n; j++) {
					if (i != j) {
						x.getData()[i] -= a.getData()[i][j] * xOld.getData()[j];
						operation++;
					}
				}
				x.getData()[i] /= a.getData()[i][i];
				operation++;
			}
			if (xOld.getRelativeErrorOfOneNorm(x) <= epsilon) { // 収束判定条件:1ノルム相対誤差
				break;
			} else {
				xOld = x.copy();
				operation++;
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
				operation++;
				for (int j = 0; j < n; j++) {
					if (i != j) {
						x.getData()[i] -= a.getData()[i][j] * xOld.getData()[j];
						operation++;
					}
				}
				x.getData()[i] /= a.getData()[i][i];
				operation++;
			}
			if (xOld.getRelativeErrorOfInfinityNorm(x) <= epsilon) { // 収束判定条件:無限大ノルム相対誤差
				break;
			} else {
				xOld = x.copy();
				operation++;
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
			System.out.println("operation = " + operation);
		} else {
			System.out.println("収束しません");
		}
		System.out.println();

	}

	// 使わない
	public static Vector solveWithSum(Matrix a, Vector b) {
		int n = b.getData().length;
		Vector x = new Vector(n);
		Vector xOld = new Vector(n);
		int iteration = 0;
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
}