package mathlib;

public class Test {
	public static void main(String[] args) {

		int n = 10;
		Vector x = Vector.allNumber(n, 2);
		Vector xEcact = Vector.allNumber(n, 2.001);

		System.out.println(x.getRelativeError(1, xEcact));
	}

}
