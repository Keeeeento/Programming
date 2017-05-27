package sample09;

public class Combination1 {

	public static void main(String[] args) {
		int n = 10;
		int r = 1;
		for (int i = 1; i <= n; i++) {
			System.out.println(n + "C" + r + " = " + combination(n, r));
			r++;
			
		}

	}

	public static int combination(int n, int r) {
		return fractorial(n) / fractorial(r) / fractorial(n - r);
	}

	public static int fractorial(int n) {
		int f = 1;
		for (int i = 1; i <= n; i++) {
			f *= i;
		}
		return f;
	}
}
