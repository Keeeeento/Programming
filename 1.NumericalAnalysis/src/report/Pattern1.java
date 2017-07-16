package report;

import mathlib.GaussSeidel;
import mathlib.Jacobi;
import mathlib.Matrix;
import mathlib.Vector;

public class Pattern1 {
	public static void main(String[] args) {
		int n = 200;
		Matrix a = Matrix.symmetricBand(n, 10, 2, 1);
		a.printInt("a");
		Vector xExact = Vector.allNumber(n, 2);
		Vector b = a.multiply(xExact);
		Jacobi.solveAndShowError(a, b, xExact, 1);
		GaussSeidel.solveAndShowError(a, b, xExact, 1);
	}

}
