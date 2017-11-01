package mathlib;

public class SOR extends StationaryIterativeMethod {

	/**
	 * 緩和係数
	 * 初期値0.5
	 */
	private static double omega = 0.5;

	public static double getOmega() {
		return omega;
	}

	public static void setOmega(double omega) {
		SOR.omega = omega;
	}

	/**solve
	 * 一般的なprivagteメソッド
	 * @param a
	 * @param x
	 * @param b
	 * @param iteration
	 */
	private static void solve(Matrix a, Vector x, Vector b, int iteration) {
		int n = a.getN();
		Vector xOld = new Vector(n);
		Vector xTilde = new Vector(n);
		Vector xTildeOld = new Vector(n);

		do {
			for (int i = 0; i < n; i++) {
				double sum = 0.0;
				for (int j = 0; j < n; j++) {
					if (j != i) {
						sum += a.getData()[i][j] * x.getData()[j];
					}
				}
				xTilde.getData()[i] = (b.getData()[i] - sum) / a.getData()[i][i];
				x.getData()[i] = x.getData()[i] + omega * (xTilde.getData()[i] - x.getData()[i]);
			}
			iteration++;
			xOld = x.copy();
			xTilde = xTildeOld.copy();
		} while (xOld.getRelativeError(normNumber, x) > epsilon || iteration < maxIterationNumber);

	}

	/**solve
	 * @param a
	 * @param b
	 * @return x 解を求める
	 */
	public static Vector solve(Matrix a, Vector b) {
		Vector x = new Vector(a.getN());
		solve(a, x, b, 0);
		return x;
	}

	/**getIter
	 * @param a
	 * @param b
	 * @return iteration 反復回数
	 */
	public static int getIter(Matrix a, Vector b) {
		int iteration = 0;
		solve(a, new Vector(a.getN()), b, iteration);
		return iteration;
	}

	public static void main(String[] args) {
		Matrix a = new Matrix(new double[][] { { 3, 1, 1 }, { 1, 3, 1 }, { 1, 1, 3 } });
		Vector b = new Vector(new double[] { 0, 4, 6 });
		solve(a, b).print("X");
		System.out.println(getIter(a, b));

	}
}
