package midTermTestOf1stPeriod;

import mathlib.Matrix;

public class Problem1B {
	public static void main(String[] args) {
		// 4
		int n = 5;
		Matrix a = new Matrix(n);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a.getData()[i - 1][j - 1] = i + j;
			}
		}

		System.out.println("|A|_∞ = " + a.getInfinityNorm());
		a.print();
	}

}
