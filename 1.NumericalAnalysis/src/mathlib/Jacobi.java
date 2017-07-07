package mathlib;

public class Jacobi {
	static double epsilon = 10e-8;
	static int maxCountNumber = 100000;
	static int count = 0;

	public static Vector solve(Matrix a, Vector b) {
		int n = b.getData().length;
		Vector x = new Vector(n);
		Vector xOld = new Vector(n);
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
		System.out.println("count = " + count);

		// System.out.println(count);
		return x;

	}

}