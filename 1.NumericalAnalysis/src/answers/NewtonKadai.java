package answers;

public class NewtonKadai {

	public static void main(String[] args) {
		// ニュートン法のアルゴリズム
		// double x_0 = 30; // 初期値 x_0 = 30
		double x_0 = -30; // 初期値 x_0 = -30
		double eps = 1e-12; // 誤差の判定条件

		double x = 0;
		int N = 0; // 反復回数
		System.out.println("回数 \t 近似値 \t 残差 \t 誤差");
		while (Math.abs(f(x)) >= eps) {// 残差が eps 以下ならば, 反復停止
			if (N >= 50) {
				System.out.println("収束できません.");
				break;
			}
			x = x_0 - f(x_0) / f_x(x_0);
			x_0 = x;
			N++; // ニュートン法の反復式. 反復回数を+1.
			System.out.println(N + "\t" + x + "\t" + Math.abs(f(x)) + "\t" + Math.abs(x - 1));
		}
		System.out.println("解 x = " + x + ",   反復回数 N = " + N);
	}

	// メソット f(x): x での関数値 f(x) を計算する.
	public static double f(double x) {
		return x * x * x + x * x - 5 * x + 3;
	}

	// メソット (f(x) の一階微分) f'(x): x での f'(x) を計算する.
	public static double f_x(double x) {
		return 3 * x * x + 2 * x - 5;
	}

}
