package sample09;

import lib.Input;

public class WhileSample {

	public static void main(String[] args) {
		/*
		 * int n=Input.getInt(); System.out.println(n+"を入力");
		 *
		 * while(n!=0){ n=Input.getInt(); System.out.println(n+"を入力"); }
		 */

		/*
		 * int n; while ((n = Input.getInt()) != 0) { System.out.println(n +
		 * "を入力"); // }
		 */

		int n;
		do {
			n = Input.getInt();
			System.out.println(n + "を入力");
		} while (n != 0);
	}

}
