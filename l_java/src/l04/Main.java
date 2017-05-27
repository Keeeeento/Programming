package l04;

public class Main {

	public static void main(String[] args) {

		// System.out.println("Java");

		double d = 3;
		double d_2 = Math.pow(d, 2); // double型のdの2乗
		System.out.println(d_2);

		double a = 2;
		double a_10 = Math.pow(a, 10);
		System.out.println(a_10);

		double f = Math.pow(8, 1.5);
		System.out.println(f);

		double b = Math.sqrt(2);
		System.out.println(b);

		System.out.println(Math.sqrt(2));

		System.out.println(Math.sqrt(Math.pow(2, 3)));

		String str = jihanki(150);
		System.out.println(str);

		helloWorld();
	}

	public static String jihanki(int x) {
		if (x == 120) {
			return "コーンポタージュ";
		} else if (x == 150) {
			return "コカ・コーラ";
		} else {
			return String.valueOf(x);
		}

	}

	public static void helloWorld() {
		System.out.println("HelloWorld");
		return;
	}

}
