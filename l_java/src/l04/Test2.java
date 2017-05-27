package l04;

public class Test2 {

	public static void main(String[] args) {

		double[] d = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < d.length; i++) {
			System.out.println(d[i]);
		}

		int[] a = new int[7];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

		boolean[] b = { true, true, false, false };
		for (int i = 0; i < b.length - 1; i++) {
			System.out.println(b[i] && b[i + 1]);
			System.out.println(b[i] || b[i + 1]);
			System.out.println(b[i] ^ b[i + 1]);
		}

		String[] str = { "Hello", "	", "World", "", "!" };
		System.out.print(str.length);

	}

}
