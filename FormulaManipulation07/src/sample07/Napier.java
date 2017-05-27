package sample07;

public class Napier {

	public static void main(String[] args) {
		int n = 18;

		double e = 1.0;
		double temp = 1.0;
		/*
		 * for (int i = 1; i < n; i++) { temp = temp / i; // 第(i+1)項 e = e +
		 * temp; // ネイピア数の近似 }
		 */

		System.out.println("Math.Eによる近似値は e ≒ " + Math.E);
		System.out.println("第" + n + "項までの近似値は e ≒ " + e);

		System.out.println(1 + "," + Math.abs(Math.E - e));

		for (int i = 1; i < n; i++) {
			temp = temp / i; // 第(i+1)項
			e = e + temp; // ネイピア数の近似
			System.out.println((i + 1) + "," + (Math.E - e));
		}


	}

}
