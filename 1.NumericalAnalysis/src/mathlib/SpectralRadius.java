package mathlib;

public class SpectralRadius extends ConvergenceDeterminationCondition {

	private int iteration;
	private double lambda;

	private Matrix matrix;

	public Matrix getMatrix() {
		return matrix;
	}

	public void setMarix(Matrix a) {
		this.matrix = a;
	}

	/**
	 * 初期ベクトル
	 * 0でない
	 */
	private Vector x0;

	public Vector getX0() {
		return x0;
	}

	public void setX0(Vector x0) {
		this.x0 = x0;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public SpectralRadius() {
		super();
	}

	/**
	 * コンストラクタ
	 * @param epsilon
	 * @param max_iteration
	 * @param norm_number
	 * @param is_absolute
	 */
	public SpectralRadius(double epsilon, int max_iteration, double norm_number, boolean is_absolute) {
		super(epsilon, max_iteration, norm_number, is_absolute);
	}

	/**
	 * べき乗法のアルゴリズム
	 * lambda <- 絶対値最大の固有値
	 */
	public void powerMethod() {

		final int NORM_NUMBER = 2;
		lambda = 0.0;
		double lambda_old = 0.0;
		Vector x = x0.copy();
		Vector x_old = x0.copy();

		for (iteration = 1; iteration <= max_iteration; iteration++) {

			// ベクトルの正規化
			x_old = x_old.scalarMultiply(1.0 / x.getNorm(NORM_NUMBER));
			// べき乗の計算
			x = matrix.multiply(x_old);
			lambda = x.getMaximumElement() / x_old.getMaximumElement();

			if (Math.abs(lambda - lambda_old) / Math.abs(lambda) < epsilon) {
				break;
			}
			lambda_old = lambda;
			x_old = x.scalarMultiply(1.0 / x.getNorm(NORM_NUMBER));
		}
	}

	public double getSpectralRadius() {
		this.powerMethod();
		return lambda;
	}

	public int getIteration() {
		this.powerMethod();
		return iteration;
	}

}
