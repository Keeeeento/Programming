package mathlib;

public class Matrix {
	private int n;
	private int m;
	private double[][] data;

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public double[][] getData() {
		return data;
	}

	public void setData(double[][] data) {
		this.data = data;
	}

	// 行列のコンソール表示
	public void print() {
		Matrix a = this;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.printf("%.10f ", a.data[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public void print(String str) {
		Matrix a = this;
		System.out.println(str + " = ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.printf("%.10f ", a.data[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	// n×m行列(全要素0)
	public Matrix(int n, int m) {
		this.n = n;
		this.m = m;
		this.data = new double[n][m];
	}

	// n次正方行列(全要素0)
	public Matrix(int n) {
		this(n, n);
	}

	// 二次元配列をMatrixに格納
	public Matrix(double[][] data) {
		this.n = data.length;
		this.m = data[0].length;
		this.data = new double[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
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
			for (int j = 0; j < m; j++) {
				a.data[i][j] *= c;
			}
		}
		return a;
	}

	public Matrix scalarMultiple(double c, Matrix a) {
		Matrix b = copy(a);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
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
		Matrix copy = new Matrix(n, m);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy.data[i][j] = a.data[i][j];
			}
		}
		return copy;
	}

	// 単位行列
	public void identity() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					this.data[i][j] = 1;
				}
			}
		}
	}

	// 行列の和
	public Matrix addition(Matrix b) {
		Matrix a = copy(this);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a.data[i][j] += b.data[i][j];
			}
		}
		return a;
	}

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
		double norm = 0.0;
		for (int i = 0; i < n; i++) {
			double sum = 0.0;
			for (int j = 0; j < n; j++) {
				sum += Math.abs(this.data[i][j]);
			}
			norm = Math.max(norm, sum);
		}
		return norm;
	}

	// 前進消去
	public void forwardElimination(Matrix a, Vector b) {
		double alpha = 0.0;
		for (int k = 0; k < n - 1; k++) {
			for (int i = k + 1; i < n; i++) {
				alpha = a.data[i][k] / a.data[k][k];
				for (int j = k; j < n; j++) {
					a.data[i][j] -= alpha * a.data[k][j];
					if (i > j) {
						a.data[i][j] = 0.0;
					}
				}
				b.getData()[i] -= alpha * b.getData()[k];
			}
		}
	}

	// 前進代入
	// lは対角成分が1の下三角行列
	public Vector forwardSubstitution(Matrix l, Vector b) {
		Vector x = new Vector(b.getN());
		x = x.copy(b);
		for (int k = 0; k < n; k++) {
			for (int j = 0; j < k; j++) {
				x.getData()[k] -= l.data[k][j] * x.getData()[j];
			}
		}
		return x;
	}

	// 後退代入
	public Vector backwardSubstitution(Matrix a, Vector b) {
		Vector x = new Vector(b.getData());
		for (int k = n - 1; k >= 0; k--) {
			for (int j = k + 1; j < n; j++) {
				x.getData()[k] -= a.data[k][j] * x.getData()[j];
			}
			x.getData()[k] /= a.data[k][k];
		}
		return x;
	}

	// ガウス消去法
	public Vector gaussianElimination(Matrix a, Vector b) {
		forwardElimination(a, b);
		return backwardSubstitution(a, b);
	}

	// LU分解
	// 下三角行列がL, 上三角行列がUである行列を返す
	public Matrix luDecomposition(Matrix a) {
		int n = a.getN();
		Matrix lu = copy(a);
		for (int k = 0; k < n; k++) {
			for (int i = k + 1; i < n; i++) {
				double alpha = lu.data[i][k] / lu.data[k][k];
				for (int j = k + 1; j < n; j++) {
					lu.data[i][j] -= alpha * lu.data[k][j];
				}
				lu.data[i][k] = alpha;
			}
		}
		return lu;
	}

	// LU分解でのL
	public Matrix l(Matrix a) {
		this.n = a.n;
		Matrix l = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i > j) {
					l.data[i][j] = a.data[i][j];
				} else if (i == j) {
					l.data[i][j] = 1;
				}
			}
		}
		return l;
	}

	// LU分解でのU
	public Matrix u(Matrix a) {
		this.n = a.n;
		Matrix u = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i <= j) {
					u.data[i][j] = a.data[i][j];
				}
			}
		}
		return u;
	}

	// 逆行列
	public Matrix Inverse(Matrix a) {
		int n = a.n;
		Matrix inv = new Matrix(n);
		Matrix lu = new Matrix(n);
		Matrix l = new Matrix(n);
		Matrix u = new Matrix(n);
		lu = lu.luDecomposition(a);
		l = l.l(lu);
		u = u.u(lu);

		Vector x = new Vector(n);
		Vector y = new Vector(n);
		for (int i = 0; i < n; i++) {
			double[] data = new double[n];
			data[i] = 1;
			Vector e = new Vector(data);
			y = forwardSubstitution(l, e);
			x = backwardSubstitution(u, y);
			inv.data[i] = x.getData();
		}

		return inv.transpose();
	}

	// 条件数
	public double oneConditionNumber(Matrix a) {
		return a.getManhattanNorm() * Inverse(a).getManhattanNorm();
	}

	public double infinityConditionNumber(Matrix a) {
		return a.getInfinityNorm() * Inverse(a).getInfinityNorm();
	}

}