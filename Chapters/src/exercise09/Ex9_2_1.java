package exercise09;

import lib.Input;

public class Ex9_2_1 {

	public static void main(String[] args) {
		double x;
		while ((x = Input.getDouble("正の実数を入力してください")) != 0) {
			System.out.println("ルート" + x + "は" + Math.sqrt(x));

		}
	}

}
