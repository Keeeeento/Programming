package sample09;

import lib.Input;

public class DoWhileSample2 {

	public static void main(String[] args) {
		int cmd;
		int a = Input.getInt("aの値");

		do {
			System.out.println();
			System.out.println("aの値は" + a + ",aの二乗は" + a * a);
			a = a * a;
			System.out.println("aの二乗をaに上書きしました");
			cmd = Input.getInt("冪乗を計算しますか? Yes -> 1, No ->other");
		} while (cmd == 1);

	}

}
