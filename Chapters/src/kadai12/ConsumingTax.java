package kadai12;

import lib.Input;

public class ConsumingTax {

	public static void main(String[] args) {
		int n, total = 0;
		do {
			n = Input.getInt();
			total = total + n;
		} while (n > 0);
		System.out.println("合計（税込み）=" + (int) (total * 1.08));

		double a = 100 + 680 + 1980;
		double b = a * 1.08;
		int c = (int) b;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

	}

}
