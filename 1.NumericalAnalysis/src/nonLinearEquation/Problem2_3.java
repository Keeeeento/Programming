package nonLinearEquation;

public class Problem2_3 {
	// 実習課題2自由課題

	static double x;
	static int k = 5;
	static double a = 100;
	final static double x0 = 3.0; // 初期値
	final static double x1 = 4.0; // secant法の初期値
	static double xApproximate; // 近似解
	final static double EPSILON = 1e-12; // 許容誤差
	static int maxIter = 200; // 最大反復回数
	static int iter;

	public static void main(String[] args) {

		System.out.println("反復回数,絶対誤差");

		// (1) Newton's Method
		System.out.println("--Newton's Method--");
		solveBy("Newton");

		// (2) Secant Method
		System.out.println("--Secant Method--");
		solveBy("Secant");

		// (3) Parallel Chord
		System.out.println("--Parallel Chord--");
		solveBy("ParallelChord");

	}

	// 関数 f(x) = x^k - a
	public static double f(double x) {
		return Math.pow(x, k) - a;
	}

	// 導関数 df(x) = kx^{k-1}
	public static double df(double x) {
		return k * Math.pow(x, k - 1);
	}

	// 反復式
	//	public static double iterationOf(String methodName, double x) {
	//		switch (methodName) {
	//		case "Newton":
	//			return x - f(x) / df(x);
	//		case "ParallelChord":
	//			return x - f(x) / df(x0);
	//		default:
	//			System.out.println("Error:UndefinedMethod");
	//			return 0.0;
	//		}
	//	}

	// 反復式
	public static double iterationOf(String methodName, double x, double xOld) {
		switch (methodName) {
		case "Newton":
			return x - f(x) / df(x);
		case "ParallelChord":
			return x - f(x) / df(x0);
		case "Secant":
			return x - f(x) * (x - xOld) / (f(x) - f(xOld));
		default:
			System.out.println("Error:UndefinedMethod");
			return 0.0;
		}
	}

	// 反復回数の測定、近似解を代入
	public static void getIterAndXBy(String methodName) {
		double xNew = x0;
		double x = x0;
		double xOld = x1;
		switch (methodName) {
		case "Secant":
			for (iter = 0; iter < maxIter; iter++) {
				xNew = iterationOf(methodName, x, xOld);
				if (Math.abs(f(x)) < EPSILON) {
					break;
				} else {
					xOld = x;
					x = xNew;
				}
			}
			if (iter == maxIter) {
				System.out.println("収束しません");
			}
		default:
			for (iter = 0; iter < maxIter; iter++) {
				x = iterationOf(methodName, x, 0);
				if (Math.abs(f(x)) < EPSILON) {
					break;
				}
			}
			if (iter == maxIter) {
				System.out.println("収束しません");
			}
		}
		xApproximate = x;
	}

	// 誤差の表示
	public static void printErrorBy(String methodName) {
		System.out.printf("xApproximate = %.16e\n", xApproximate);
		double xNew = x0;
		double x = x0;
		double xOld = x1;
		double error;
		switch (methodName) {
		case "Secant":
			for (int i = 1; i <= iter; i++) {
				xNew = iterationOf(methodName, x, xOld);
				error = Math.abs(xNew - xApproximate);
				System.out.printf("%d, %.5e\n", i, error);
				xOld = x;
				x = xNew;
			}
		default:
			for (int i = 1; i <= iter; i++) {
				x = iterationOf(methodName, x, 0);
				error = Math.abs(x - xApproximate);
				System.out.printf("%d, %.5e\n", i, error);

			}
		}
		xApproximate = 0; // 近似解の初期化
		System.out.println();
	}

	// 定数Cの表示
	// p:収束次数convergence
	public static void printConstantBy(String methodName, double p) {
		System.out.printf("xApproximate = %.16e\n", xApproximate);
		double xNew = x0;
		double x = x0;
		double xOld = x1;
		double error, constant;
		double errorOld = 0.0;
		switch (methodName) {
		case "Secant":
			for (int i = 1; i <= iter; i++) {
				x = iterationOf(methodName, x, xOld);
				error = Math.abs(x - xApproximate);
				constant = Math.abs(error / Math.pow(errorOld, p));
				System.out.printf("%d, %.5e, %.5e\n", i, error, constant);
				errorOld = error;
				xOld = x;
				x = xNew;
			}
		default:
			for (int i = 1; i <= iter; i++) {
				x = iterationOf(methodName, x, 0);
				error = Math.abs(x - xApproximate);
				constant = Math.abs(error / Math.pow(errorOld, p));
				System.out.printf("%d, %.5e, %.5e\n", i, error, constant);
				errorOld = error;
			}
		}
		System.out.println();
	}

	public static void solveBy(String methodName) {
		getIterAndXBy(methodName);
		printErrorBy(methodName);

	}
	//
	//	public static void solveBy(String methodName, double x0, double x1) {
	//		getIterAndXBy(methodName, x0, x1);
	//		printErrorBy(methodName, x0, x1);
	//	}

}
