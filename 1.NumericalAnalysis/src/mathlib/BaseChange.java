package mathlib;

public class BaseChange {
	public static void main(String[] args) {
		int a[] = { 1, 0, 0, 0, 1 };
		int b[] = { 0, 0, 1, 1 };
		int n = 2;

		// 与えられたｎ進数の出力
		System.out.print("(");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.print(".");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]);
		}
		System.out.print(")" + n + " = ");

		// １０進数に直す

		// 整数部分
		int x = 0;
		for (int i = 0; i < a.length; i++) {
			x *= n;
			x += a[i];
		}

		// 小数部分
		double y = 0;
		for (int i = b.length - 1; i >= 0; i--) {
			y = y * (1.0 / n) + b[i];
		}
		y = y * (1.0 / n);// 1の位の演算を追加

		// 10進数の生成
		double z = x + y;

		System.out.print("(" + z + ")10");

	}

}
