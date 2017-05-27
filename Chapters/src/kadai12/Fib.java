package kadai12;

public class Fib {

	public static void main(String[] args) {
		int[] f = new int[33];
		int n;
		f[0] = 0;
		f[1] = 1;

		for (n = 2; n<50; n++) {
			f[n] = f[n - 2] + f[n - 1];
			System.out.println("f[" + n + "]=" + f[n]);


			// System.out.println(sum);
		}
	}

}
