package problems;

public class Prob01_3 {
	public static void main(String[] args) {
		// 10
		// 0.4999745973682873
		double a = 1;
		int ans1 = 0;
		double ans2 = 0;
		int n = 1;

		while (a > 10e-5) {
			a = a(n);
			ans2 += a;
			n++;
		}
		ans1 = n;
		System.out.println(ans1);
		System.out.println(ans2);

	}

	public static double a(int n) {
		return 1.0 / Math.pow(3, n);
	}
}
