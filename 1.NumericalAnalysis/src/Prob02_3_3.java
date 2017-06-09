package problems;

public class Prob02_3_3 {
	// n = 500 のとき,s[0] = 1.6429359912872314
	// n = 5000 のとき,s[1] = 1.6447341442108154
	// n = 50000 のとき,s[2] = 1.6449105739593506
	public static void main(String[] args) {
		int[] n = { 500, 5000, 50000 };
		float[] s = new float[n.length];
		for (int i = 0; i < n.length; i++) {
			s[i] = sumOf1OverKSquared2(n[i]);
			System.out.printf("n = " + n[i] + " のとき," + "s[" + i + "] = %.16f\n", s[i]);
		}
	}

	protected static float sumOf1OverKSquared2(int n) {
		float sum = 0;
		for (int k = n; k >= 1; k--) {
			sum += 1.0 / (k * k);
		}
		return sum;
	}
}
