package sample04;

public class Operation {

	public static void main(String[] args) {

		double x = 20.0, y = 4.0;
		double a, b, c;

		a = x + y - 3.0; // 加減算
		b = x / y * 5.0; // 乗除算
		c = x / (y * 5); // ()を使える

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

		System.out.println(10 % 4); // 剰余
		System.out.println(-1 % 3); // 剰余（負の数）
	}

}
