package l05;

public class SansyougatanoHukusei {

	public static void main(String[] args) {
		int[] x_1 = { 1, 2, 3 };
		int[] y_1 = x_1;
		y_1[0] = 3;
		System.out.println(x_1[0]);

		int[] x_2 = { 1, 2, 3 };
		int[] y_2 = new int[x_2.length];
		for (int i = 0; i < y_2.length; i++) {
			y_2[i] = x_2[i];
		}
		y_2[0] = 3;
		System.out.println(x_2[0]);
	}

}
