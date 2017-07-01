package mathlib;

public class JacobiMain {
	public static void main(String[] args) {
		double[][] aData = { { 6, 1, 1, 1, 0 }, { 1, 7, 1, 1, 1 }, { 0, 1, 8, 1, 1 }, { 0, 0, 1, 9, 1 },
				{ 0, 0, 0, 1, 10 } };// 行列
		double[] bData = { 9, 11, 11, 11, 11 };// 解
		double[][] aData2 = { { 1, 1, 1, 1, 1 }, { 2, 3, 4, 5, 1 }, { 3, 4, 5, 1, 2 }, { 4, 5, 1, 2, 3 },
				{ 5, 1, 2, 3, 4 } };
		double[] bData2 = { 1, 1, 1, 1, 1 };
		double[][] aData3 = { { 3, 1, 1 }, { 1, 3, 1 }, { 1, 1, 3 } };
		double[] bData3 = { 0, 4, 6 };

		Matrix a = new Matrix(aData3);
		Vector b = new Vector(bData3);

		// a.jacobi(a, b).print("xByJacobi");
		a.gaussSeidel(a, b).print("gaussSeidel");
	}

}
