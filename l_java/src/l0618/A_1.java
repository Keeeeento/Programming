package l0618;

public class A_1 {

	public static void main(String[] args) {
		int[] M = { -1, 1, 0, 1, 0, 2, 0, 1, 0, 2, -1, 1, -1, 1, -3, -3, -1, 0, -2, -1, -3, -1, 1, 2, 1, 2, -1, 1, 2, 1,
				0, 1, -2, -1, -2, 0, -2, 1, 2, -2, -3, -2, 0, -2, -3, 0, -2, 0, 2, -3, -1, -3, 0, 2, -1, 2, 2, 1, -3, 1,
				0, 2, 2, 1, -2, 0, 0, -3, -1, 0, 1, 0, 1, -3, -1, 2, 1, 0, 1, -2, 0, 2, 1, 1, -1, -1, -2, -2, 2, -1, 1,
				0, 1, -2, 1, -2, -2, 1, 2, -1 };
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
