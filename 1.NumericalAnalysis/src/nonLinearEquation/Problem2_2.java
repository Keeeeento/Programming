package nonLinearEquation;

public class Problem2_2 {
	// 実習課題2

	static double x;
	static double x0 = 2.5; // 初期値
	static double x1 = 3.0; // secant法の初期値
	static double xApproximate; // 近似解
	final static double EPSILON = 1.0e-12; // 許容誤差
	static int maxIter = 200; // 最大反復回数
	static int iter;

	public static void main(String[] args) {

		System.out.println("反復回数,絶対誤差");

		// (1) Newton's Method
		System.out.println("--Newton's Method--");
		solveBy("Newton", x0);

		// (2) Secant Method
		System.out.println("--Secant Method--");
		solveBy("Secant", x0, x1);

		// (3) Parallel Chord
		System.out.println("--Parallel Chord--");
		solveBy("ParallelChord", x0);

	}

	// 関数f(x)
	public static double f(double x) {
		return Math.exp(x - 1.0) - x;
	}

	// 導関数df(x)
	public static double df(double x) {
		return Math.exp(x - 1.0) - 1.0;
	}

	// 反復式
	public static double iterationOf(String methodName, double x) {
		switch (methodName) {
		case "Newton":
			return x - f(x) / df(x);
		case "ParallelChord":
			return x - f(x) / df(x0);
		default:
			System.out.println("Error:UndefinedMethod");
			return 0.0;
		}
	}

	public static double iterationOf(String methodName, double x, double xOld) {
		switch (methodName) {
		case "Secant":
			return x - f(x) * (x - xOld) / (f(x) - f(xOld));
		default:
			System.out.println("Error:UndefinedMethod");
			return 0.0;
		}
	}

	// 反復回数の測定、近似解を代入
	public static void getIterAndXBy(String methodName, double x0) {
		x = x0;
		for (iter = 0; iter < maxIter; iter++) {
			x = iterationOf(methodName, x);
			if (Math.abs(f(x)) < EPSILON) {
				break;
			}
		}
		if (iter == maxIter) {
			System.out.println("収束しません");
		}
		xApproximate = x;
	}

	public static void getIterAndXBy(String methodName, double x0, double x1) {
		double xNew = x0;
		double x = x0;
		double xOld = x1;
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
		xApproximate = xNew;

	}

	// 誤差の表示
	public static void printErrorBy(String methodName, double x0) {
		System.out.printf("xApproximate = %.16e\n", xApproximate);
		x = x0;
		for (int i = 1; i <= iter; i++) {
			x = iterationOf(methodName, x);
			double error = Math.abs(x - xApproximate);
			System.out.printf("%d, %.5e\n", i, error);

		}
		xApproximate = 0; // 近似解の初期化
		System.out.println();
	}

	public static void printErrorBy(String methodName, double x0, double x1) {
		System.out.printf("xApproximate = %.16e\n", xApproximate);
		double xNew = x0;
		double x = x0;
		double xOld = x1;
		double error;
		for (int i = 1; i <= iter; i++) {
			xNew = iterationOf(methodName, x, xOld);
			error = Math.abs(xNew - xApproximate);
			System.out.printf("%d, %.5e\n", i, error);
			xOld = x;
			x = xNew;
		}
		xApproximate = 0; // 近似解の初期化
		System.out.println();

	}

	// 定数Cの表示
	// p:収束次数convergence
	public static void printConstantBy(String methodName, double x0, double p) {
		System.out.printf("xApproximate = %.16e\n", xApproximate);
		x = x0;
		double error, constant;
		double errorOld = 0.0;

		for (int i = 1; i <= iter; i++) {
			x = iterationOf(methodName, x);
			error = Math.abs(x - xApproximate);
			constant = Math.abs(error / Math.pow(errorOld, p));
			System.out.printf("%d, %.5e, %.5e\n", i, error, constant);
			errorOld = error;
		}
		System.out.println();
	}

	public static void printConstantBy(String methodName, double x0, double x1, double p) {
		System.out.printf("xApproximate = %.16e\n", xApproximate);
		double xNew = x0;
		double x = x0;
		double xOld = x1;
		double error, constant;
		double errorOld = 0.0;

		for (int i = 1; i <= iter; i++) {
			x = iterationOf(methodName, x, xOld);
			error = Math.abs(x - xApproximate);
			constant = Math.abs(error / Math.pow(errorOld, p));
			System.out.printf("%d, %.5e, %.5e\n", i, error, constant);
			errorOld = error;
			xOld = x;
			x = xNew;
		}
		System.out.println();
	}

	public static void solveBy(String methodName, double x0) {
		switch (methodName) {
		case "Newton":
			getIterAndXBy(methodName, x0);
			printErrorBy(methodName, x0);
		case "ParallelChord":
			getIterAndXBy(methodName, x0);
			printErrorBy(methodName, x0);
		}
	}

	public static void solveBy(String methodName, double x0, double x1) {
		getIterAndXBy(methodName, x0, x1);
		printErrorBy(methodName, x0, x1);
	}

}