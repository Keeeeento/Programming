package mathlib;

public class SuccessiveOverRelaxation extends StationaryIterativeMethod {

	/**
	 * 緩和係数
	 */
	protected double omega;

	/**
	 * デフォルトコンストラクタ
	 *  omega 初期値 1.5
	 */
	public SuccessiveOverRelaxation() {
		super();
		this.omega = 1.5;
	}

	/**
	 * コンストラクタ
	 * @param epsilon マシンイプシロン
	 * @param norm ノルム数
	 * @param maxIter 最大反復回数
	 * @param omega 緩和係数
	 */
	public SuccessiveOverRelaxation(double epsilon, double norm, int maxIter, Vector x0, double omega) {
		super(epsilon, norm, maxIter, x0);
		this.omega = omega;
	}

	/**
	 * コンストラクタ
	 * @param conditions
	 * @param omega 緩和係数
	 */
	public SuccessiveOverRelaxation(StationaryIterativeMethod conditions, double omega) {
		this.epsilon = conditions.epsilon;
		this.norm = conditions.norm;
		this.max_iteration = conditions.max_iteration;
		this.x0 = conditions.x0;
		this.omega = omega;
	}

	/**
	 * solve
	 * @param a 係数行列
	 * @param b 定数項ベクトル
	 * @return x 未知数ベクトル 近似解
	 */
	public Vector solve(Matrix a, Vector b) {
		n = a.getN();
		x = x0.copy();
		Vector xOld = new Vector(n);
		double x_tilde = 0.0;

		for (iteration = 0; iteration < max_iteration; iteration++) {
			for (int i = 0; i < n; i++) {
				double sum = 0.0;
				for (int j = 0; j < n; j++) {
					if (j != i) {
						sum += a.getData()[i][j] * x.getData()[j];
					}
				}
				x_tilde = (b.getData()[i] - sum) / a.getData()[i][i];
				x.getData()[i] = omega * x_tilde + (1.0 - omega) * x.getData()[i];
				//または x.getData()[i] = x.getData()[i] + omega * (xTilde - x.getData()[i]);
			}

			if (xOld.getRelativeError(norm, x) <= epsilon) {
				break;
			}
			xOld = x.copy();
		}
		return x;
	}
	//
	//	private void sor(Matrix a, Vector b) {
	//		super.n = a.getN();
	//		Vector xOld = new Vector(n);
	//		Vector xTilde = new Vector(n);
	//
	//		for (iteration = 0; iteration < maxIterationNumber; iteration++) {
	//			for (int i = 0; i < n; i++) {
	//				double sum = 0.0;
	//				for (int j = 0; j < n; j++) {
	//					if (j != i) {
	//						sum += a.getData()[i][j] * x.getData()[j];
	//					}
	//				}
	//				xTilde.getData()[i] = (b.getData()[i] - sum) / a.getData()[i][i];
	//				x.getData()[i] = omega * xTilde.getData()[i] + (1.0 - omega) * x.getData()[i];
	//				//または x.getData()[i] = x.getData()[i] + omega * (xTilde.getData()[i] - x.getData()[i]);
	//			}
	//
	//			System.out.println(iteration);
	//			if (xOld.getRelativeError(normNumber, x) <= epsilon) {
	//				break;
	//			}
	//			xOld = x.copy();
	//		}
	//	}

	/**solve
	 * @param a
	 * @param b
	 * @return x 解を求める
	 */
	//	public Vector solve(Matrix a, Vector b) {
	//		sor(a, b);
	//		return x;
	//	}

	/**getIter
	 * 最大反復回数時 0
	 * @param a 係数行列
	 * @param b 定数項ベクトル
	 * @return iteration 反復回数
	 */
	public int getIter(Matrix a, Vector b) {
		this.solve(a, b);
		if (iteration == max_iteration) {
			return 0;
		}
		return iteration;
	}

	/**
	 * SOR法の反復行列ℒ
	 * @return L
	 */
	public double getIterativeMatrix() {
		return 0;
	}

	public static void main(String[] args) {
		SuccessiveOverRelaxation sor = new SuccessiveOverRelaxation();
		Matrix a = new Matrix(new double[][] { { 3, 2, 1 }, { 1, 3, -2 }, { 2, -1, 4 } });
		Vector b = new Vector(new double[] { 4, 6, -3 });
		sor.solve(a, b).printTeX("x");
		System.out.println(sor.getIter(a, b));
	}
}
