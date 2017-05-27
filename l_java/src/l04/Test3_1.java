package l04;

public class Test3_1 {

	public static void main(String[] args) {
		int[] b = { 1, 3, 61, 4, 73, 6, 30 };
		System.out.println(maximum(b));

	}

	public static int maximum(int[] a) {

		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}

		}
		return max;
	}

}