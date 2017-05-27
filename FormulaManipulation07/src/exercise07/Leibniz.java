package exercise07;

public class Leibniz {

	public static void main(String[] args) {
		int n = 10000;
		double p = 1;
		double lei = 1.0;

		for (int k = 1; k < n; k++) {
			p = Math.pow(-1, k);
			lei += p / (2 * k + 1);
		}

		System.out.println(4 * lei);
	}

}
