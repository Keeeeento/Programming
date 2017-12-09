package mathlib;

public class SuccessiveOverRelaxation extends LinearCondition {
	/*
	 * x^{m+1} = (D + ωE)^{-1}[(1-ω)D - ωF]x^{m} + ω(D + ωE)^{-1}b (E:下,F:上)
	 *
	 * xTilde = D^{-1}(b - Ex^{m+1} - Fx^{m})
	 * x^{m+1} = x^{m} + ω(xTilde - x^{m})
	 * */
	/**
	 * 緩和係数
	 */
	protected static double omega;
	private static Vector x;

	/**
	 *
	 * <br>
	 * 収束判定条件
	 * <ul>
	 * <li>isAboslute
	 * <li>normNumber
	 * <li>epsilon
	 * </ul>
	 * を使います．
	 * @param a
	 * @param b
	 * @param x0
	 * @param omega
	 * @return x 未知数ベクトル 近似解
	 */
	public static Vector solve() {

		x = x0.copy();
		Vector xOld = new Vector(n);
		double xTilde = 0.0;

		for (iteration = 0; iteration < maxIteration; iteration++) {
			for (int i = 0; i < n; i++) {
				double sum = 0.0;
				for (int j = 0; j < n; j++) {
					if (j != i) {
						sum += a.getData()[i][j] * x.getData()[j];
					}
				}
				xTilde = (b.getData()[i] - sum) / a.getData()[i][i];
				xOld.getData()[i] = x.getData()[i];
				x.getData()[i] = omega * xTilde + (1.0 - omega) * xOld.getData()[i];
			}
			if (xOld.getError(isAbsolute, normNumber, x) <= epsilon) {
				break;
			}
		}
		return x;
	}

	public static Vector solve2() {

		x = x0.copy();
		Vector xOld = new Vector(n);
		for (iteration = 0; iteration < maxIteration; iteration++) {
			for (int i = 0; i < n; i++) {
				double sum = 0.0;
				for (int j = 0; j < n; j++) {
					if (j != i) {
						sum += a.getData()[i][j] * x.getData()[j];
					}
				}
				x.getData()[i] = (b.getData()[i] - sum) / a.getData()[i][i] * omega;
			}
			if (xOld.getRelativeError(normNumber, x) <= epsilon || iteration >= maxIteration) {
				break;
			} else {
				xOld = x.copy();
			}
		}

		return x;
	}

	//	public static Vector solveOld() {
	//		x = x0.copy();
	//		Vector xOld = new Vector(n);
	//		double xTilde = 0.0;
	//
	//		for (iteration = 0; iteration < maxIteration; iteration++) {
	//			for (int i = 0; i < n; i++) {
	//				double sum = 0.0;
	//				for (int j = 0; j < n; j++) {
	//					if (j != i) {
	//						sum += a.getData()[i][j] * x.getData()[j];
	//					}
	//				}
	//				xTilde = (b.getData()[i] - sum) / a.getData()[i][i];
	//				x.getData()[i] = omega * xTilde + (1.0 - omega) * x.getData()[i];
	//				//または x.getData()[i] = x.getData()[i] + omega * (xTilde - x.getData()[i]);
	//			}
	//
	//			if (xOld.getRelativeError(normNumber, x) <= epsilon) {
	//				break;
	//			}
	//			xOld = x.copy();
	//		}
	//		return x;
	//	}

	/**
	 * @return iteration
	 */
	public static int getIteration() {
		solve();
		if (iteration == maxIteration) {
			return 0;
		}
		return iteration;
	}

	/**
	 * 未完成
	 * SOR法の反復行列ℒ
	 * @return L
	 */
	public static double getIterativeMatrix() {
		return 0;
	}

	/**
	 * 最適なω
	 * @return 2/(1 + √(1-ρ(Jacobi)^2))
	 */
	public static double getOptOmega() {
		double rho = SpectralRadius.getSpectralRadiusByRayleigh(Jacobi.getJacobiMatrix());
		return 2.0 / (1.0 + Math.sqrt(1.0 - Math.pow(rho, 2.0)));
	}

	public static void main(String[] args) {

		epsilon = 1e-10;
		normNumber = 2.0;
		maxIteration = (int) 1e+03;
		isAbsolute = true;

		n = 3;
		a = new Matrix(new double[][] { { 3, 2, 1 }, { 1, 3, -2 }, { 2, -1, 4 } });
		x0 = Vector.allNumber(n, 1);
		maxIteration = 500;

		b = new Vector(new double[] { 4, 6, -3 });
		SuccessiveOverRelaxation.solve().printTeX("x");
		System.out.println(SuccessiveOverRelaxation.getIteration());
	}
}
