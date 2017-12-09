package mathlib;

public class PowerMethod {
	public static double solve(Matrix a) {
		int n = a.getData().length;
		double lambda = 0.0;
		Vector xOld = new Vector(n);
		Vector x = new Vector(n);

		xOld.getData()[0] = 1.0;// 初期ベクトル x = {1,0,0,…,0}

		for (int k = 0; k < 100000; k++) {
			x = a.multiply(xOld);
			lambda = Vector.innerProduct(xOld, x);
			xOld = x.scalarMultiply(1.0 / x.getNorm(2));
		}
		return lambda;
	}

	//	public static double spectral_radious(double [][] a) { // スペクトル半径()
	//		int  n =a.length;
	//		double lambda = 0.0;
	//		double [] x = new double[n];
	//		double [] x_old = new double[n];
	//
	//	}

}
