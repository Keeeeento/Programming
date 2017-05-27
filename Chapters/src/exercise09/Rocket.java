package exercise09;

import lib.Input;

public class Rocket {

	public static void main(String[] args) {
		int a = Input.getInt("ロケット発射までの時間");
		System.out.println("ロケット発射" + a + "秒前!");
		for (int i = a - 1; i > 0; i--) {
			System.out.println(i + "秒前");

		}
		System.out.println("発射!");
		
		

		int b = Input.getInt("ロケット発射までの時間");
		System.out.println("ロケット発射" + b + "秒前!");
		int j = b - 1;
		while (j > 0) {
			System.out.println(j + "秒前");
			j--;
		}
		System.out.println("発射!");

	}

}
