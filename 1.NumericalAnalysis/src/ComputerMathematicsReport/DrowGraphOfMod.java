package ComputerMathematicsReport;

import mathlib.Matrix;

public class DrowGraphOfMod {

	public static void main(String[] args) {
		System.out.println("graph{");
		int n = 20;
		double[][] data = new double[n][n];
		System.out.println("edge[color=\"magenta\",penwidth=\"1\"]");
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				if (i % 6 == j % 6 && i != j) {
					data[i - 1][j - 1] = 1;
					System.out.println(i + " -- " + j);
				}
			}
		}

		System.out.println("edge[color=\"grey\",penwidth=\"1\"]");
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				if (i % 8 == j % 8 && i != j) {
					data[i - 1][j - 1] = 2;
					System.out.println(i + " -- " + j);
				}
			}
		}

		Matrix a = new Matrix(data);

		System.out.println("}");
		a.printInt();
	}
}
