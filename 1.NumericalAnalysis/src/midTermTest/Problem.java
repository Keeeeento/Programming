package midTermTest;

import mathlib.Jacobi;
import mathlib.Matrix;
import mathlib.Vector;

public class Problem {
	public static void main(String[] args) {
		Matrix a = new Matrix(new double[][] { { 3, 1, 1 }, { 1, 3, 1 }, { 1, 1, 3 } });
		Vector b = new Vector(new double[] { 0, 4, 6 });
		Jacobi.solve(a, b).print();
	}

}
