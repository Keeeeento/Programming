package mathlib;

/**
 * @author Kento
 *
 */

public class Matrix extends LinearCondition {
	private double[][] data;

	public double[][] getData() {
		return data;
	}

	public void setData(double[][] data) {
		this.data = data;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		DefaultCondition.n = n;
	}

	// 行列のコンソール表示
	public void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
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
			for (int j = 0; j < n; j++) {
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

	// 整数表記
	public void printInt() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (this.data[i][j] >= 0) {
					System.out.printf(" %d ", (int) this.data[i][j]);
				} else {
					System.out.printf("%d ", (int) this.data[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public void printInt(String str) {
		System.out.println(str + " = ");
		this.printInt();
	}

	// TeX用
	public void printTeX() {
		System.out.println("   \\begin{pmatrix}");
		for (int i = 0; i < n; i++) {
			System.out.print("      ");
			for (int j = 0; j < n - 1; j++) {
				System.out.printf("%.10f & ", this.data[i][j]);
			}
			if (i == n - 1) {
				System.out.printf("%.10f\n", this.data[i][n - 1]);

			} else {
				System.out.printf("%.10f \\\\ \n", this.data[i][n - 1]);
			}
		}
		System.out.println("   \\end{pmatrix}");
	}

	public void printTeX(String str) {
		System.out.println(str + " = ");
		this.printTeX();
	}

	// Tex用整数表示
	public void printTeXInt() {
		System.out.println("   \\begin{pmatrix}");
		for (int i = 0; i < n; i++) {
			System.out.print("      ");
			for (int j = 0; j < n - 1; j++) {
				System.out.printf("%d & ", (int) this.data[i][j]);
			}
			if (i == n - 1) {
				System.out.printf("%d\n", (int) this.data[i][n - 1]);

			} else {
				System.out.printf("%d \\\\ \n ", (int) this.data[i][n - 1]);
			}
		}
		System.out.println("   \\end{pmatrix}");
	}

	public void printTeXInt(String str) {
		System.out.println("$$" + str + " = ");
		this.printTeXInt();
		System.out.println("$$");
	}

	// n次正方行列(全要素0)
	public Matrix(int n) {
		this.data = new double[n][n];
	}

	// 二次元配列をMatrixに格納
	public Matrix(double[][] data) {
		n = data.length;
		this.data = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				this.data[i][j] = data[i][j];
			}
		}
	}

	// 全要素numberの行列を返す
	public static Matrix allNumber(int n, double number) {
		Matrix a = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a.getData()[i][j] = number;
			}
		}
		return a;
	}

	// 行列を単位行列化
	public void identify() {
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
	public Matrix scalarMultiply(double c) {
		Matrix a = this;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a.data[i][j] *= c;
			}
		}
		return a;
	}

	public Matrix scalarMultiply(double c, Matrix a) {
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
	public Matrix copy() {
		Matrix copy = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy.data[i][j] = this.data[i][j];
			}
		}
		return copy;
	}

	public Matrix copy(Matrix a) {
		Matrix copy = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
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
		return add(a, scalarMultiply(-1));
	}

	public Matrix subtract(Matrix a) {
		return this.add(a.scalarMultiply(-1));
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

	public Matrix multiply(Matrix a) {
		n = a.data.length;
		Matrix b = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					b.data[i][j] += this.data[i][k] * a.data[k][j];
				}
			}
		}
		return b;
	}

	// 1ノルム
	public double getManhattanNorm() {
		return this.transpose().getInfinityNorm();
	}

	// 2ノルム
	public double getEuclideanNorm() {
		return Math.sqrt(this.getSpectralRadius());
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

	// pノルム
	public double getNorm(int p) {
		switch (p) {
		case 0:
			return this.getInfinityNorm();
		case 1:
			return this.getManhattanNorm();
		case 2:
			return this.getEuclideanNorm();
		default:
			System.out.println(p + " norm is not difined");
			return 0;
		}
	}

	// 行列とベクトルの積
	public Vector multiply(Matrix a, Vector x) {
		Vector y = new Vector(n);
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
		Vector x = new Vector(n);
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

	// 逆行列
	public Matrix inverse(Matrix a) {
		Matrix inv = new Matrix(n);
		Matrix l = LUDecomposition.getL(a);
		Matrix u = LUDecomposition.getU(a);

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

	/**
	 * @return 対角行列か否か
	 */
	public boolean isDiagonal() {
		boolean isDiagonal = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					if (this.getData()[i][j] > epsilon) {
						isDiagonal = false;
					}
				}
			}
		}
		return isDiagonal;
	}

	/**
	 * 対角行列 -> 対角成分を逆数
	 * otherwise -> LU分解から
	 * @return 逆行列
	 */
	public Matrix inverse() {
		Matrix inv = new Matrix(n);
		if (this.isDiagonal()) {
			for (int i = 0; i < n; i++) {
				inv.data[i][i] = 1.0 / this.data[i][i];
			}
			return inv;
		} else {

			Matrix l = LUDecomposition.getL(this);
			Matrix u = LUDecomposition.getU(this);

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
	}

	// 条件数
	public double getConditionNumber(int normNumber) {
		return this.getNorm(normNumber) * inverse(this).getNorm(normNumber);
	}

	// 対角行列
	public Matrix getDiagonal() {
		Matrix diagonal = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					diagonal.data[i][j] = this.data[i][j];
				}
			}
		}
		return diagonal;
	}

	// 狭義下三角行列
	public Matrix getLower() {
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
		Matrix u = LUDecomposition.getU(this);
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
			double sum = 0.0;
			for (int j = 0; j < n; j++) {
				if (i != j) {
					sum += this.getData()[i][j];
				}
			}
			if (Math.abs(this.data[i][i]) < sum) {
				bool = false;
			}
		}
		return bool;
	}

	// 狭義対角優位行列か否か
	public boolean isStrictlyDiagonalDominant() {
		boolean bool = true;
		for (int i = 0; i < n; i++) {
			double sum = 0.0;
			for (int j = 0; j < n; j++) {
				if (i != j) {
					sum += this.getData()[i][j];
				}
			}
			if (Math.abs(this.data[i][i]) <= sum) {
				bool = false;
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
	public void symmetricBand(double d, double d2, double d3) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				switch (Math.abs(i - j)) {
				case 0:
					this.getData()[i][j] = d;
					break;
				case 1:
					this.getData()[i][j] = d2;
					break;
				case 2:
					this.getData()[i][j] = d3;
					break;
				default:
					break;
				}
			}
		}
	}

	public void symmetricBandForExam(double a, double d) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				switch (Math.abs(i - j)) {
				case 0:
					this.getData()[i][j] = a;
					break;
				case 1:
					this.getData()[i][j] = d;
					break;
				default:
					break;
				}
			}
			if (i >= 2 && i - 2 < n) {
				this.getData()[i][i - 2] = d;
			}

		}
	}

	public void symmetricBand(double d, double d2) {
		this.symmetricBand(d, d2, 0);
	}

	public void symmetricBand(double d) {
		this.symmetricBand(d, 0, 0);
	}

	public static Matrix symmetricBand(int n, double d, double d2, double d3) {
		Matrix a = new Matrix(n);
		a.symmetricBand(d, d2, d3);
		return a;
	}

	public static Matrix symmetricBand(int n, double d, double d2) {
		Matrix a = new Matrix(n);
		a.symmetricBand(d, d2, 0);
		return a;
	}

	public static Matrix symmetricBand(int n, double d) {
		Matrix a = new Matrix(n);
		a.symmetricBand(d, 0, 0);
		return a;
	}

	// 成分をランダムで生成
	public static Matrix random(int n) {
		Matrix a = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a.getData()[i][j] = Math.random();
			}
		}
		return a;
	}

	/**
	 * getSpecturalRedius
	 * スペクトル半径を求める
	 * 収束判定条件あり
	 * 初期ベクトル x0 = {1,1,…,1}
	 * @param なし
	 * @return lambda スペクトル半径(絶対値最大の固有値)
	 */
	public double getSpectralRadius() {

		double lambda = 0.0;
		double lambdaOld = 0.0;
		Vector xOld = Vector.allNumber(n, 1.0);
		Vector x = new Vector(n);

		for (int i = 0; i < maxIteration; i++) {
			x = this.multiply(xOld);
			lambda = Math.abs(Vector.innerProduct(xOld, x));

			if (Math.abs(lambda - lambdaOld) < epsilon) {
				break;
			}
			lambdaOld = lambda;
			xOld = x.scalarMultiply(1.0 / x.getNorm(2));

		}

		return lambda;
	}

	public int getIterationOfSpectralRedius() {
		double lambda = 0.0;
		double lambdaOld = 0.0;
		Vector xOld = new Vector(n);
		Vector x = new Vector(n);
		int iteration;

		xOld.allNumber(1.0);

		for (iteration = 0; iteration < maxIteration; iteration++) {
			x = this.multiply(xOld);
			lambda = Math.abs(Vector.innerProduct(xOld, x));

			if (Math.abs(lambda - lambdaOld) < epsilon) {
				break;
			}
			// System.out.println(lambda);
			lambdaOld = lambda;
			xOld = x.scalarMultiply(1.0 / x.getNorm(2));

		}

		return iteration;
	}

	// 対称行列か否か(Machine Epsilon評価)
	public boolean isSymmetric() {
		boolean bool = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j && this.getData()[i][j] - this.getDeterminant() >= epsilon) {
					bool = false;
				}
			}
		}
		return bool;
	}

	/**
	 * B = I-D^-1*A
	 * @return ヤコビ法のためのヤコビ行列
	 */
	public Matrix getJacobiMatrix() {
		Matrix i = Matrix.identity(this.getN());
		Matrix d = this.getDiagonal();
		return i.subtract(d.inverse().multiply(this));
	}

	public Matrix getJacobiMatrixOld() {
		Matrix l = this.getDiagonal().inverse().multiply(this.getLower());
		Matrix u = this.getDiagonal().inverse().multiply(this.getUpper());
		return l.add(u).scalarMultiply(-1.0);
	}

	/**
	 * @see SpectralRadious.java
	 * @return 最適なomega
	 */
	public double getOptimalOmega() {
		double rho = SpectralRadius.getSpectralRadiusByRayleigh(this.getJacobiMatrix(), Vector.allNumber(n, 1.0));
		return 2.0 / (1.0 + Math.sqrt(1.0 - Math.pow(rho, 2.0)));
	}

}
