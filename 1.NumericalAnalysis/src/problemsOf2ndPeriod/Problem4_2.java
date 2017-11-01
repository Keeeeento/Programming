package problemsOf2ndPeriod;

import mathlib.CholeskyDecomposition;
import mathlib.Matrix;
import mathlib.Vector;

public class Problem4_2 {

	public static void main(String[] args) {
		double aData[][] = {
				{ 1.0, -1.0, 2.0, 1.0, -2.0 },
				{ -1.0, 5.0, -4.0, 3.0, 4.0 },
				{ 2.0, -4.0, 14.0, -3.0, 1.0 },
				{ 1.0, 3.0, -3.0, 10.0, -4.0 },
				{ -2.0, 4.0, 1.0, -4.0, 11.0 }
		};
		Matrix a = new Matrix(aData);
		int n = a.getN();
		Matrix l = CholeskyDecomposition.getL(a);
		Vector b = Vector.allNumber(n, 1.0);

		Vector x = CholeskyDecomposition.solve(a, b);
		System.out.println("(1)");
		l.printTeXInt("L_2");
		System.out.println("(2)");
		x.printTeX("x");

	}

}
