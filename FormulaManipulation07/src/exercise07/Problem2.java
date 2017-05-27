package exercise07;

public class Problem2 {

	public static void main(String[] args) {
		int n = 10;
		int x = 2;

		double cos = 1.0;

		for (int i = 1; i < n; i++) {

			cos = cos + Math.pow(-1, i) * Math.pow(x, 2 * i) / fractorial(2 * i);
		}

		System.out.println(cos);
		System.out.println(Math.cos(x));
	}

	public static int fractorial(int n) { // int型の簡潔階乗メソッド
		int a = 1;
		for (int i = 1; i <= n; i++) {

			a = a * i;
		}

		return a;
	}

	public static int power(int a, int b) { // int型の簡潔累乗メソッド
		int c = 1;
		for (int i = 0; i < b; i++) {
			c = c * a;
		}
		return c;
	}

}
