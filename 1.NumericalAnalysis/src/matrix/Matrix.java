package matrix;

public class Matrix {
	private int n;
	private double[][] data;

	// 行列のコンソール表示
	public void print() {
		Matrix a = this;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%.10f ", a.data[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	// n次正方行列(全要素0)
	public Matrix(int n) {
		this.n = n;
		data = new double[n][n];
	}

	// 二次元配列をMatrixに格納
	public Matrix(double[][] data) {
		this.n = data.length;
		this.data = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				this.data[i][j] = data[i][j];
			}
		}
	}

	// n次単位上列の作成
	public static Matrix identity(int n) {
		Matrix a = new Matrix(n);
		for (int i = 0; i < n; i++) {
			a.data[i][i] = 1;
		}
		return a;
	}

	// 行列のc倍
	public Matrix scalarMultiple(double c) {
		Matrix a = this;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a.data[i][j] *= c;
			}
		}
		return a;
	}

	public Matrix scalarMultiple(double c, Matrix a) {
		Matrix b = copy(a);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				b.data[i][j] *= c;
			}
		}
		return b;
	}

	// 行列の転置
	public Matrix transpose() {
		Matrix a = this;
		Matrix b = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				b.data[i][j] = a.data[j][i];
			}
		}
		return b;
	}

	// 行列のコピー
	public Matrix copy(Matrix a) {
		Matrix copy = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy.data[i][j] = a.data[i][j];
			}
		}
		return copy;
	}

	// 行列の和
	public Matrix addition(Matrix a, Matrix b) {
		Matrix c = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				c.data[i][j] = a.data[i][j] + b.data[i][j];
			}
		}
		return c;
	}

	// 行列の差
	public Matrix substract(Matrix a, Matrix b) {
		return addition(a, scalarMultiple(-1));
	}

	// 1ノルム
	public double getManhattanNorm() {
		return this.transpose().getInfinityNorm();
	}

	// 無限大ノルム
	public double getInfinityNorm() {
		Matrix a = this;
		double norm = 0.0;
		double sum = 0.0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum += Math.abs(a.data[i][j]);
			}
			if (sum > norm) {
				norm = sum;
			}
			sum = 0;
		}
		return norm;
	}

}
