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
		for (int i = 0; i < n; i++) {
			System.out.printf("%.10f ", this.data[i]);
		}
		System.out.println();
		System.out.println();
	}

	public void print(String str) {
		System.out.println(str + " = ");
		this.print();
	}

	// 指数表記
	public void printf() {
		for (int i = 0; i < n; i++) {
			System.out.printf("%.10e ", this.data[i]);
		}
		System.out.println();
		System.out.println();
	}

	public void printf(String str) {
		System.out.println(str + " = ");
		this.printf();
	}

	// 整数表記
	public void printInt() {
		for (int i = 0; i < n; i++) {
			System.out.printf("%d ", (int) this.data[i]);
		}
		System.out.println();
	}

	public void printInt(String str) {
		System.out.println(str + " = ");
		this.printInt();
	}

	// TeX用
	public void printTeX() {

		System.out.println("   \\left(");
		System.out.println("      \\begin{array}{c}");
		for (int i = 0; i < n - 1; i++) {
			System.out.printf("         %.16f \\\\ \n", this.data[i]);
		}
		System.out.printf("         %.16f\n ", this.data[n - 1]);
		System.out.println("      \\end{array}");
		System.out.println("   \\right)");
	}

	public void printTeX(String str) {
		System.out.println(str + " = ");
		this.printTeX();
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

	public static Vector allNumber(int size, double number) {
		Vector x = new Vector(size);
		for (int i = 0; i < size; i++) {
			x.getData()[i] = number;
		}
		return x;
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
	public static double innerProduct(Vector x, Vector y) {
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
		// return this.getNorm(1);
	}

	// 2ノルム
	public double getEuclideanNorm() {
		double norm = 0.0;
		for (int i = 0; i < this.n; i++) {
			norm += this.data[i] * this.data[i];
		}
		return Math.sqrt(norm);
		// return this.getNorm(2);
	}

	// 無限大ノルム
	public double getInfinityNorm() {
		double norm = 0.0;
		for (int i = 0; i < this.n; i++) {
			norm = Math.max(norm, Math.abs(this.data[i]));
		}
		return norm;
		// return this.getNorm(inf);
	}

	// nノルム(n=0のとき無限大ノルムを返す)
	public double getNorm(double normNumber) {
		double norm = 0;
		if (normNumber > 0) {
			for (int i = 0; i < this.n; i++) {
				norm += Math.pow(this.data[i], normNumber);
			}
			norm = Math.abs(Math.pow(norm, 1.0 / normNumber));
		} else if (normNumber == 0) {
			for (int i = 0; i < this.n; i++) {
				norm = Math.max(norm, Math.abs(this.data[i]));
			}
		}
		return norm;
	}

	// nノルム(無限大ノルムは"inf")
	public double getNorm(String normNumber) {
		double norm = 0;
		if (normNumber.equals("inf")) {
			for (int i = 0; i < this.n; i++) {
				norm = Math.max(norm, Math.abs(this.data[i]));
			}
		} else {
			double n = Double.parseDouble(normNumber);
			if (n > 0) {
				for (int i = 0; i < this.n; i++) {
					norm += Math.pow(this.data[i], n);
				}
				norm = Math.pow(norm, 1.0 / n);
			}
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

	// nノルム絶対誤差
	public double getAbsoluteError(double normNumber, Vector x) {
		return subtract(x, this).getNorm(normNumber);
	}

	public double getAbsoluteError(String normNumber, Vector x) {
		return subtract(x, this).getNorm(normNumber);
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

	// nノルムの相対誤差
	public double getRelativeError(double normNumber, Vector x) {
		return this.getAbsoluteError(normNumber, x) / x.getNorm(normNumber);
	}

	public double getRelativeError(String normNumber, Vector x) {
		return this.getAbsoluteError(normNumber, x) / x.getNorm(normNumber);
	}

	// 残差
	public Vector residual(Matrix a, Vector b) {
		return this.subtract(b, a.multiply(a, this));
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

	// nノルム絶対残差
	public double getAbsoluteResidual(double normNumber, Matrix a, Vector b) {
		return this.residual(a, b).getNorm(normNumber);
	}

	public double getAbsoluteResidual(String normNumber, Matrix a, Vector b) {
		return this.residual(a, b).getNorm(normNumber);
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

	// nノルム相対残差
	public double getRelativeResidual(double normNumber, Matrix a, Vector b) {
		return this.residual(a, b).getNorm(normNumber) / b.getNorm(normNumber);
	}

	public double getRelativeResidual(String normNumber, Matrix a, Vector b) {
		return this.residual(a, b).getNorm(normNumber) / b.getNorm(normNumber);
	}

	// 第1成分を1e-3倍
	public Vector deltaAddedVector() {
		int n = this.getData().length;
		Vector b = this.copy();
		Vector delta = new Vector(n);
		b.getData()[0] += 1e-3 * b.getData()[0];
		return b.add(delta);
	}
}
