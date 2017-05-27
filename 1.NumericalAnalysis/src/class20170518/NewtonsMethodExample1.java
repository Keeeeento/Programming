package class20170518;

public class NewtonsMethodExample1 {
	public static void main(String[] args) {
		double x0 = 7; // 初期値
		double x = x0; // 近似解
		double alpha = 1; // 真の解
		double eps = 10E-7; // 許容誤差（マシンイプシロン）
		int count = 0; // 反復回数
		double residual = 1; // 残差
		double relativeError = 0; // 絶対誤差
		int p = 1; // 収束次数




	}

	public static double f(double x) {
		return x * x * x - 1;
	}

	public static double df(double x) {
		return 3 * x * x;
	}

}
