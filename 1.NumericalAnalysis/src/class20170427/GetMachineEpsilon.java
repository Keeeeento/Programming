package class20170427;

public class GetMachineEpsilon {

	public static void main(String[] args) {

		double e = 1.0;

		while (1.0 + e != 1.0) {
			e /= 2.0;
		}

		double eps = 2.0 * e;
		System.out.println("machineEpsilon = " + eps);

	}

}
