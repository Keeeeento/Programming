package mathlib;

public class Test {
	public static void main(String[] args) {

		int n = 10;
		double[][] adata = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				adata[i][j] = i + j + 1;
			}
		}
		Matrix a = new Matrix(adata);
		System.out.println(a.getLower().add(a.getDiagonal()).inverse().getSpectralRadius());
		// i = 2
		// 0.9594929736144973

	}
}