package sample09;

import lib.Input;

public class DoWhileSample {

	public static void main(String[] args) {
		int cmd;
		do {
			System.out.println("何かの処理");
			cmd = Input.getInt("繰り返しますか? Yes -> 1,No -> other");

		} while (cmd == 1);
	}

}
