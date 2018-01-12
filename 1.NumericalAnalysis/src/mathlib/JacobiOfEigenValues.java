package mathlib;

public class JacobiOfEigenValues {

	static double epsilon = 1e-10;
	static int k = 0, m = 0;
	static double sign = 1.0; // 符号
	static double cos, sin;
	static int count = 0;
	static int maxIteration = (int) 1e+04;
	static boolean isConverced;

	static Matrix p; // gigens

	public static Matrix givensRotation(Matrix a) {

		int n = a.getN();
		Matrix p = new Matrix(n);
		double alpha = a.getData()[0][1];

		// 非対角成分の絶対値の最大の成分の検出
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					if (Math.abs(a.getData()[i][j]) >= Math.abs(alpha)) {
						alpha = a.getData()[i][j];
						k = i;
						m = j;
					}
				}
			}
		}

		System.out.printf("k = %d, m = %d%n", k, m);

		double akkamm = a.getData()[k][k] - a.getData()[m][m];
		sign = (akkamm < 0) ? -1.0 : 1.0;
		if (akkamm < 1e-15) { // a_{ii} == a_{jj}
			double phi = Math.PI / 4.0;
			cos = Math.cos(phi);
			sin = Math.sin(phi);
		} else {
			double amk = a.getData()[m][k];
			double b = akkamm / 2.0;
			cos = Math.sqrt((1.0 + sign * b / (b * b + amk * amk) / 2.0));
			sin = Math.sqrt(sign * amk / (2.0 * Math.sqrt(b * b + amk * amk) * cos));
		}

		for (int i = 0; i < n; i++) {
			p.getData()[i][i] = 1.0;
			for (int j = 0; j < n; j++) {
				if (i == k) {
					if (j == k) {
						p.getData()[i][j] = cos;
					}
					if (j == m) {
						p.getData()[i][j] = -sin;
					}
				}
				if (i == m) {
					if (j == k) {
						p.getData()[i][j] = sin;
					}
					if (j == m) {
						p.getData()[i][j] = cos;
					}
				}
			}
		}

		return p;
	}

	public static Matrix getEigenValuesByJacobiMethod(Matrix matrix) {
		Matrix a = matrix.copy();
		int n = a.getN();
		Matrix p = new Matrix(n);

		double alpha = a.getData()[0][1];

		for (count = 0; count <= maxIteration; count++) {
			// 非対角成分の絶対値の最大の成分の検出
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i != j) {
						if (Math.abs(a.getData()[i][j]) >= Math.abs(alpha)) {
							alpha = a.getData()[i][j];
							k = i;
							m = j;
						}
					}
				}
			}

			double akkamm = a.getData()[k][k] - a.getData()[m][m];
			if (akkamm < 1e-14) { // a_{ii} == a_{jj}
				double phi = Math.PI / 4.0;
				cos = Math.cos(phi);
				sin = Math.sin(phi);
			} else {
				sign = (akkamm < 0) ? -1.0 : 1.0;
				double amk = a.getData()[m][k];
				double b = akkamm / 2.0;
				cos = Math.sqrt((1.0 + sign * b / (b * b + amk * amk) / 2.0));
				sin = Math.sqrt(sign * amk / (2.0 * Math.sqrt(b * b + amk * amk) * cos));
			}

			// 行列pの作成(givens回転行列)
			for (int i = 0; i < n; i++) {
				p.getData()[i][i] = 1.0;
			}
			p.getData()[k][k] = cos;
			p.getData()[k][m] = -sin;
			p.getData()[m][k] = sin;
			p.getData()[m][m] = cos;

			// aの更新
			a.getData()[k][k] = cos * cos * a.getData()[k][k] - 2.0 * cos * sin * a.getData()[k][m]
					+ sin * sin * a.getData()[m][m]; // a_kk
			a.getData()[m][m] = cos * cos * a.getData()[k][k] + 2.0 * cos * sin * a.getData()[k][m]
					+ sin * sin * a.getData()[m][m]; // a_mm
			double value = (cos * cos - sin * sin) * a.getData()[k][m]
					+ cos * sin * (a.getData()[k][k] - a.getData()[m][m]);
			a.getData()[k][m] = value; // a_km
			a.getData()[m][k] = value; // a_mk

			for (int i = 0; i < n; i++) {
				if (i != k && i != m) {
					value = cos * a.getData()[k][i] - sin * a.getData()[m][i];
					a.getData()[i][k] = value; // a_ik
					a.getData()[k][i] = value; // a_ki

					value = sin * a.getData()[k][i] + cos * a.getData()[m][i];
					a.getData()[i][m] = value; // a_im
					a.getData()[m][i] = value; // a_mi
				}
			}

			// 収束判定条件(非対角成分各々が十分小さい)
			isConverced = true;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i != j) {
						if (Math.abs(a.getData()[i][j]) > epsilon) {
							isConverced = false;
						} else {
							isConverced = isConverced && true;
						}
					}
				}
			}
			//			System.out.println("isConverced = " + isConverced);
			if (isConverced) {
				break;
			}
		}

		return a;

	}

	//これを使いたい
	private static void solve(Matrix a) {
		int n = a.getN();
		p = new Matrix(n);

		for (count = 0; count <= maxIteration; count++) {

			// System.out.printf("%d回目%n", count);
			// 非対角成分の絶対値の最大の成分A_{(k,m)}の検出
			double alpha = a.getData()[0][1]; // 非対角成分での初期化
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i != j) {
						if (Math.abs(a.getData()[i][j]) >= Math.abs(alpha)) {
							alpha = a.getData()[i][j];
							k = i;
							m = j;
						}
					}
				}
			}

			// System.out.printf("k = %d,m = %d%n%n", k, m);

			double akkamm = a.getData()[k][k] - a.getData()[m][m];
			if (akkamm < 1e-14) { // a_{ii} == a_{jj}
				double phi = Math.PI / 4.0;
				cos = Math.cos(phi);
				sin = Math.sin(phi);
			} else {
				sign = (akkamm < 0) ? -1.0 : 1.0;
				double amk = a.getData()[m][k];
				double b = akkamm / 2.0;
				cos = Math.sqrt((1.0 + sign * b / (b * b + amk * amk) / 2.0));
				sin = Math.sqrt(sign * amk / (2.0 * Math.sqrt(b * b + amk * amk) * cos));
			}

			// 行列pの作成(givens回転行列)
			p = Matrix.identity(n);
			p.getData()[k][k] = cos;
			p.getData()[k][m] = -sin;
			p.getData()[m][k] = sin;
			p.getData()[m][m] = cos;

			a = p.transpose().multiply(a.multiply(p));
			// 収束判定条件(非対角成分各々が十分小さい)
			isConverced = true;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i != j) {
						if (Math.abs(a.getData()[i][j]) > epsilon) {
							isConverced = false;
						} else {
							isConverced = isConverced && true;
						}
					}
				}
			}
			//			System.out.println("isConverced = " + isConverced);
			if (isConverced) {
				break;
			}
		}

	}

	public static Matrix getGivens(Matrix a) {
		Matrix matrix = a.copy();
		solve(matrix);
		return p;
	}

	public static Matrix getEigenVectors(Matrix a) {
		Matrix matrix = a.copy();
		solve(matrix);
		return matrix;
	}

	public static void main(String[] args) {
		double[][] data = {
				{ 0, 1, 2, 1 },
				{ 1, 0, 1, 2 },
				{ 2, 1, 0, 1 },
				{ 1, 2, 1, 0 } };
		Matrix a = new Matrix(data);
		a.print("a");
		a.transpose().print("atrans");

		JacobiOfEigenValues.getEigenVectors(a).print("a");
		JacobiOfEigenValues.getGivens(a).print("p");

	}
}