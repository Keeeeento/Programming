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
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (this.data[i][j] >= 0) {
					System.out.printf(" %.3f ", this.data[i][j]);

				} else {
					System.out.printf("%.3f ", this.data[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public void print(String str) {
		System.out.println(str + " = ");
		this.print();
	}

	// 指数表記
	public void printf() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (this.data[i][j] >= 0) {
					System.out.printf(" %.3e ", this.data[i][j]);

				} else {
					System.out.printf("%.3e ", this.data[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public void printf(String str) {
		System.out.println(str + " = ");
		this.printf();
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

	// 行列を単位行列化
	public void identify() {
		int n = this.data.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				this.data[i][j] = (i == j) ? 1 : 0;
			}
		}
	}

	// n次単位行列の作成
	public static Matrix identity(int n) {
		Matrix a = new Matrix(n);
		for (int i = 0; i < n; i++) {
			a.data[i][i] = 1;
		}
		return a;
	}

	// ヒルベルト行列の作成
	public void hilbert() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				this.data[i - 1][j - 1] = 1.0 / (i + j - 1);
			}
		}
	}

	public static Matrix hilbert(int n) {
		Matrix a = new Matrix(n);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a.data[i - 1][j - 1] = 1.0 / (i + j - 1);
			}
		}
		return a;
	}

	public void hilbertPlus1() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				data[i - 1][j - 1] = 1.0 / (i + j);
			}
		}
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
	public Matrix copy() {
		Matrix copy = new Matrix(n, m);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy.data[i][j] = this.data[i][j];
			}
		}
		return copy;
	}

	public Matrix copy(Matrix a) {
		Matrix copy = new Matrix(n, m);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy.data[i][j] = a.data[i][j];
			}
		}
		return copy;
	}

	// 行列のコピーk(1<k<n)まで
	public Matrix copyFromOneTo(int k) {
		Matrix a = new Matrix(k);
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				a.data[i][j] = this.data[i][j];
			}
		}
		return a;
	}

	// 行列の和
	public Matrix add(Matrix b) {
		Matrix a = copy(this);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a.data[i][j] += b.data[i][j];
			}
		}
		return a;
	}

	public Matrix add(Matrix a, Matrix b) {
		Matrix c = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				c.data[i][j] = a.data[i][j] + b.data[i][j];
			}
		}
		return c;
	}

	// 行列の差
	public Matrix subtract(Matrix a, Matrix b) {
		return add(a, scalarMultiple(-1));
	}

	public Matrix subtract(Matrix a) {
		return this.add(a.scalarMultiple(-1));
	}

	// 行列の積
	public Matrix multiply(Matrix a, Matrix b) {
		n = a.data.length;
		Matrix c = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					c.data[i][j] = a.data[i][k] * b.data[k][j];
				}
			}
		}
		return c;
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

	// 行列とベクトルの積
	public Vector multiply(Matrix a, Vector x) {
		Vector y = new Vector(x.getN());
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				y.getData()[i] += a.data[i][j] * x.getData()[j];
			}
		}
		return y;
	}

	public Vector multiply(Vector x) {
		Vector y = new Vector(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				y.getData()[i] += this.data[i][j] * x.getData()[j];
			}
		}
		return y;
	}

	// 残差(Vectorクラスにもあり)
	public Vector residual(Matrix a, Vector x, Vector b) {
		return x.subtract(multiply(a, x), b);
	}

	// 前進消去
	public void forwardElimination(Matrix a, Vector b) {
		this.n = a.n;
		double alpha = 0.0;
		for (int k = 0; k < n - 1; k++) {
			for (int i = k + 1; i < n; i++) {
				alpha = a.data[i][k] / a.data[k][k];
				for (int j = k; j < n; j++) {
					a.data[i][j] -= alpha * a.data[k][j];
				}
				b.getData()[i] -= alpha * b.getData()[k];
			}
		}
	}

	// 前進消去過程後のA
	public Matrix forwardEliminatedMatrix(Matrix a, Vector b) {
		this.n = a.n;
		double alpha = 0.0;
		Matrix a2 = a.copy();
		Vector b2 = b.copy();
		for (int k = 0; k < n - 1; k++) {
			for (int i = k + 1; i < n; i++) {
				alpha = a2.data[i][k] / a2.data[k][k];
				for (int j = k; j < n; j++) {
					a2.data[i][j] -= alpha * a2.data[k][j];
				}
				b2.getData()[i] -= alpha * b2.getData()[k];
			}
		}
		return a2;
	}

	// 前進消去過程後のb
	public Vector forwardEliminatedVector(Matrix a, Vector b) {
		this.n = a.n;
		double alpha = 0.0;
		Matrix a2 = a.copy();
		Vector b2 = b.copy();
		for (int k = 0; k < n - 1; k++) {
			for (int i = k + 1; i < n; i++) {
				alpha = a2.data[i][k] / a2.data[k][k];
				for (int j = k; j < n; j++) {
					a2.data[i][j] -= alpha * a2.data[k][j];
				}
				b2.getData()[i] -= alpha * b2.getData()[k];
			}
		}
		return b2;
	}

	// ピボット選択付き前進消去
	public void pivotingForwardElimination(Matrix a, Vector b) {
		this.n = a.n;
		int ell = 0; // 絶対値最大成分の行番号
		double alpha = 0.0;
		double pivot = 0.0;

		// 前進消去過程
		for (int k = 0; k < n - 1; k++) {
			ell = k;
			pivot = Math.abs(a.data[k][k]);

			// pivot選択
			for (int i = k + 1; i < n; i++) {
				if (pivot < Math.abs(a.data[i][k])) {
					pivot = Math.abs(a.data[i][k]);
					ell = i;
				}
			}

			// 行の入れ替え
			for (int j = k; j < n; j++) {
				pivot = a.data[k][j];
				a.data[k][j] = a.data[ell][j];
				a.data[ell][j] = pivot;
			}
			pivot = b.getData()[k];
			b.getData()[k] = b.getData()[ell];
			b.getData()[ell] = pivot;

			// 第k列目の消去
			for (int i = k + 1; i < n; i++) {
				alpha = a.data[i][k] / a.data[k][k];
				for (int j = k + 1; j < n; j++) {
					a.data[i][j] -= alpha * a.data[k][j];
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
		Vector x = b.copy(b);
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
		Matrix a2 = a.copy(a);
		Vector b2 = b.copy(b);
		forwardElimination(a2, b2);
		return backwardSubstitution(a2, b2);
	}

	// ピボット選択付きガウス消去法
	public Vector pivotGaussianElimination(Matrix a, Vector b) {
		Matrix a2 = a.copy(a);
		Vector b2 = b.copy(b);
		pivotingForwardElimination(a2, b2);
		return backwardSubstitution(a2, b2);
	}

	// // LU分解
	// // 下三角行列がL, 上三角行列がUである行列を返す
	// public Matrix luDecomposition(Matrix a) {
	// int n = a.getN();
	// Matrix lu = copy(a);
	// for (int k = 0; k < n; k++) {
	// for (int i = k + 1; i < n; i++) {
	// double alpha = lu.data[i][k] / lu.data[k][k];
	// for (int j = k + 1; j < n; j++) {
	// lu.data[i][j] -= alpha * lu.data[k][j];
	// }
	// lu.data[i][k] = alpha;
	// }
	// }
	// return lu;
	// }
	//
	// // LU分解でのL
	// public Matrix l(Matrix a) {
	// this.n = a.n;
	// Matrix l = new Matrix(n);
	// for (int i = 0; i < n; i++) {
	// for (int j = 0; j < n; j++) {
	// if (i > j) {
	// l.data[i][j] = a.data[i][j];
	// } else if (i == j) {
	// l.data[i][j] = 1;
	// }
	// }
	// }
	// return l;
	// }
	//
	// // LU分解でのU
	// public Matrix u(Matrix a) {
	// this.n = a.n;
	// Matrix u = new Matrix(n);
	// for (int i = 0; i < n; i++) {
	// for (int j = 0; j < n; j++) {
	// if (i <= j) {
	// u.data[i][j] = a.data[i][j];
	// }
	// }
	// }
	// return u;
	// }
	//
	// // LU分解でxを求める
	// public Vector solveByLUDecomposition(Matrix a, Vector b) {
	// n = a.data.length;
	// Vector x = new Vector(n);
	// Vector y = new Vector(n);
	// Matrix lu = new Matrix(n);
	// lu = luDecomposition(a);
	// Matrix l = l(lu);
	// Matrix u = u(lu);
	// y = forwardSubstitution(l, b);
	// x = backwardSubstitution(u, y);
	// return x;
	// }

	// 逆行列
	public Matrix Inverse(Matrix a) {
		int n = a.n;
		Matrix inv = new Matrix(n);
		Matrix l = LUDecomposition.l(a);
		Matrix u = LUDecomposition.u(a);

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
	public double getConditionNumberOfOneNorm() {
		return this.getManhattanNorm() * Inverse(this).getManhattanNorm();
	}

	public double getConditionNumberOfInfinityNorm() {
		return this.getInfinityNorm() * Inverse(this).getInfinityNorm();
	}

	// 対角行列
	public Matrix getDiagnal() {
		n = this.data.length;
		Matrix diagnal = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					diagnal.data[i][j] = this.data[i][j];
				}
			}
		}
		return diagnal;
	}

	// 狭義下三角行列
	public Matrix getLower() {
		n = this.data.length;
		Matrix lower = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i > j) {
					lower.data[i][j] = this.data[i][j];
				}
			}
		}
		return lower;
	}

	// 狭義上三角行列
	public Matrix getUpper() {
		n = this.data.length;
		Matrix upper = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i < j) {
					upper.data[i][j] = this.data[i][j];
				}
			}
		}
		return upper;
	}

	// 行列式
	public double getDeterminant() {
		int n = this.getData().length;
		Matrix u = LUDecomposition.u(this);
		double det = 1;

		for (int i = 0; i < n; i++) {
			det *= u.getData()[i][i];
		}
		return det;
	}

	// 広義対角優位行列か否か
	public boolean isDiagonalDominant() {
		boolean bool = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (Math.abs(this.data[i][i]) < Math.abs(this.data[i][j])) {
					bool = false;
				}
			}
		}
		return bool;
	}

	// 狭義対角優位行列か否か
	public boolean isStrictlyDiagonalDominant() {
		boolean bool = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (Math.abs(this.data[i][i]) < Math.abs(this.data[i][j])) {
					bool = false;
				}
			}
		}
		return bool;
	}

	// 首座小行列式が正か否か → 対称行列が正定値であるか
	public boolean isPrincipalMinorDeterminant() {
		boolean bool = true;
		for (int k = 0; k < n; k++) {
			Matrix a = this.copyFromOneTo(k);
			if (a.getDeterminant() <= 0) {
				bool = false;
				break;

			}
			a.print();
		}
		return bool;
	}

	// 対称帯行列の作成
	public void symmetricBand(double diagnal, double diagnal2, double diagnal3) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				switch (Math.abs(i - j)) {
				case 0:
					this.getData()[i][j] = diagnal;
					break;
				case 1:
					this.getData()[i][j] = diagnal2;
					break;
				case 2:
					this.getData()[i][j] = diagnal3;
					break;
				default:
					break;
				}
			}
		}
	}

	public void symmetricBand(double diagnal, double diagnal2) {
		this.symmetricBand(diagnal, diagnal2, 0);
	}

	public void symmetricBand(double diagnal) {
		this.symmetricBand(diagnal, 0, 0);
	}

	public static Matrix random(int n) {
		Matrix a = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a.getData()[i][j] = Math.random();
			}
		}
		return a;

	}

}
