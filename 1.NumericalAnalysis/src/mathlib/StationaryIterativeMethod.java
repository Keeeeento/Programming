package mathlib;

public class StationaryIterativeMethod {

	protected double epsilon;
	protected int n;
	protected Vector x, x0;
	protected int iteration;
	protected int max_iteration;
	protected double norm;

	//以下のコンストラクタの部分は使用していない(今後に期待)

	/**
	 * デフォルトコンストラクタ
	 */
	public StationaryIterativeMethod() {
		this.epsilon = 1e-14;
		this.norm = 0;
		this.max_iteration = (int) 1e+3;
	}

	/**
	 * コンストラクタ
	 * @param epsilon マシンイプシロン
	 * @param norm ノルム数
	 * @param max_iteration 最大反復回数
	 * @param x0 初期ベクトル
	 */
	public StationaryIterativeMethod(double epsilon, double norm, int max_iteration, Vector x0) {
		this.epsilon = epsilon;
		this.norm = norm;
		this.max_iteration = max_iteration;
		this.x0 = x0;
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

	//	public int getIter(Matrix a, Vector b) {
	//		return 0;
	//	}

}
