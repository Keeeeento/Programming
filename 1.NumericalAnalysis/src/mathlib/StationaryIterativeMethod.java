package mathlib;

public class StationaryIterativeMethod {

	protected static double epsilon = 1e-14;

	//	protected static int n = 5;
	protected static Vector x0;

	protected static int iteration = 0;

	protected static int maxIter = (int) (1e+3);

	protected static double norm = 2;

	//以下のコンストラクタの部分は使用していない(今後に期待)

	/**
	 * デフォルトコンストラクタ
	 */
	public StationaryIterativeMethod() {
		this.epsilon = 1e-14;
		this.norm = 0;
		this.maxIter = (int) 1e+3;
	}

	/**
	 * コンストラクタ
	 * @param epsilon
	 * @param norm
	 * @param maxIter
	 */
	public StationaryIterativeMethod(double epsilon, double norm, int maxIter) {
		StationaryIterativeMethod.epsilon = epsilon;
		StationaryIterativeMethod.norm = norm;
		StationaryIterativeMethod.maxIter = maxIter;
	}

	//	public static Matrix getIterativeMatrixOf(Matrix a) {
	//		int n = a.getData().length;
	//		Matrix t = new Matrix(n);
	//
	//		for (int i = 0; i < n; i++) {
	//			for (int j = 0; j < n; j++) {
	//				if (j != i) {
	//					t.getData()[i][j] = a.getData()[i][j] / a.getData()[i][i];
	//				}
	//			}
	//		}
	//
	//		return t.multiply(-1);
	//	}
	//
	//	public static Vector getIterativeVectorOf(Matrix a, Vector b) {
	//		int n = a.getData().length;
	//		Vector c = new Vector(n);
	//
	//		for (int i = 0; i < n; i++) {
	//			c.getData()[i] = b.getData()[i] / a.getData()[i][i];
	//		}
	//
	//		return c;
	//	}

}
