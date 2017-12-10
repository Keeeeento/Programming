package minitest;

import mathlib.GaussSeidel;
import mathlib.Jacobi;
import mathlib.Matrix;
import mathlib.Vector;

public class JacobiExample {
	public static void main(String[] args) {
		double[][] aData = { { 6, 1, 1, 1 }, { 1, 7, 1, 1 }, { 0, 1, 8, 1 }, { 0, 0, 1, 9 } };
		Matrix a = new Matrix(aData);
		double[] bData = { 9, 10, 10, 10 };
		Vector b = new Vector(bData);

		Jacobi.solve(a, b).printf("Jacobi");
		GaussSeidel.solveAndShowDetail(a, b);

	}

}
