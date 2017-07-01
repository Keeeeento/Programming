package minitest;

import mathlib.Matrix;
import mathlib.Vector;

public class Hilbert2 {
	public static void main(String[] args) {
		int n = 6;
		Matrix a = new Matrix(n);
		a.hilbertPlus1();

		// 1
		double cond = a.getInfinityConditionNumber();
		System.out.println("cond = " + cond);

		// 2
		Vector x = new Vector(n);
		x.allNumber(1);
		Vector b = new Vector(n);
		b = a.multiply(a, x);
		Vector xTilde = a.gaussianElimination(a, b);

		double residualNorm = xTilde.getRelativeResidualOfInfinityNorm(a, b);
		System.out.println("residualNorm = " + residualNorm);

		double errorNorm = xTilde.getRelativeErrorOfInfinityNorm(x);
		System.out.println("errorNorm = " + errorNorm);

	}

}
