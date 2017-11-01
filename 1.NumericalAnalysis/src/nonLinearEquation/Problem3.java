package nonLinearEquation;

import mathlib.GaussianElimination;
import mathlib.Matrix;
import mathlib.Vector;

public class Problem3 {
	static int n; // 次元数

	final static double epsilon = 1e-10; // 許容誤差
	final static int maxIter = (int) 5e+10; // 最大反復回数

	// main method
	public static void main(String[] args) {
		for (n = 2; n <= 3; n++) {
			System.out.printf("(%d)\n", n - 1);
			System.out.printf("let n = %d\n", n);
			solveAndPrintDetail();
		}
	}

	// xの初期化
	public static Vector x() {
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
		f.getData()[0] = -1.0;
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

		int iter; // 反復回数
		Vector x = x();
		Vector xOld = new Vector(n);
		Vector y;
		Vector f;
		Matrix jacobian;
		Vector error;
		//		Vector errorOld = new Vector(n); // なぜ使われてないと出るのか…

		for (iter = 0; iter < maxIter; iter++) {
			f = f(x);
			jacobian = jacobian(x);
			y = GaussianElimination.pivotSolve(jacobian, f.scalarMultiply(-1)); // J * y = -f
			x = x.add(y); // x = x + y
			error = x.subtract(xOld); // error = x - xOld
			if (error.getNorm("inf") < epsilon) {
				break;
			}
			xOld = x.copy();
		}
		if (iter < maxIter) {
			return x;
		} else {
			System.out.println("最大反復回数を超えています");
			return Vector.allNumber(n, 0);
		}
	}

	// 反復回数を返す
	public static int getIter() {
		int iter; // 反復回数
		Vector x = x();
		Vector xOld = new Vector(n);
		Vector y;
		Vector f;
		Matrix jacobian;
		Vector error;
		//		Vector errorOld = new Vector(n); // なぜ使われてないと出るのか…

		for (iter = 0; iter < maxIter; iter++) {
			f = f(x);
			jacobian = jacobian(x);
			y = GaussianElimination.pivotSolve(jacobian, f.scalarMultiply(-1)); // J * y = -f
			x = x.add(y); // x = x + y
			error = x.subtract(xOld); // error = x - xOld
			if (error.getNorm("inf") < epsilon) {
				break;
			}
			xOld = x.copy();
		}
		return iter;
	}

	// 近似解を返す
	public static Vector getApproximateSolution() {

		int iter; // 反復回数
		Vector x = x();
		Vector xOld = new Vector(n);
		Vector y;
		Vector f;
		Matrix jacobian;
		Vector error;
		//		Vector errorOld = new Vector(n); // なぜ使われてないと出るのか…

		for (iter = 0; iter < maxIter; iter++) {
			f = f(x);
			jacobian = jacobian(x);
			y = GaussianElimination.pivotSolve(jacobian, f.scalarMultiply(-1)); // J * y = -f
			x = x.add(y); // x = x + y
			error = x.subtract(xOld); // error = x - xOld
			if (error.getNorm("inf") < epsilon) {
				break;
			}
			xOld = x.copy();
		}
		return x;

	}

	// 解と反復回数の表示
	public static void solveAndPrintDetail() {
		//		Vector x = x();
		//		x.print("x");
		//		Matrix jacobian = jacobian(x);
		//		jacobian.print("J");
		solveByPivotGaussianElimination().printf("x");
		int iter = getIter();
		System.out.printf("iter = %d\n", iter);
		double p = getOrderOfConvergence();
		System.out.printf("p = %.10e\n", p);
	}

	// 収束次数
	public static double getOrderOfConvergence() {

		int iter; // 反復回数
		Vector x = x();
		Vector xOld = new Vector(n);
		Vector xApproximate = getApproximateSolution();
		Vector y;
		Vector f;
		Matrix jacobian;
		double p = 0.0;

		for (iter = 0; iter < getIter(); iter++) {
			f = f(x);
			jacobian = jacobian(x);
			y = GaussianElimination.pivotSolve(jacobian, f.scalarMultiply(-1)); // J * y = -f
			x = x.add(y); // x = x + y
			p = Math.log10(x.subtract(xApproximate).getNorm("inf"))
					/ Math.log10(xOld.subtract(xApproximate).getNorm("inf"));
			xOld = x.copy();

		}
		return p;
	}

}
