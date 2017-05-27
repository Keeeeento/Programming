package problems;

public class Prob02_3_2 {

	public static void main(String[] args) {
		// n = 4096
		// 精度が、小数点以下7桁のため、それ以下の数値は丸められてしまう
		float[] sum = { 1, 2 };

		int n = 1;
		while (sum[0] != sum[1]) {

			for (int i = 0; i < sum.length; i++) {
				sum[i] = Prob02_3_1.sumOf1OverKSquared(n + i);

			}
			// System.out.println(n + "," + sum[0] + " / " + sum[1]);
			n++;
		}

		System.out.println("n = " + (n - 1) + "のとき、" + sum[0] + " =" + sum[1]);

	}
}
