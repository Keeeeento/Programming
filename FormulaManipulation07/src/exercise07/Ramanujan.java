package exercise07;

public class Ramanujan {

	public static void main(String[] args) {

		int n = 10000;

		double ram = 0;

		for (int k = 0; k < n; k++) {
			ram = (fractorial(4 * k) * (1103 + 26390 * k))
					/ (Math.pow(Math.pow(4, k) * Math.pow(99, k) * fractorial(k), 4));
		}

		ram *= 2 * Math.sqrt(2) / Math.pow(99, 2);

		System.out.println(4 * ram);
	}

	public static int fractorial(int n) { // int型の簡潔階乗メソッド
		int a = 1;
		for (int i = 1; i <= n; i++) {

			a = a * i;
		}
		return a;
	}

}
