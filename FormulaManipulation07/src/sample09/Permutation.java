package sample09;

public class Permutation {

	public static void main(String[] args) {

		int n = 5;
		int r = 3;

		System.out.println(n + "P" + r + " = " + permutation(n, r));

	}

	public static int permutation(int n, int r) {
		return fractorial(n) / fractorial(n - r);
	}

	public static int fractorial(int n) {
		int f = 1;
		for (int i = 1; i <= n; i++) {
			f *= i;
		}
		return f;
	}

}
