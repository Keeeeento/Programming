package l04;

public class Test3_2 {
	public static void main(String[] args) {
		int[] x = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("合計は"+sum(x));
		System.out.println("平均は"+average(x));
	}

	public static int sum(int[] a) {
		int s = 0;
		for (int i = 0; i < a.length; i++) {
			s += a[i];
		}
		return s;

	}

	public static int average(int[] b){
		int v = sum(b)/b.length;
		return v;
	}
}
