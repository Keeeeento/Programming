package midTermTestOf2ndPeriod;

import mathlib.GaussSeidel;
import mathlib.Jacobi;
import mathlib.Matrix;
import mathlib.SpectralRadius;
import mathlib.SuccessiveOverRelaxation;
import mathlib.Vector;

public final class SOR extends SuccessiveOverRelaxation {

	public static void main(String[] args) {

		n = 7;
		epsilon = 1e-08;
		normNumber = 2.0;
		maxIteration = (int) 2e+02;
		isAbsolute = true;

		double alpha = 3; // 対角成分
		a = new Matrix(n);
		b = new Vector(n);
		x0 = new Vector(n);
		a.symmetricBandForExam(alpha, -1.0);
		b.allNumber(1.0);
		x0.allNumber(1.0);

		a.print();

		omega = a.getOptimalOmega();

		System.out.println("(1)");
		System.out.printf("Iter of Jacobi : %d%n", Jacobi.getIteration());
		System.out.printf("Iter of GaussSeidel : %d%n", GaussSeidel.getIteration());
		System.out.printf("Iter of SOR : %d%n", SuccessiveOverRelaxation.getIteration());

		GaussSeidel.solve().printf("x");

		double rho = SpectralRadius.getSpectralRadiusByRayleigh(a.getJacobiMatrix(), x0);

		System.out.println("ρ(B) = " + rho); // √3/2になるはず
		System.out.println("ω_opt = " + a.getOptimalOmega()); // 4/3になるはず

		System.out.println("(2)");
		double m = 50;
		System.out.println("omega, iter");
		for (int i = 1; i < m; i++) {
			omega = (double) i * 2.0 / m;
			//			System.out.println(SuccessiveOverRelaxation.getIteration());
			System.out.printf("%.2f, %d%n ", omega, SuccessiveOverRelaxation.getIteration());
			//			System.out.printf("%d %.2f%n", SuccessiveOverRelaxation.getIteration(), omega);

		}

		System.out.println("i,omega,iter");
		for (int i = 1; i < m; i++) {
			omega = (double) i * 2.0 / m;
			//			System.out.println(SuccessiveOverRelaxation.getIteration());
			System.out.printf("%d, %.2f, %d%n ", i, omega, SuccessiveOverRelaxation.getIteration());
			//			System.out.printf("%d %.2f%n", SuccessiveOverRelaxation.getIteration(), omega);

		}

		omega = a.getOptimalOmega();
		System.out.printf("%.2f, %d%n ", omega, SuccessiveOverRelaxation.getIteration());

	}

}