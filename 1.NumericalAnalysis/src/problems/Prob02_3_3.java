package problems;

public class Prob02_3_3 {

	public static void main(String[] args) {
		// float型では無く、より精度の高いdouble型を使用して求める ← 実行に大変時間がかかる
		double[] sum = { 1, 2 };

		int n = 1;
		while (sum[0] != sum[1]) {

			for (int i = 0; i < sum.length; i++) {
				sum[i] = sumOf1OverKSquared(n + i);

			}
			// System.out.println(n + "," + sum[0] + " / " + sum[1]);
			n++;
		}

		System.out.println(n - 1);

	}

	public static double sumOf1OverKSquared(int n) {

		double sum = 0;

		for (double k = 1; k <= n; k++) {
			sum = sum + 1 / (k * k);
		}

		return sum;

	}
}
