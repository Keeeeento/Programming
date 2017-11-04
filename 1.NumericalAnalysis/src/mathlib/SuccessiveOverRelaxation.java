package mathlib;

public class SuccessiveOverRelaxation extends StationaryIterativeMethod {

	private static int n;
	private static Vector x;

	/**
	 * 緩和係数
	 */

	protected static double omega = 1.3;

	/**solve
	 * 一般的なprivagteメソッド
	 * @param a
	 * @param x
	 * @param b
	 */
	private static void sor(Matrix a, Vector b) {
		n = a.getN();
		x = x0.copy();
		Vector xOld = new Vector(n);
		Vector xTilde = new Vector(n);

		for (iteration = 0; iteration < maxIter; iteration++) {
			for (int i = 0; i < n; i++) {
				double sum = 0.0;
				for (int j = 0; j < n; j++) {
					if (j != i) {
						sum += a.getData()[i][j] * x.getData()[j];
					}
				}
				xTilde.getData()[i] = (b.getData()[i] - sum) / a.getData()[i][i];
				x.getData()[i] = omega * xTilde.getData()[i] + (1.0 - omega) * x.getData()[i];
				//または x.getData()[i] = x.getData()[i] + omega * (xTilde.getData()[i] - x.getData()[i]);
			}

			if (xOld.getRelativeError(norm, x) <= epsilon) {
				break;
			}
			xOld = x.copy();
		}
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
	public static Vector solve(Matrix a, Vector b) {
		sor(a, b);
		return x;
	}

	/**getIter
	 * @param a
	 * @param b
	 * @return iteration 反復回数
	 */
	public static int getIter(Matrix a, Vector b) {
		sor(a, b);
		if (iteration == maxIter) {
			return 0;
		}
		return iteration;
	}

	public static void main(String[] args) {
		Matrix a = new Matrix(new double[][] { { 3, 2, 1 }, { 1, 3, -2 }, { 2, -1, 4 } });
		Vector b = new Vector(new double[] { 4, 6, -3 });
		solve(a, b).printTeX("x");
		System.out.println(getIter(a, b));

	}
}
