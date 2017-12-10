package midTermTestOf1stPeriod;

public class Problem2A {
	static int s = 4;

	public static void main(String[] args) {
		int n = 1;

		while (s(n + 1) != s(n)) {
			n++;
		}

		System.out.println("n = " + n);
		System.out.printf("S%d = %.7e\n", n, s(n));
	}

	public static float s(int n) {
		float sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += (float) (1.0 / Math.pow(i, s));
		}
		return sum;
	}
}
