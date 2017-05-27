package exercise08;

public class Problem4 {

	public static void main(String[] args) {
		double x = 30;
		double epsilon = 1.0E-10;

		int kMax = 100;
		int k = 0;

		while (Math.abs(f(x)) > epsilon) {
			x = renew(x);
			k++;

			if (k == kMax) {
				break;
			}
			System.out.println(x);
		}

	}

	// Excel には、初期値を30と-30のを比較して、対数目盛を利用してグラフを作成する

	public static double f(double x) {
		return x * x * x + x * x - 5 * x + 3;
	}

	public static double df(double x) {
		return 3 * x * x + 2 * x - 5;
	}

	public static double renew(double x) {
		return x - f(x) / df(x);
	}

}
