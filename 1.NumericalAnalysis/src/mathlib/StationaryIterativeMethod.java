package mathlib;

public class StationaryIterativeMethod {
	/**
	 * マシンイプシロン
	 * 初期値1e-14
	 */
	protected static double epsilon = 1e-14;

	public static double getEpsilon() {
		return epsilon;
	}

	public static void setEpsilon(double epsilon) {
		StationaryIterativeMethod.epsilon = epsilon;
	}

	/**
	 * 最大反復回数
	 * 初期値1e+10
	 */
	protected static int maxIterationNumber = (int) (1e+10);

	public static int getMaxIterationNumber() {
		return maxIterationNumber;
	}

	public static void setMaxIterationNumber(int maxIterationNumber) {
		StationaryIterativeMethod.maxIterationNumber = maxIterationNumber;
	}

	/**
	 * ノルム
	 * 初期値無限大ノルム
	 */
	protected static double normNumber = 0;

	public static double getNormNumber() {
		return normNumber;
	}

	public static void setNormNumber(double normNumber) {
		StationaryIterativeMethod.normNumber = normNumber;
	}

	public static Matrix getIterativeMatrixOf(Matrix a) {
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

	public static Vector getIterativeVectorOf(Matrix a, Vector b) {
		int n = a.getData().length;
		Vector c = new Vector(n);

		for (int i = 0; i < n; i++) {
			c.getData()[i] = b.getData()[i] / a.getData()[i][i];
		}

		return c;
	}

}
