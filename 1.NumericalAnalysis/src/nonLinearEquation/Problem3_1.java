package nonLinearEquation;

import mathlib.GaussianElimination;
import mathlib.Matrix;
import mathlib.Vector;

public class Problem3_1 {

	static int n = 2; // 次元数
	static double epsilon = 1e-10; // 許容誤差
	static int maxIter = 50; // 最大反復回数
	static Vector x = new Vector(n);
	static Vector y = new Vector(n);
	static Vector f = new Vector(n);
	static Matrix jacobian = new Matrix(n);

	public static void main(String[] args) {
		solveByPivotGaussianElimination();
		x.print("x");
	}

	// 関数f(x)
	public static Vector f(Vector x) {
		int n = x.getData().length;
		Vector f = new Vector(n);
		f.getData()[0] = x.getData()[0] * x.getData()[0] + x.getData()[1] * x.getData()[1] - 1;
		f.getData()[1] = Math.sin(x.getData()[0]) + x.getData()[1] * x.getData()[1];
		return f;
	}

	// 導関数df(x)
	public static double df(int i, int j, Vector x) {
		switch (i) {
		case 0:
			return 2 * x.getData()[j];
		case 1:
			switch (j) {
			case 0:
				return Math.cos(x.getData()[j]);
			case 1:
				return 2 * x.getData()[j];
			default:
				System.out.printf("ベクトル%dのj列目が存在しません\n", j);
				return 0;
			}
		default:
			System.out.printf("ベクトル%dのi行目が存在しません\n", i);
			return 0;
		}
	}

	// 係数行列のヤコビアン
	public static Matrix jacobian(Vector x) {
		int n = x.getN();
		Matrix Jacobian = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Jacobian.getData()[i][j] = df(i, j, x);
			}
		}
		return Jacobian;
	}

	// pivot gaussian elimination
	public static void solveByPivotGaussianElimination() {
		// ベクトルxの初期化
		for (int i = 0; i < n; i++) {
			x.getData()[i] = 1.0;
		}

		for (int i = 0; i < maxIter; i++) {
			f = f(x);
			jacobian = jacobian(x);
			y = GaussianElimination.pivotSolve(jacobian, f.scalarMultiply(-1)); // J * y = -f
			x = x.add(y); // x = x + y
			if (f.getNorm(0) < epsilon) {
				break;
			}
		}

	}

}