package problems;

public class Prob01_2 {
	// 12586269025
	public static void main(String[] args) {

		long ans = fibonacci(50);
		System.out.println(ans);

	}

	public static long fibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibonacci(n - 2) + fibonacci(n - 1);
		}
	}

}
