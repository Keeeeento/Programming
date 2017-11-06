package problemsOf2ndPeriod;

import mathlib.CholeskyDecomposition;
import mathlib.Matrix;

public class Trial04_1 {
	public static void main(String[] args) {
		double[][] aData = {
				{ 1, 1, 1 },
				{ 1, 5, 5 },
				{ 1, 5, 14 }
		};
		Matrix a = new Matrix(aData);

		CholeskyDecomposition.getL(a).printInt("L");
	}
}