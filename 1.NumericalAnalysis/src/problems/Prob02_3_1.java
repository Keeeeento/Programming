package problems;

public class Prob02_3_1 {

	public static void main(String[] args) { // 1.642936, 1.6447253, 1.6447253

		int[] n = { 500, 5000, 50000 };
		float[] s = new float[n.length];

		for (int i = 0; i < n.length; i++) { // sの出力
			s[i] = sumOf1OverKSquared(n[i]);
			System.out.println("n = "+n[i] +" のとき,"+"s[" + i + "] = " + s[i]);
		}

//		System.out.printf("%.7f",s[0]);

	}

	protected static float sumOf1OverKSquared(int n) {

		float sum = 0;

		for (float k = 1; k <= n; k++) {
			sum = sum + 1 / (k * k);
		}

		return sum;

	}
}
