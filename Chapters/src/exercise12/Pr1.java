package exercise12;

public class Pr1 {
	public static void main(String arg[]) {
		double r = 10.0;
		double v = 4.0 * Math.PI * r * r * r / 3.0;
		System.out.println("体積はlnで" + v);
		System.out.printf("体積は%f\n", v);
		System.out.printf("体積は%.8f", v);

	}
}
