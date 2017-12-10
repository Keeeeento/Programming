package ComputerMathematicsReport;

import mathlib.Matrix;
import texlib.TeX;

public class DrowTable {

	public static void main(String[] args) {
		int n = 20;
		double[][] data = new double[n][n];

		// 二項関係を満たすもののデータ
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i % 6 == j % 6) {
					data[i - 1][j - 1] = 1;
				}
				if (i % 8 == j % 8 && i != j) {
					data[i - 1][j - 1] = 2;
				}
			}
		}

		Matrix a = new Matrix(data);
		// データの出力(TeX)
		TeX.beginTable(n);
		for (int i = 0; i < n; i++) {
			System.out.printf("$%d$ &", i + 1);
			for (int j = 0; j < n; j++) {
				if (j < n - 1) {
					if (data[i][j] >= 1) {
						System.out.print("$\\circ$ &");
					} else {
						System.out.print(" &");
					}
				} else {
					if (data[i][j] >= 1) {
						System.out.print("$\\circ$");
					}
				}
				if (j == n - 1) {
					System.out.println("\\\\ \\hline");
				}
			}
		}
		TeX.endTable();

		a.printInt("Table");

		// 同値関係を満たすまで改善したデータ
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (data[i][j] >= 1) { // (i,j) = 1
					for (int k = 0; k < n; k++) {
						if (data[j][k] >= 1) { // (j,k) = 2
							if (data[i][k] == 0) {
								data[i][k] = 3; // (i,k) = 3
							}
						}
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.printf("$%d$ &", i);
		}
		System.out.println();
		System.out.print("");

		a.setData(data);
		a.printInt();

		// データの出力(TeX)
		TeX.beginTable(n);
		for (int i = 0; i < n; i++) {
			System.out.printf("$%d$ &", i + 1);
			for (int j = 0; j < n; j++) {
				if (j < n - 1) {
					if (data[i][j] >= 1) {
						System.out.print("$\\circ$ &");
					} else {
						System.out.print(" &");
					}
				} else {
					if (data[i][j] >= 1) {
						System.out.print("$\\circ$");
					}
				}
				if (j == n - 1) {
					System.out.println("\\\\ \\hline");
				}
			}
		}
		TeX.endTable();

	}
}
