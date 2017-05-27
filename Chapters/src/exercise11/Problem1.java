package exercise11;

public class Problem1 {

	public static void main(String[] args) {
		int[] val = { 10, -12, 5, -30, 12, 25 };
		for (int i = 0; i < val.length; i++) {
			if (val[i] < 0) {
				System.out.println("負の値です");
				continue;
			}
			System.out.printf("%dの平方根は%f\n", val[i], Math.sqrt(val[i]));
		}

	}

	/*
	 * public static double heihoukon(int a){ return Math.pow(a,0.5);
	 *
	 * }
	 */
	
}
