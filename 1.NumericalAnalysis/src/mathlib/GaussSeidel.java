package mathlib;

public class GaussSeidel {

	static double epsilon = 1e-8;
	static int maxCountNumber = 100000;

	public static Vector solve(Matrix a, Vector b) {
		int n = b.getData().length;
		int count;
		Vector x = new Vector(n);
		Vector xOld = new Vector(n);

		for (count = 0; count < maxCountNumber; count++) {
			for (int i = 0; i < n; i++) {
				double sum = 0.0;
				for (int j = 0; j < n; j++) {
					if (j != i) {
						sum += a.getData()[i][j] * x.getData()[j];
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

		return x;

	}

	public Vector solveUncompleted(Matrix a, Vector b) { // 未完成
		int n = b.getData().length;
		int count;
		Vector x = new Vector(n);
		Vector xOld = new Vector(n);

		for (count = 0; count < maxCountNumber; count++) {
			for (int i = 0; i < n; i++) {
				double sum1 = 0.0;
				double sum2 = 0.0;
				for (int j = 0; j < n; j++) {
					if (j > i) {
						sum1 += a.getData()[i][j] * x.getData()[j];
					} else if (j < i) {
						sum2 += a.getData()[i][j] * xOld.getData()[j];
					}
				}

				x.getData()[i] = (b.getData()[i] - sum1 - sum2) / a.getData()[i][i];
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

		return x;

	}

}
