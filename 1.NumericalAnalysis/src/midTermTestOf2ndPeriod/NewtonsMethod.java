package midTermTestOf2ndPeriod;

public class NewtonsMethod {

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
		solveAndPrintErrorBy("Newton");
		//		solveAndPrintConstantBy("Newton", 2);
		solveAndPrintConverganceNumberBy("Newton");

		// (2) Secant Method
		System.out.println("--Secant Method--");
		solveAndPrintErrorBy("Secant");
		//		double goldenRatio = (1.0 + Math.sqrt(5.0)) / 2.0;
		//		solveAndPrintConstantBy("Secant", goldenRatio);
		solveAndPrintConverganceNumberBy("Secant");

		// (3) Parallel Chord
		System.out.println("--Parallel Chord--");
		solveAndPrintErrorBy("ParallelChord");
		solveAndPrintConverganceNumberBy("ParallelChord");

		System.out.printf("F(a) = %.3e", F(5.277888600464e-01));
		for (int i = 0; i < 100; i++) {
			System.out.println(F(i * 1.0 / 10));
		}
	}

	// 関数f(x)
	public static double f(double x) {
		return -1.0 / (x * x) + 1.0 / x + Math.exp(x);
	}

	public static double F(double x) {
		return 1.0 / x + Math.log10(x) + Math.exp(x);
	}

	// 導関数df(x)
	public static double df(double x) {
		return 2.0 / (x * x * x) - 1.0 / (x * x) + Math.exp(x);
	}

	// 反復式
	// newton,pcでは第三引数にはダミーのdouble型を入力
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

			xApproximate = x;
			break;
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

			xApproximate = x;
			break;
		}
	}

	// 誤差の表示
	public static void printErrorBy(String methodName) {
		System.out.printf("xApproximate = %.12e\n", xApproximate);
		double xNew = x0;
		double x = x0;
		double xOld = x1;
		double error;
		switch (methodName) {
		case "Secant":
			for (int i = 1; i < iter; i++) {
				xNew = iterationOf(methodName, x, xOld);
				error = Math.abs(xNew - xApproximate);
				System.out.printf("%d, %.3e\n", i, error);
				System.out.printf("x = %.12e\n", xNew);
				xOld = x;
				x = xNew;
			}
			xApproximate = 0; // 近似解の初期化
			System.out.println();
			break;
		default:
			for (int i = 1; i <= iter; i++) {
				x = iterationOf(methodName, x, 0);
				error = Math.abs(x - xApproximate);
				System.out.printf("%d, %.3e\n", i, error);

			}
			xApproximate = 0; // 近似解の初期化
			System.out.println();
			break;
		}
	}

	// 定数Cの表示
	// p:収束次数convergence
	public static void printConstantBy(String methodName, double p) {
		//		System.out.printf("xApproximate = %.16e\n", xApproximate);
		double xNew = x0;
		double x = x0;
		double xOld = x1;
		double error, constant;
		double errorOld = 0.0;
		switch (methodName) {
		case "Secant":
			for (int i = 0; i < iter; i++) {
				xNew = iterationOf(methodName, x, xOld);
				error = Math.abs(x - xApproximate);
				constant = Math.abs(error / Math.pow(errorOld, p));
				System.out.printf("%d & %.5e \\\\ \n", i, constant);
				errorOld = error;
				xOld = x;
				x = xNew;
			}
			xApproximate = 0; // 近似解の初期化
			System.out.println();
			break;
		default:
			for (int i = 0; i < iter; i++) {
				x = iterationOf(methodName, x, 0);
				error = Math.abs(x - xApproximate);
				constant = Math.abs(error / Math.pow(errorOld, p));
				System.out.printf("%d & %.5e \\\\ \n", i, constant);
				errorOld = error;
			}
			xApproximate = 0; // 近似解の初期化
			System.out.println();
			break;
		}
	}

	// 収束次数pの表示
	public static void printConvergenceNumberBy(String methodName) {
		double xNew = x0;
		double x = x0;
		double xOld = x1;
		double error;
		double errorOld = 0.0;
		double p; // 収束次数
		switch (methodName) {
		case "Secant":
			for (int i = 0; i < iter; i++) {
				xNew = iterationOf(methodName, x, xOld);
				error = Math.abs(x - xApproximate);
				p = Math.log10(Math.abs(error)) / Math.log10(Math.abs(errorOld));
				System.out.printf("%d & %.3e \\\\ \n", i, p);
				errorOld = error;
				xOld = x;
				x = xNew;
			}
			xApproximate = 0; // 近似解の初期化
			System.out.println();
			break;
		default:
			for (int i = 0; i < iter; i++) {
				x = iterationOf(methodName, x, 0);
				error = Math.abs(x - xApproximate);
				p = Math.log10(Math.abs(error)) / Math.log10(Math.abs(errorOld));
				System.out.printf("%d & %.3e \\\\ \n", i, p);
				errorOld = error;
			}
			xApproximate = 0; // 近似解の初期化
			System.out.println();
			break;
		}
	}

	// 近似解と誤差を出力
	public static void solveAndPrintErrorBy(String methodName) {
		getIterAndXBy(methodName);
		printErrorBy(methodName);
	}

	// 収束次数を入力して値がコンスタントになることを確認
	public static void solveAndPrintConstantBy(String methodName, double p) {
		getIterAndXBy(methodName);
		printConstantBy(methodName, p);
	}

	// 収束次数を入力して値がコンスタントになることを確認
	public static void solveAndPrintConverganceNumberBy(String methodName) {
		getIterAndXBy(methodName);
		printConvergenceNumberBy(methodName);
	}
}
