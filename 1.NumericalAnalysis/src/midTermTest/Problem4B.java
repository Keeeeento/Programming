package midTermTest;

import mathlib.LUDecomposition;
import mathlib.Matrix;

public class Problem4B {
	public static void main(String[] args) {
		int n = 10;
		Matrix c = new Matrix(n);
		c.getData()[0][0] = 2;
		c.getData()[n - 1][n - 1] = 2;
		for (int i = 1; i < n - 1; i++) {
			c.getData()[i][i] = 2;
			c.getData()[i][i - 1] = -1;
			c.getData()[i][i + 1] = -1;
		}
		c.print();

		LUDecomposition.u(c).print("u");

		System.out.println(c.getDeterminant());
	}

}
