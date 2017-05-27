package exercise07;

public class Problem1 {

	public static void main(String args[]) {
		int n = 20; // 第n項までの近似
		int x = 2;
		double e = 1.0;
		double k = 1.0; // kはパラメータ

		for (int i = 1; i < n; i++) {
			k = k * i;
			e = e + Math.pow(x, i) / k;
		}

		System.out.println(e);
		System.out.println(Math.pow(Math.E, 2));
	}

}
