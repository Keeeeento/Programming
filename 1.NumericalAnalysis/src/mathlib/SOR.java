package mathlib;

public class SOR extends StationaryIterativeMethod {

	// 返り値のない一般的な解法
	private static void solve(Matrix a, Vector x, Vector b, double omega, int iteration) {
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
		} while (xOld.getRelativeErrorOfOneNorm(x) > epsilon || iteration < maxIterationNumber);

	}

	// @return x
	public static Vector solve(Matrix a, Vector b, double omega) {
		Vector x = new Vector(a.getN());
		solve(a, x, b, omega, 0);
		return x;
	}

	// @return iteration
	public static int getIter(Matrix a, Vector b, double omega) {
		int iteration = 0;
		solve(a, new Vector(a.getN()), b, omega, iteration);
		return iteration;
	}

	// Check
	public static void main(String[] args) {
	}

}
