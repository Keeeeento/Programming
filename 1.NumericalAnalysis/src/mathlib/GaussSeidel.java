package mathlib;

public class GaussSeidel extends StationaryIterativeMethod {

	public GaussSeidel() {
		super();
	}

	/**
	 * コンストラクタ
	 * @param epsilon マシンイプシロン
	 * @param norm ノルム数
	 * @param maxIter 最大反復回数
	 */
	public GaussSeidel(double epsilon, double norm, int maxIter, Vector x0) {
		super(epsilon, norm, maxIter, x0);
	}

	public GaussSeidel(StationaryIterativeMethod conditions) {
		this.epsilon = conditions.epsilon;
		this.norm = conditions.norm;
		this.max_iteration = conditions.max_iteration;
		this.x0 = conditions.x0;
	}

	/**
	 * solve
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
				double sum = 0.0;
				for (int j = 0; j < n; j++) {
					if (j != i) {
						sum += a.getData()[i][j] * x.getData()[j];
					}
				}
				x.getData()[i] = (b.getData()[i] - sum) / a.getData()[i][i];
			}
			if (xOld.getRelativeError(norm, x) <= epsilon || iteration >= max_iteration) {
				break;
			} else {
				xOld = x.copy();
			}
		}

		return x;

	}

	// 詳細を表示
	//	public static void solveAndShowDetail(Matrix a, Vector b) {
	//		System.out.println("- Gauss Seidel -");
	//		Vector x = GaussSeidel.solve(a, b);
	//		if (iteration < maxIter) {
	//			x.print("x");
	//			System.out.println("iteration = " + iteration);
	//		} else {
	//			System.out.println("収束しません");
	//		}
	//		System.out.println();
	//
	//	}

	// 反復回数
	public int getIter(Matrix a, Vector b) {
		this.solve(a, b);
		if (iteration == max_iteration) {
			return 0;
		}
		return iteration;
	}

	// 収束するまで相対誤差を検出し続ける
	// 昔使ったやつ
	//	public static Vector solveAndShowError(double norm, Matrix a, Vector b, Vector exactSolution) {
	//		int n = b.getData().length;
	//		int iteration;
	//		Vector x = Vector.allNumber(n, 1); // 初期化
	//		Vector xOld = x.copy();
	//
	//		System.out.println("-- Gauss Seidel--");
	//		System.out.println("iteration number,relative error of " + norm + " norm");
	//		for (iteration = 0; iteration < max_iteration; iteration++) {
	//			for (int i = 0; i < n; i++) {
	//				double sum = 0.0;
	//				for (int j = 0; j < n; j++) {
	//					if (i != j) {
	//						sum += a.getData()[i][j] * x.getData()[j];
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
	//		if (iteration >= max_iteration) {
	//			System.out.println("収束しません");
	//		}
	//		System.out.println();
	//		return x;
	//	}

	// 反復回数を返す
	//	public static int getIterationNumber(double norm, Matrix a, Vector b, Vector exactSolution) {
	//		int n = b.getData().length;
	//		int iteration;
	//		Vector x = Vector.allNumber(n, 1); // 初期化
	//		Vector xOld = x.copy();
	//
	//		for (iteration = 0; iteration < max_iteration; iteration++) {
	//			for (int i = 0; i < n; i++) {
	//				double sum = 0.0;
	//				for (int j = 0; j < n; j++) {
	//					if (i != j) {
	//						sum += a.getData()[i][j] * x.getData()[j];
	//					}
	//				}
	//				x.getData()[i] = (b.getData()[i] - sum) / a.getData()[i][i];
	//			}
	//			if (xOld.getRelativeError(norm, x) <= epsilon) {
	//				break;
	//			} else {
	//				xOld = x.copy();
	//			}
	//		}
	//		if (iteration >= max_iteration) {
	//			System.out.println("収束しません");
	//			iteration = 0;
	//		}
	//		return iteration;
	//	}

}