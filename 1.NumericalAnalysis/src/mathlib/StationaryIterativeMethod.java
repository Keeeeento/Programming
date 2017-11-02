package mathlib;

public class StationaryIterativeMethod {
	/**
	 * マシンイプシロン
	 * 初期値1e-14
	 */
	protected static double epsilon = 1e-14;

	protected static int n = 5;

	/**
	 * 反復回数
	 * 初期化されていない
	 */
	protected static int iteration;

	/**
	 * 最大反復回数
	 * 初期値1e+3
	 */
	protected static int maxIterationNumber = (int) (1e+3);

	/**
	 * ノルム
	 * 初期値無限大ノルム
	 */
	protected static double normNumber = 0;

	/**
	 * 解ベクトルx
	 */
	protected static Vector x = new Vector(n);

	public static Vector getX() {
		return x;
	}

	public static void setX(Vector x) {
		StationaryIterativeMethod.x = x;
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
