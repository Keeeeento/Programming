package sample05;

public class Pow_Rand {

	public static void main(String[] args) {

		double x = Math.pow(2, 8);
		System.out.println("2の8乗=" + x);

		double y = Math.random();
		System.out.println("乱数 =" + y);

		System.out.println(power(2, 10));
		System.out.println(ss(2.5, 2.9));

		System.out.println(ss(5.5, 4.1));

	}

	public static int power(int a, int b) {
		int p = 1;
		for (int i = 0; i < b; i++) {
			p *= a;
		}
		return p;
	}

	public static int ss(double a, double b) {
		double s = a + b;
		if (s - (int) s < 0.5) {
			s = s;
		} else if (s - (int) s >= 0.5) {
			s = s + 1;
		}
		return (int) s;
	}
}

/*
 * public static double miniminiminimini(double a, double b) { double min; if (a
 * >= b) { min = b; } else{
 *
 * }
 *
 * }
 *
 * }
 */