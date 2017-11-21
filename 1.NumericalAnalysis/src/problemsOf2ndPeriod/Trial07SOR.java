package problemsOf2ndPeriod;

import mathlib.GaussSeidel;
import mathlib.Jacobi;
import mathlib.Matrix;
import mathlib.SpectralRadius;
import mathlib.SuccessiveOverRelaxation;
import mathlib.Vector;

public final class Trial07SOR extends SuccessiveOverRelaxation {

	public static void main(String[] args) {

		n = 5;
		epsilon = 1e-10;
		normNumber = 2.0;
		maxIteration = (int) 1e+03;
		isAbsolute = true;

		double alpha = 2; // 対角成分
		a = new Matrix(n);
		b = new Vector(n);
		x0 = new Vector(n);
		a.symmetricBand(alpha, -1.0);
		b.allNumber(1.0);
		x0.allNumber(1.0);

		omega = a.getOptimalOmega();

		System.out.println("(1)");
		System.out.printf("Iter of Jacobi : %d%n", Jacobi.getIteration());
		System.out.printf("Iter of GaussSeidel : %d%n", GaussSeidel.getIteration());
		System.out.printf("Iter of SOR : %d%n", SuccessiveOverRelaxation.getIteration());

		SuccessiveOverRelaxation.solve().print();

		double rho = SpectralRadius.getSpectralRadiusByRayleigh(a.getJacobiMatrix(), x0);

		System.out.println("ρ(B) = " + rho); // √3/2になるはず
		System.out.println("ω_opt = " + a.getOptimalOmega()); // 4/3になるはず

		System.out.println("(2)");
		double m = 100.0;
		for (int i = 1; i < m; i++) {
			omega = i * 2.0 / m;
			System.out.println(SuccessiveOverRelaxation.getIteration());
			//			System.out.printf("iter : %d%n", SuccessiveOverRelaxation.getIteration());

		}

	}

}