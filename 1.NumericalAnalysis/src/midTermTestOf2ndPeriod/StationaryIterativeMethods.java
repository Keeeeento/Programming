package midTermTestOf2ndPeriod;

import mathlib.GaussSeidel;
import mathlib.Jacobi;
import mathlib.Matrix;
import mathlib.SuccessiveOverRelaxation;
import mathlib.Vector;
import texlib.TeX;

public class StationaryIterativeMethods extends SuccessiveOverRelaxation {

	public static void main(String[] args) {

		n = 10;

		epsilon = 1e-08;
		normNumber = 2.0;
		maxIteration = (int) 5e+02;
		x0 = Vector.allNumber(n, 1.0);
		omega = 1.3;

		b = Vector.allNumber(n, 1.0);

		TeX.beginDocument();

		// (1)
		TeX.section("Jacobi法");
		TeX.beginTable(new String[] { "a", "反復回数N", "第一成分x_1" });
		for (int alpha = 2; alpha <= 8; alpha++) {
			a = Matrix.symmetricBand(n, alpha, -1.0, -1.0);
			int iteration = Jacobi.getIteration();
			double x1 = (iteration == 0) ? 0 : Jacobi.solve().getData()[0];
			printTable(alpha, iteration, x1);
		}
		TeX.endTable();

		// (2)
		TeX.section("GaussSeidel法");
		TeX.beginTable(new String[] { "a", "反復回数N", "第一成分x_1" });
		for (int alpha = 2; alpha <= 8; alpha++) {
			a = Matrix.symmetricBand(n, alpha, -1.0, -1.0);
			int iteration = GaussSeidel.getIteration();
			double x1 = (iteration == 0) ? 0 : GaussSeidel.solve().getData()[0];
			printTable(alpha, iteration, x1);
		}
		TeX.endTable();

		// (3)
		TeX.section("SOR法(緩和係数$\\omega = 1.3$)");
		TeX.beginTable(new String[] { "a", "反復回数N", "第一成分x_1" });
		for (int alpha = 2; alpha <= 8; alpha++) {
			a = Matrix.symmetricBand(n, alpha, -1.0, -1.0);
			int iteration = SuccessiveOverRelaxation.getIteration();
			double x1 = (iteration == 0) ? 0 : SuccessiveOverRelaxation.solve().getData()[0];
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
