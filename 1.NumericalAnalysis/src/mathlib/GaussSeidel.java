package mathlib;

public class GaussSeidel {

	private double epsilon = 1e-8;
	private int maxCountNumber = 2000;

	// ガウスザイデル法
	public Vector solve(Matrix a, Vector b) {
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
