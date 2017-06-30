package mathlib;

public class Main {
	public static void main(String[] args) {
		double[][] data = { { 3, 4, 1 }, { 2, 1, 2 }, { 1, 2, 3 } };
		Matrix a = new Matrix(data);

		Vector b = new Vector(new double[] { 5, 8, 3 });
		Vector c = new Vector(new double[] { 1, 2, 3 });

		// a.gaussianElimination(a, b).print("x");
		// b.sub(b, c).print();
		// System.out.println(b.getManhattanNorm());
		// a.diagnal().print();
		// System.out.println(b.innerProduct(b, c));

		a.print("a");
		a.jacobi2(a, b).print("jacobi");
		a.print("a");
		a.gaussianElimination(a, b).print("gauss");
		;

	}

}
