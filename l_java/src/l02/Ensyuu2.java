package l02;

public class Ensyuu2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		double[] x = { 1.2, 2.0, 4.5, 1.0, 3.0 };
		double[] y = { 5.0, 3.5, 2.0, 4.0, 2.5 };

		double z = 0;
		for (int i = 0; i <= 4; i++) {
			z = z + x[i] * y[i]; // z += x[i] * y[i] と同じ.
		}
		System.out.println(z);

	}

}
