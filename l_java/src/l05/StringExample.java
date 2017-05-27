package l05;

public class StringExample {
	public static void main(String[] args) {
		String x = "Hello";
		String[] y = { "Hello" };
		method1(x); // 引数 x は参照型
		System.out.println(x);

		method1(y[0]); // 引数 y[0] は参照型
		System.out.println(y[0]);

		method2(y); // 引数 y は参照型
		System.out.println(y[0]);
	}

	public static void method1(String a) {
		a += "!";
		return;
	}

	public static void method2(String[] a) {
		a[0] += "!";
		return;
	}
}