package report;

import mathlib.Matrix;

public class MaximumEigenValue {
	public static void main(String[] args) {
		Matrix a = new Matrix(new double[][] { { 1, -1 }, { -1, 2 } });
		System.out.println(a.getSpectralRadius());

	}

}
