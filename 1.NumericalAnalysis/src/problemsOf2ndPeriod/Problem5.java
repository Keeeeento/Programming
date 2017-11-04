package problemsOf2ndPeriod;

import mathlib.GaussSeidel;
import mathlib.Jacobi;
import mathlib.Matrix;
import mathlib.StationaryIterativeMethod;
import mathlib.SuccessiveOverRelaxation;
import mathlib.Vector;
import texlib.TeX;

public class Problem5 extends SuccessiveOverRelaxation {

	public static void main(String[] args) {
		int n = 10;
		//		StationaryIterativeMethod problem5 = new StationaryIterativeMethod(1e-08, 2, 500);
		StationaryIterativeMethod.epsilon = 1e-08;
		StationaryIterativeMethod.norm = 2;
		StationaryIterativeMethod.maxIter = (int) 5e+02;
		StationaryIterativeMethod.x0 = Vector.allNumber(n, 1.0);
		SuccessiveOverRelaxation.omega = 1.3;

		Matrix a;
		Vector b = Vector.allNumber(n, 1.0);

		// (1)
		TeX.section("Jacobi法");
		TeX.beginTable(new String[] { "a", "反復回数N", "第一成分x_1" });
		for (int alpha = 2; alpha <= 8; alpha++) {
			a = Matrix.symmetricBand(n, alpha, -1.0, -1.0);
			int iteration = Jacobi.getIter(a, b);
			double x1 = (iteration == 0) ? 0 : Jacobi.solve(a, b).getData()[0];
			System.out.printf("         %d & %d & %.5e \\\\ \n", alpha, iteration, x1);
		}
		TeX.endTable();

		// (2)
		TeX.section("GaussSeidel法");
		TeX.beginTable(new String[] { "a", "反復回数N", "第一成分x_1" });
		for (int alpha = 2; alpha <= 8; alpha++) {
			a = Matrix.symmetricBand(n, alpha, -1.0, -1.0);
			int iteration = GaussSeidel.getIter(a, b);
			double x1 = (iteration == 0) ? 0 : GaussSeidel.solve(a, b).getData()[0];
			System.out.printf("         %d & %d & %.5e \\\\ \n", alpha, iteration, x1);
		}
		TeX.endTable();

		// (3)
		TeX.section("SOR法");
		TeX.beginTable(new String[] { "a", "反復回数N", "第一成分x_1" });
		for (int alpha = 2; alpha <= 8; alpha++) {
			a = Matrix.symmetricBand(n, alpha, -1.0, -1.0);
			int iteration = SuccessiveOverRelaxation.getIter(a, b);
			double x1 = (iteration == 0) ? 0 : SuccessiveOverRelaxation.solve(a, b).getData()[0];
			System.out.printf("         %d & %d & %.5e \\\\ \n", alpha, iteration, x1);
		}
		TeX.endTable();

	}

}
