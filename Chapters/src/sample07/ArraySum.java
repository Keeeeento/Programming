package sample07;

public class ArraySum {

	public static void main(String[] args) {
		int[] x = { 10, 20, 30, 40, 50, 60 };
		int total = 0; // 0で初期化しておく

		for (int i = 0; i < x.length; i++) {
			total = total + x[i]; // 現在の total に x[i]を加算
			System.out.println("x[" + i + "]までの合計は" + total);

		}
		System.out.println("合計は" + total);

	}

}
