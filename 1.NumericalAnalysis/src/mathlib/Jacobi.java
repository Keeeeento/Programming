package mathlib;

public class Jacobi {
	static double epsilon = 10e-8;
	static int maxCountNumber = 100000;

	public static Vector solve(Matrix a, Vector b) {
		int n = b.getData().length;
		int count;
		Vector x = new Vector(n);
		Vector xOld = new Vector(n);

		for (count = 0; count < maxCountNumber; count++) {
			for (int i = 0; i < n; i++) {
				x.getData()[i] = b.getData()[i];
				for (int j = 0; j < n; j++) {
					if (i != j) {
						x.getData()[i] -= a.getData()[i][j] * xOld.getData()[j];
					}
				}
				x.getData()[i] /= a.getData()[i][i];

			}
			// System.out.println(xOld.getRelativeErrorOfOneNorm(x));
			if (xOld.getRelativeErrorOfOneNorm(x) <= epsilon) {
				break;
			} else {
				xOld = x.copy();
			}
		}
		System.out.println("count = " + count);

		return x;
	}

	public static Vector solveWithSum(Matrix a, Vector b) {
		int n = b.getData().length;
		Vector x = new Vector(n);
		Vector xOld = new Vector(n);
		int count = 0;
		for (count = 0; count < maxCountNumber; count++) {
			for (int i = 0; i < n; i++) {
				double sum = 0.0;
				for (int j = 0; j < n; j++) {
					if (i != j) {
						sum += a.getData()[i][j] * xOld.getData()[j];
					}
				}
				x.getData()[i] = (b.getData()[i] - sum) / a.getData()[i][i];
			}
			if (xOld.getRelativeErrorOfOneNorm(x) <= epsilon) {
				break;
			} else {
				xOld = x.copy();
			}
		}
		if (count < maxCountNumber) {
			System.out.println("count = " + count);
		} else {
			System.out.println("収束しません");
		}
		// System.out.println(count);
		return x;

	}
}