package problems;

public class Prob01_2 {
	public static void main(String[] args) {
		// fib(50) = 12586269025
		System.out.println("fib(50) = " + fib(50));

	}

	public static long fib(int n) {
		long a = 0;
		long b = 1;
		long f = 0;
		if (n <= 1) {
			return (long) n;
		} else {
			for (int i = 0; i < n; i++) {
				f = a + b;
				b = a;
				a = f;
			}
		}
		return f;
	}

}
