package problemsOf2ndPeriod;

import mathlib.Matrix;
import mathlib.Vector;

public class Problem5 {

	public static void main(String[] args) {
		int n = 10;
		for (int alpha = 2; alpha <= 8; alpha++) {

			Matrix a = Matrix.symmetricBand(n, alpha, -1.0);
			Vector b = Vector.allNumber(n, 1.0);
			Vector x = Vector.allNumber(n, 1.0);

		}

	}

}
