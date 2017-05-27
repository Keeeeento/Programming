package sample10;

public class Vector {

	public static void main(String[] args) {

		int a = 2;
		int[] x = { 1, 2, 3 };

		int[] ax = new int[x.length]; // a*x の結果を格納する配列

		scalar(a, x, ax);
		System.out.println("ax = ");
		for (int i = 0; i < x.length; i++) {
			System.out.println(ax[i]);
		}

		int[] y = { 4, 5, 6 };

		System.out.println("(x , y) = " + dot(x, y));
	}

	// スカラー a とベクトル x に対して ax を計算するメソッド
	public static void scalar(int a, int[] x, int[] ax) {
		for (int i = 0; i < x.length; i++) {
			ax[i] = a * x[i];
		}
		return;
	}

	public static int dot(int[] x, int[] y) {
		int dot = 0;
		if (x.length == y.length) {
			for (int i = 0; i < x.length; i++) {
				dot += x[i] * y[i];
			}
		}
		return dot;
	}
}
