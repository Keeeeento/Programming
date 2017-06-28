package mathlib;

public class Check {
	public static void main(String[] args) {
		double[][] data = { { 1, 1, 9 }, { 0, -2, 3 }, { 2, 9, 1 } };
		Matrix a = new Matrix(data);
		Matrix b = new Matrix(new double[][] { { 2, 5, 4 }, { 5, 7, 3 }, { 2, 9, 7 } });
		a.scalarMultiple(3);
		a.print("a");
		a.addition(b).print();
		a.print("a");

		Vector x = new Vector(new double[] { 1, 2, 3 });
		x.print("x");
		Vector y = new Vector(new double[] { 4, 5, 6 });
		y.print("y");

	}

}
