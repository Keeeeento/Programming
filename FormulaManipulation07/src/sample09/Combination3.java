package sample09;

public class Combination3 {

	public static void main(String[] args) {

		int n = 13;
		int r = 5;

		System.out.println(n + "C" + r + " = " + combination(n, r));
	}

	public static int combination(int n, int r) {
		if (r == 0) {
			return 1;
		} else {
			return combination(n - 1, r - 1) + combination(n - 1, r);
		}
	}

	/*
	 * else { return (n - r + 1) * combination(n, r - 1) / r; }
	 */

}
