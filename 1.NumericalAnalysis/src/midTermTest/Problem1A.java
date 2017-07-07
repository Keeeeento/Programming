package midTermTest;

import mathlib.Matrix;
import mathlib.Vector;

public class Problem1A {
	public static void main(String[] args) {

		// 1
		int a[] = { 1, 0, 0, 0, 0, 0, 1 };
		int b[] = { 1, 0, 1 };
		int n = 2;
		System.out.print("(");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.print(".");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]);
		}
		System.out.print(")" + n + " = ");
		int x = 0;
		for (int i = 0; i < a.length; i++) {
			x *= n;
			x += a[i];
		}
		double y = 0;
		for (int i = b.length - 1; i >= 0; i--) {
			y = y * (1.0 / n) + b[i];
		}
		y = y * (1.0 / n);// 1の位の演算を追加
		double z = x + y;
		System.out.printf("(" + z + ")10\n");

		// 2
		System.out.println(
				"絶対値 = " + (Math.sqrt(Math.pow(Math.sin(Math.PI / 6.0), 2) + Math.pow(Math.cos(Math.PI / 3.0), 2))));

		// 3
		n = 49;
		double[] data = new double[n];
		for (int i = 0; i < n; i++) {
			data[i] = Math.sqrt(i);
		}
		Vector x2 = new Vector(data);

		System.out.println("|x|_2 = " + x2.getEuclideanNorm());

		// 4
		n = 10;
		Matrix A = new Matrix(n);
		A.hilbert();
		System.out.println("|A|_1 = " + A.getManhattanNorm());

	}
}
