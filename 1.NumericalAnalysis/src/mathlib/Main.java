package mathlib;

public class Main {
	public static void main(String[] args) {
		double[][] aData = { { 3, 1, 1 }, { 1, 3, 1 }, { 1, 1, 3 } };
		double[][] bData = { { 3, 1, 1 }, { 1, 3, 1 }, { 1, 1, 3 } };
		Matrix a = new Matrix(aData);
		Matrix b = new Matrix(bData);
		Vector c = new Vector(new double[] { 2, 3, 4 });
		Vector d = new Vector(new double[] { 0, 4, 6 });

		// a.gaussianElimination(a, b).print("x");
		// b.sub(b, c).print();
		// System.out.println(b.getManhattanNorm());
		// a.diagnal().print();
		// System.out.println(b.innerProduct(b, c));

		// a.setEpsilon(1e-12);
		// a.jacobi(a, b).print("jacobi");
		// a.gaussSeidel(a, b).print("gaussSeidel");
		Jacobi.solve(a, d);
		a.gaussSeidel(a, d).print();

	}

}
