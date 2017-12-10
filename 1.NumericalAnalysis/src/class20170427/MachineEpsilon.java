package class20170427;

public class MachineEpsilon {

	public static void main(String[] args) {

		double eps = Math.pow(2, -52);
		System.out.println("eps = " + eps);

		System.out.println("(1)" + (1.0 + 1.0 / 2 * eps));
		System.out.println("(1)'" + (1.0 + 3.0 / 4 * eps));
		System.out.println("(2)" + (1.0 + eps));
		System.out.println("(3)" + (2.0 - 1.0 / 2 * eps));
		System.out.println("(3)'" + (2.0 - eps));

	}
}
