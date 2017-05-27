package exercise09;

public class Series {

	public static void main(String[] args) {
		int n = 1;
		int a = 2 * n * n + 3 * n + 1;
		int sum = 0;
		while (sum <= 10000) {
			sum += a;
			// System.out.println(n + "と" + sum);
			n++;
		}
		System.out.println("kの値は" + (n - 1));
		System.out.println("このとき和の値は" + sum);

		int k = 1, Sk = 0;
		while (Sk <= 10000) {
			Sk += 2 * k * k + 3 * n + 1;
			k++;
		}
		System.out.println((k - 1) + "の時," + Sk);

	}

}
