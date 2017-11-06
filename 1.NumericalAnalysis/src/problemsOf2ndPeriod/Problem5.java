package problemsOf2ndPeriod;

import mathlib.GaussSeidel;
import mathlib.Jacobi;
import mathlib.Matrix;
import mathlib.StationaryIterativeMethod;
import mathlib.SuccessiveOverRelaxation;
import mathlib.Vector;
import texlib.TeX;

public final class Problem5 extends SuccessiveOverRelaxation {

	public static void main(String[] args) {

		int n = 10;

		double epsilon = 1e-08;
		double norm = 2.0;
		int max_iteration = (int) 5e+02;
		Vector x0 = Vector.allNumber(n, 1.0);

		StationaryIterativeMethod conditions = new StationaryIterativeMethod(epsilon, norm, max_iteration, x0);

		Jacobi jacobi = new Jacobi(conditions);
		GaussSeidel gauss_seidel = new GaussSeidel(conditions);

		double omega = 1.3;
		SuccessiveOverRelaxation sor = new SuccessiveOverRelaxation(conditions, omega);

		Matrix a;
		Vector b = Vector.allNumber(n, 1.0);

		TeX.beginDocument();

		// (1)
		TeX.section("Jacobi法");
		TeX.beginTable(new String[] { "a", "反復回数N", "第一成分x_1" });
		for (int alpha = 2; alpha <= 8; alpha++) {
			a = Matrix.symmetricBand(n, alpha, -1.0, -1.0);
			int iteration = jacobi.getIter(a, b);
			double x1 = (iteration == 0) ? 0 : jacobi.solve(a, b).getData()[0];
			printTable(alpha, iteration, x1);
		}
		TeX.endTable();

		// (2)
		TeX.section("GaussSeidel法");
		TeX.beginTable(new String[] { "a", "反復回数N", "第一成分x_1" });
		for (int alpha = 2; alpha <= 8; alpha++) {
			a = Matrix.symmetricBand(n, alpha, -1.0, -1.0);
			int iteration = gauss_seidel.getIter(a, b);
			double x1 = (iteration == 0) ? 0 : gauss_seidel.solve(a, b).getData()[0];
			printTable(alpha, iteration, x1);
		}
		TeX.endTable();

		// (3)
		TeX.section("SOR法(緩和係数$\\omega = 1.3$)");
		TeX.beginTable(new String[] { "a", "反復回数N", "第一成分x_1" });
		for (int alpha = 2; alpha <= 8; alpha++) {
			a = Matrix.symmetricBand(n, alpha, -1.0, -1.0);
			int iteration = sor.getIter(a, b);
			double x1 = (iteration == 0) ? 0 : sor.solve(a, b).getData()[0];
			printTable(alpha, iteration, x1);
		}
		TeX.endTable();

		TeX.endDocument();

	}

	public static void printTable(int alpha, int iteration, double x1) {
		if (iteration == 0) {
			System.out.printf("         $%d$ & (収束しません) & - \\\\ \n", alpha);
		} else {
			System.out.printf("         $%d$ & $%d$ & $%.5e$ \\\\ \n", alpha, iteration, x1);
		}
	}

}
