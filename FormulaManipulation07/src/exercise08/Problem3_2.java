package exercise08;

public class Problem3_2 {

	public static void main(String[] args) {
		double x = 10.0;
		double epsilon = 1.0E-10;

		int count = 0;
		int countMax = 100;

		while (Math.abs(f(x)) > epsilon) {
			x = renew(x);
			count++;

			System.out.printf("%e%n", Math.abs(f(x)));

			if (count == countMax) {
				System.out.println("最大反復回数に到達しました．");
				break;
			}

		}
		System.out.println("反復回数は" + count + "回で、log2の近似値は，" + f(x));
		System.out.println("Mathクラスでのlog2の値は，" + Math.log(2));
	}

	public static double f(double x) {
		return Math.exp(x) - 2;
	}

	public static double df(double x) {
		return Math.exp(x);
	}

	public static double renew(double x) {
		return x - f(x) / df(x);
	}

}
