package nonLinearEquation;

import mathlib.GaussianElimination;
import mathlib.Matrix;
import mathlib.Vector;

public class Problem3 {
	static int n = 2; // 次元数
	static double epsilon = 1e-10; // 許容誤差
	static int iter; // 反復回数
	static int maxIter = 50; // 最大反復回数
	static Vector xApproximate = new Vector(n); // 近似解

	public static void main(String[] args) {
		solveByPivotGaussianElimination().print();
	}

	// xの初期化
	public static Vector x(int n) {
		Vector x = new Vector(n);
		for (int i = 0; i < n - 1; i++) {
			x.getData()[i] = -1.0;
		}
		x.getData()[n - 1] = 1.0;
		return x;
	}

	// 関数ベクトルf
	public static Vector f(Vector x) {

		Vector f = new Vector(n);
		double power = 2.0;

		// f_0 = x_0^2 + x_1^2 + … + x_{n-1}^2 - 1
		for (int j = 0; j < n; j++) {
			f.getData()[0] += Math.pow(x.getData()[j], power);
		}

		// f_i = x_0^2  + … + sin(x_{i-1}) + … + x_{n-1}^2
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == i - 1) {
					f.getData()[i] += Math.sin(x.getData()[j]);
				} else {
					f.getData()[i] += Math.pow(x.getData()[j], power);
				}
			}
		}
		return f;
	}

	// Jacobian
	public static Matrix jacobian(Vector x) {

		int n = x.getN();
		Matrix jacobian = new Matrix(n);
		double power = 2.0;

		// 各成分の格納 J_{ij} = df_{ij}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == i - 1) {
					jacobian.getData()[i][j] = Math.cos(x.getData()[j]);
				} else {
					jacobian.getData()[i][j] = power * Math.pow(x.getData()[j], power - 1.0);
				}
			}
		}

		return jacobian;
	}

	// pivot gaussian elimination
	public static Vector solveByPivotGaussianElimination() {

		Vector x = x(n);
		Vector xOld = new Vector(n);
		Vector y;
		Vector f;
		Matrix jacobian;

		Vector error;
		Vector errorOld = new Vector(n); // なぜ使われてないと出るのか…

		for (iter = 0; iter < maxIter; iter++) {
			f = f(x);
			jacobian = jacobian(x);
			y = GaussianElimination.pivotSolve(jacobian, f.scalarMultiply(-1)); // J * y = -f
			x = x.add(y); // x = x + y
			error = x.subtract(xOld);
			if (error.getNorm("inf") < epsilon) {
				break;
			}
			errorOld = error.copy();
			xOld = x.copy();
		}
		return xApproximate;
	}

	// 反復回数を返す
	public static int getIter() {
		return iter;
	}

	// 近似解を返す
	public static Vector getXApproximate() {
		return xApproximate;
	}

}
