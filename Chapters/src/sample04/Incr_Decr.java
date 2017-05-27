package sample04;

public class Incr_Decr {

	public static void main(String[] args) {

		int a, b;

		// 前置
		a = 10;
		b = ++a + 5; // aを1増やした後でa+5を計算

		System.out.println(a); // aを出力
		System.out.println(b); // bを出力

		System.out.println();

		// 後置

		a = 10;
		b = a++ + 5;
		System.out.println(a);
		System.out.println(b);

	}

}
