package mathlib;

public class Jacobi extends StationaryIterativeMethod {

	/**
	 * デフォルトコンストラクタ
	 */
	public Jacobi() {
		super();
	}

	/**
	 * コンストラクタ
	 * @param epsilon マシンイプシロン
	 * @param norm ノルム数
	 * @param maxIter 最大反復回数
	 */
	public Jacobi(double epsilon, double norm, int maxIter, Vector x0) {
		super(epsilon, norm, maxIter, x0);
	}

	/**
	 * コンストラクタ
	 * @param conditions 初期条件
	 */
	public Jacobi(StationaryIterativeMethod conditions) {
		this.epsilon = conditions.epsilon;
		this.norm = conditions.norm;
		this.max_iteration = conditions.max_iteration;
		this.x0 = conditions.x0;
	}

	/**solve
	 * @param a 係数行列
	 * @param b 定数項ベクトル
	 * @return x 未知数ベクトル 近似解
	 */
	public Vector solve(Matrix a, Vector b) {
		int n = b.getData().length;
		Vector x = x0.copy();
		Vector xOld = new Vector(n);

		for (iteration = 0; iteration < max_iteration; iteration++) {
			for (int i = 0; i < n; i++) {
				x.getData()[i] = b.getData()[i];
				for (int j = 0; j < n; j++) {
					if (i != j) {
						x.getData()[i] -= a.getData()[i][j] * xOld.getData()[j];
					}
				}
				x.getData()[i] /= a.getData()[i][i];
			}
			if (xOld.getRelativeError(norm, x) <= epsilon || iteration >= max_iteration) { // 収束判定条件
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
	public int getIter(Matrix a, Vector b) {
		this.solve(a, b);
		if (iteration == max_iteration) {
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

}