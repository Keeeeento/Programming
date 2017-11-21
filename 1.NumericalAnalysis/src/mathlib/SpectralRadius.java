package mathlib;

public class SpectralRadius extends DefaultCondition {

	protected static double lambda;
	private static Vector x;

	/**
	 * べき乗法のアルゴリズム
	 * lambda <- 絶対値最大の固有値
	 * @param a
	 * @param x0
	 */
	public static void powerMethod(Matrix a, Vector x0) {

		int n = a.getN();
		final int NORM_NUMBER = 2;
		lambda = 0.0;
		double lambdaOld = 0.0;
		x = x0.copy();
		Vector xOld = x0.copy();

		for (iteration = 1; iteration <= maxIteration; iteration++) {

			// ベクトルの正規化
			xOld = xOld.scalarMultiply(1.0 / x.getNorm(NORM_NUMBER));

			// べき乗の計算
			x = a.multiply(xOld);

			// 固有値の計算
			for (int i = 0; i < n; i++) {
				if (xOld.getData()[i] != 0.0) {
					lambda = x.getData()[i] / xOld.getData()[i];
					i++;
				}
				if (xOld.getData()[i] != 0.0) {
					lambdaOld = x.getData()[i] / xOld.getData()[i];
					i = n;
				}
			}

			// 収束判定
			if (Math.abs(lambda - lambdaOld) / Math.abs(lambda) < epsilon) {
				break;
			}
			lambdaOld = lambda;
			if (lambda == 0.0) {
				System.out.println("計算できていません");
			}
		}
	}

	public static double getSpectralRadius(Matrix a) {
		powerMethod(a, Vector.allNumber(n, 1.0 / n));
		return lambda;
	}

	public static double getSpectralRadius(Matrix a, Vector x0) {
		powerMethod(a, x0);
		return lambda;
	}

	public static int getIteration(Matrix a, Vector x0) {
		powerMethod(a, x0);
		return iteration;
	}

	public static Vector getEigenVector(Matrix a, Vector x0) {
		powerMethod(a, x0);
		return x;
	}

	public static void rayleighQuotient(Matrix a, Vector x0) {
		final int NORM_NUMBER = 2;
		lambda = 0.0;
		double lambdaOld = 0.0;
		Vector x = x0.copy();
		Vector xOld = x0.copy();

		for (iteration = 1; iteration <= maxIteration; iteration++) {

			// ベクトルの正規化
			xOld = xOld.scalarMultiply(1.0 / xOld.getNorm(NORM_NUMBER));

			// レイリーによる計算
			x = a.multiply(xOld);
			lambda = Vector.innerProduct(x, a.multiply(x)) / Vector.innerProduct(x, x);

			if (Math.abs(lambda - lambdaOld) / Math.abs(lambda) < epsilon) {
				break;
			}
			lambdaOld = lambda;
		}
	}

	public static double getSpectralRadiusByRayleigh(Matrix a, Vector x0) {
		rayleighQuotient(a, x0);
		return lambda;
	}

	public static int getIterationByRayleigh(Matrix a, Vector x0) {
		rayleighQuotient(a, x0);
		return iteration;
	}

	public static void main(String[] args) {

		n = 5;
		Matrix a = new Matrix(n);
		a.symmetricBand(2.0, -1.0);
		Vector x0 = new Vector(n);
		x0.allNumber(1);
		epsilon = 1e-10;
		maxIteration = 1000;

		System.out.println(getSpectralRadius(a, x0));
		System.out.println(getIteration(a, x0));
		getEigenVector(a, x0).print("x");

		System.out.println(getSpectralRadius(Matrix.symmetricBand(n, 0, 5)));
	}

}
