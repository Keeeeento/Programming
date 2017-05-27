package sample09;

public class Combination2 {

	public static void main(String[] args) {

		int n = 13;
		int r = 5;

		int c = 1;
		for (int k = 1; k <= r; k++) {
			c = (n - k + 1) * c / k;
			System.out.println(n + "C" + k + " = " + c);
		}
	}

}