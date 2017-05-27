package l0618;

public class A_0 {

	public static void main(String[] args) {
		int[] M = { 1, 7, 4, 3, 3, 1, 3, 6, 5, 7, 5, 2, 4, 4, 7, 1, 5, 5, 6, 2 };
		double S = 0;
		double s = 0;
		double ss = 0;
		for (int i = 0; i < M.length; i++) {
			S += Math.pow(M[i], 2);
			s += M[i];

		}
		ss = Math.pow(s, 2);
		double dif = S - ss;
		System.out.println(dif);

	}

}
