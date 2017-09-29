package nonLinearEquation;

public class Problem1 {

	static double x;
	final static double x0 = 2.5; // 初期値
	final static double x1 = 3.0; // secant法の初期値
	static double xApproximate; // 近似解
	final static double EPSILON = 1e-12; // 許容誤差
	static int maxIter = 200; // 最大反復回数
	static int iter;

	public static void main(String[] args) {

		System.out.println("反復回数,絶対誤差");

		// (1) Newton's Method
		System.out.println("--Newton's Method--");
		getNewton(x0);
		newtonMethod(x0);

		// (2) Secant Method
		System.out.println("--Secant Method--");
		getSecant(x0, x1);
		secantMethod(x0, x1);

		// (3) Parallel Chord
		System.out.println("--Parallel Chord--");
		getparallel(x0);
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
	public static void getNewton(double x0) {
		x = x0;
		for (iter = 0; iter < maxIter; iter++) {
			x -= f(x) / df(x);
			if (Math.abs(f(x)) < EPSILON) {
				break;
			}
		}
		xApproximate = x;
	}

	// Newton法による誤差の検出
	public static void newtonMethod(double x0) {
		x = x0;
		for (int i = 1; i <= iter; i++) {
			x -= f(x) / df(x);
			if (Math.abs(f(x)) < EPSILON) {
				break;
			}
			double error = Math.abs(x - xApproximate);
			System.out.printf("%d, %.5e\n", i, error);

		}
		System.out.println();
	}

	// Secant法による反復回数の測定、近似解を代入
	public static void getSecant(double x0, double x1) {
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
		xApproximate = xNew;

	}

	// Secant法による誤差の検出
	public static void secantMethod(double x0, double x1) {
		double xNew = x0;
		double x = x0;
		double xOld = x1;
		double error;
		for (int i = 1; i <= iter; i++) {
			xNew = x - f(x) * (x - xOld) / (f(x) - f(xOld));
			if (Math.abs(f(xNew)) < EPSILON) {
				break;
			} else {
				error = Math.abs(xNew - xApproximate);
				System.out.printf("%d, %.5e\n", i, error);
				xOld = x;
				x = xNew;
			}
		}
		System.out.println();

	}

	// ParallelChord法による反復回数の測定、近似解を代入
	public static void getparallel(double x0) {
		double x = x0;
		for (iter = 0; iter < maxIter; iter++) {
			x -= f(x) / df(x0);
			if (Math.abs(f(x)) < EPSILON) {
				break;
			}
		}
		xApproximate = x;

	}

	// ParallelChord法による誤差の検出
	public static void parallelChord(double x0) {
		double x = x0;
		double error;
		for (int i = 1; i <= iter; i++) {
			x -= f(x) / df(x0);
			if (Math.abs(f(x)) < EPSILON) {
				break;
			}
			error = Math.abs(x - xApproximate);
			System.out.printf("%d, %.5e\n", i, error);

		}
		System.out.println();
	}

}
