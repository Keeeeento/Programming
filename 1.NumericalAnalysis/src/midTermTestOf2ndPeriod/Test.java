package midTermTestOf2ndPeriod;

import mathlib.LinearCondition;
import mathlib.Matrix;
import mathlib.SpectralRadius;
import mathlib.Vector;

public class Test extends LinearCondition {
	public static void main(String[] args) {

		n = 5;
		a = Matrix.hilbert(n);
		x0 = Vector.allNumber(n, 1.0);
		double rho = SpectralRadius.getSpectralRadiusByRayleigh(a, x0);
		System.out.println(rho);

	}

}
