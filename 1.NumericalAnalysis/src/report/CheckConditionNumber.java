package report;

import mathlib.GaussSeidel;
import mathlib.Jacobi;
import mathlib.Matrix;
import mathlib.Vector;

public class CheckConditionNumber {
	public static void main(String[] args) {
		int n = 10;
		Matrix a = new Matrix(n);
		a.symmetricBand(100, 2, 1);
		Vector b = new Vector(n);
		b.allNumber(1);
		System.out.println(a.getConditionNumberOfOneNorm());
		Jacobi.solveAndShowDetail(a, b);
		GaussSeidel.solveAndShowDetail(a, b);

		// a.symmetricBand(5, 2, 2);
		// System.out.println(a.getConditionNumberOfOneNorm());
	}

}
