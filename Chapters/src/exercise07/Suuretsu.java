package exercise07;

public class Suuretsu {

	public static void main(String[] args) {
		int a = 2;
		int d = 3;

		/*
		 * for (int n = 0; n <= 10; n++) { a = a + d; System.out.print(a +
		 * "\t"); }
		 */

		for (int n = 1; n <= 10; n++) {
			System.out.print((a + d * (n - 1)) + "\t");
		}



	}

}
