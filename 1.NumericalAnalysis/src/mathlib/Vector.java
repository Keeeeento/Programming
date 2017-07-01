package mathlib;

public class Vector {
	private double[] data;
	private int n;

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public double[] getData() {
		return data;
	}

	public void setData(double[] data) {
		this.data = data;
	}

	// n次元ベクトル(全要素0)
	public Vector(int n) {
		this.n = n;
		this.data = new double[n];
	}

	// 配列をベクトルに格納
	public Vector(double[] data) {
		this.n = data.length;
		this.data = new double[n];
		for (int i = 0; i < this.n; i++) {
			this.data[i] = data[i];
		}
	}

	// コンソール表示
	public void print() {
		for (int i = 0; i < this.data.length; i++) {
			System.out.printf("%.10f ", this.data[i]);
		}
		System.out.println();
		System.out.println();
	}

	public void print(String str) {
		System.out.println(str + " = ");
		for (int i = 0; i < this.data.length; i++) {
			System.out.printf("%.10f ", this.data[i]);
		}
		System.out.println();
		System.out.println();
	}

	// 指数表記
	public void printf() {
		for (int i = 0; i < this.data.length; i++) {
			System.out.printf("%.3e ", this.data[i]);
		}
		System.out.println();
		System.out.println();
	}

	public void printf(String str) {
		System.out.println(str + " = ");
		for (int i = 0; i < this.data.length; i++) {
			System.out.printf("%.3e ", this.data[i]);
		}
		System.out.println();
		System.out.println();
	}

	// コピー
	public Vector copy() {
		Vector vector = new Vector(n);
		for (int i = 0; i < n; i++) {
			vector.data[i] = this.data[i];
		}
		return vector;
	}

	public Vector copy(Vector a) {
		this.n = a.data.length;
		Vector vector = new Vector(n);
		for (int i = 0; i < n; i++) {
			vector.data[i] = a.data[i];
		}
		return vector;
	}

	// c倍
	public Vector scalarMultiply(double c) {
		Vector a = copy(this);
		for (int i = 0; i < this.n; i++) {
			a.data[i] *= c;
		}
		return a;
	}

	// 要素をすべてn
	public void allNumber(double num) {
		for (int i = 0; i < this.n; i++) {
			this.data[i] = num;
		}
	}

	// 加算
	public Vector add(Vector x, Vector y) {
		n = x.n;
		Vector z = new Vector(n);
		for (int i = 0; i < n; i++) {
			z.data[i] = x.data[i] + y.data[i];
		}
		return z;
	}

	public Vector add(Vector x) {
		Vector y = this.copy();
		for (int i = 0; i < n; i++) {
			y.data[i] += x.data[i];
		}
		return y;
	}

	// 減算
	public Vector subtract(Vector x, Vector y) {
		return add(x, y.scalarMultiply(-1));
	}

	public Vector subtract(Vector x) {
		return this.add(x.scalarMultiply(-1));
	}

	// 内積
	public double innerProduct(Vector x, Vector y) {
		double innerProduct = 0.0;
		for (int i = 0; i < x.n; i++) {
			innerProduct += x.data[i] * y.data[i];
		}
		return innerProduct;
	}

	// 1ノルム
	public double getManhattanNorm() {
		double norm = 0.0;
		for (int i = 0; i < this.n; i++) {
			norm += Math.abs(this.data[i]);
		}
		return norm;
	}

	// 2ノルム
	public double getEuclideanNorm() {
		double norm = 0.0;
		for (int i = 0; i < this.n; i++) {
			norm += this.data[i] * this.data[i];
		}
		return Math.sqrt(norm);
	}

	// 無限大ノルム
	public double getInfinityNorm() {
		double norm = 0.0;
		for (int i = 0; i < this.n; i++) {
			norm = Math.max(norm, Math.abs(this.data[i]));
		}
		return norm;
	}

	// 1ノルム絶対誤差
	public double getAbsoluteErrorOfOneNorm(Vector x) {
		return subtract(x, this).getManhattanNorm();
	}

	// 2ノルム絶対誤差
	public double getAbsoluteErrorOfTwoNorm(Vector x) {
		return subtract(x, this).getEuclideanNorm();
	}

	// 無限大ノルム絶対誤差
	public double getAbsoluteErrorOfInfinityNorm(Vector x) {
		return subtract(x, this).getInfinityNorm();
	}

	// 1ノルム相対誤差
	public double getRelativeErrorOfOneNorm(Vector x) {
		return this.getAbsoluteErrorOfOneNorm(x) / x.getManhattanNorm();
	}

	// 2ノルム相対誤差
	public double getRelativeErrorOfTwoNorm(Vector x) {
		return this.getAbsoluteErrorOfTwoNorm(x) / x.getEuclideanNorm();
	}

	// 無限大ノルムの相対誤差
	public double getRelativeErrorOfInfinityNorm(Vector x) {
		return this.getAbsoluteErrorOfInfinityNorm(x) / x.getInfinityNorm();
	}

	// 残差
	public Vector residual(Matrix a, Vector b) {
		return this.subtract(a.multiply(a, this), b);
	}

	// 1ノルム絶対残差
	public double getAbsoluteResidualOfOneNorm(Matrix a, Vector b) {
		return this.residual(a, b).getManhattanNorm();
	}

	// 2ノルム絶対残差
	public double getAbsoluteResidualOfTwoNorm(Matrix a, Vector b) {
		return this.residual(a, b).getEuclideanNorm();
	}

	// 無限大ノルム絶対残差
	public double getAbsoluteResidualOfInfinityNorm(Matrix a, Vector b) {
		return this.residual(a, b).getInfinityNorm();
	}

	// 1ノルム相対残差
	public double getRelativeResidualOfOneNorm(Matrix a, Vector b) {
		return this.residual(a, b).getManhattanNorm() / b.getManhattanNorm();
	}

	// 2ノルム相対残差
	public double getRelativeResidualOfTwoNorm(Matrix a, Vector b) {
		return this.residual(a, b).getEuclideanNorm() / b.getEuclideanNorm();
	}

	// 無限大ノルム相対残差
	public double getRelativeResidualOfInfinityNorm(Matrix a, Vector b) {
		return this.residual(a, b).getInfinityNorm() / b.getInfinityNorm();
	}

}
