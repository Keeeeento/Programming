package mathlib;

public class SpectralRadius extends ConvergenceDeterminationCondition {

	private int iteration;
	private double lambda;

	private Matrix a;

	/**
	 * 初期ベクトル
	 * 0でない
	 */
	private Vector x0;

	/**
	 * デフォルトコンストラクタ
	 * 他にaとx0の宣言が必要
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
	public void powerMethod(Matrix a, Vector x0) {

		final int NORM_NUMBER = 2;
		lambda = 0.0;
		double lambda_old = 0.0;
		Vector x = x0.copy();
		Vector x_old = x0.copy();

		for (iteration = 1; iteration <= max_iteration; iteration++) {

			// ベクトルの正規化
			x_old = x_old.scalarMultiply(1.0 / x.getNorm(NORM_NUMBER));

			// べき乗の計算
			x = a.multiply(x_old);
			lambda = x.getMaximumElement() / x_old.getMaximumElement();

			if (Math.abs(lambda - lambda_old) / Math.abs(lambda) < epsilon) {
				break;
			}

			lambda_old = lambda;
			x_old = x.scalarMultiply(1.0 / x.getNorm(NORM_NUMBER));
		}
	}

	public double getSpectralRadius(Matrix a, Vector x0) {
		this.powerMethod(a, x0);
		return lambda;
	}

	public int getIteration(Matrix a, Vector x0) {
		this.powerMethod(a, x0);
		return iteration;
	}

	public void rayleighQuotient(Matrix a, Vector x0) {
		final int NORM_NUMBER = 2;
		lambda = 0.0;
		double lambda_old = 0.0;
		Vector x = x0.copy();
		Vector x_old = x0.copy();

		for (iteration = 1; iteration <= max_iteration; iteration++) {

			// ベクトルの正規化
			x_old = x_old.scalarMultiply(1.0 / x.getNorm(NORM_NUMBER));

			// レイリーによる計算
			x = a.multiply(x_old);
			lambda = Vector.innerProduct(x, a.multiply(x)) / Vector.innerProduct(x, x);

			if (Math.abs(lambda - lambda_old) / Math.abs(lambda) < epsilon) {
				break;
			}

			lambda_old = lambda;
			x_old = x.scalarMultiply(1.0 / x.getNorm(NORM_NUMBER));
		}
	}

	public static void main(String[] args) {
		SpectralRadius sr = new SpectralRadius();
		Matrix a = new Matrix(new double[][] { { 2, 1, 0 }, { 1, 4, 1 }, { 1, 1, 3 } });
		int n = a.getN();
		Vector x0 = Vector.allNumber(n, 1);
		System.out.println("lambda = " + sr.getSpectralRadius(a, x0));
	}

}
