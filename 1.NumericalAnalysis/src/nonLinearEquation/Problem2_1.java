package nonLinearEquation;

public class Problem2_1 {
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
		newtonsMethod(x0);

		// (2) Secant Method
		System.out.println("--Secant Method--");
		secantMethod(x0, x1);

		// (3) Parallel Chord
		System.out.println("--Parallel Chord--");
		parallelChord(x0);

	}

	// 関数f(x)
	public static double f(double x) {
		return Math.exp(x) - 3.0 * x;
	}

	// 導関数df(x)
	public static double df(double x) {
		return Math.exp(x) - 3.0;
	}

	// Newton法による反復回数の測定、近似解を代入
	public static void getIterAndXByNewton(double x0) {
		x = x0;
		for (iter = 0; iter < maxIter; iter++) {
			x -= f(x) / df(x);
			if (Math.abs(f(x)) < EPSILON) {
				break;
			}
		}
		if (iter == maxIter) {
			System.out.println("収束しません");
		}
		xApproximate = x;
	}

	// Newton法による誤差の表示
	public static void printErrorByNewton(double x0) {
		System.out.printf("xApproximate = %.16e\n", xApproximate);
		x = x0;
		for (int i = 1; i <= iter; i++) {
			x -= f(x) / df(x);
			double error = Math.abs(x - xApproximate);
			System.out.printf("%d, %.5e\n", i, error);

		}
		xApproximate = 0; // 近似解の初期化
		System.out.println();
	}

	public static void newtonsMethod(double x0) {
		getIterAndXByNewton(x0);
		printErrorByNewton(x0);
	}

	// Secant法による反復回数の測定、近似解を代入
	public static void getIterAndXBySecant(double x0, double x1) {
		double xNew = x0;
		double x = x0;
		double xOld = x1;
		for (iter = 0; iter < maxIter; iter++) {
			xNew = x - f(x) * (x - xOld) / (f(x) - f(xOld));
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

	// Secant法による誤差の表示
	public static void printErrorBySecant(double x0, double x1) {
		System.out.printf("xApproximate = %.16e\n", xApproximate);
		double xNew = x0;
		double x = x0;
		double xOld = x1;
		double error;
		for (int i = 1; i <= iter; i++) {
			xNew = x - f(x) * (x - xOld) / (f(x) - f(xOld));
			error = Math.abs(xNew - xApproximate);
			System.out.printf("%d, %.5e\n", i, error);
			xOld = x;
			x = xNew;
		}
		xApproximate = 0; // 近似解の初期化
		System.out.println();

	}

	public static void secantMethod(double x0, double x1) {
		getIterAndXBySecant(x0, x1);
		printErrorBySecant(x0, x1);
	}

	// ParallelChord法による反復回数の測定、近似解を代入
	public static void getIterAndXByParallelChord(double x0) {
		double x = x0;
		for (iter = 0; iter < maxIter; iter++) {
			x -= f(x) / df(x0);
			if (Math.abs(f(x)) < EPSILON) {
				xApproximate = x;
				break;
			}
		}
		if (iter == maxIter) {
			System.out.println("収束しません");
		}

	}

	// ParallelChord法による誤差の表示
	public static void printErrorByParallelChord(double x0) {
		System.out.printf("xApproximate = %.16e\n", xApproximate);
		double x = x0;
		double error;
		for (int i = 1; i <= iter; i++) {
			x -= f(x) / df(x0);
			error = Math.abs(x - xApproximate);
			System.out.printf("%d, %.5e\n", i, error);
		}
		xApproximate = 0; // 近似解の初期化
		System.out.println();
	}

	public static void parallelChord(double x0) {
		getIterAndXByParallelChord(x0);
		printErrorByParallelChord(x0);
	}

}
