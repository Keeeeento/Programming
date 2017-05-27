package sample10;

import lib.Input;

public class Vote {

	public static void main(String[] args) {
		int num = Input.getInt();
		if (num == 1) {
			System.out.println("賛成");
		} else if (num == 2) {
			System.out.println("反対");
		} else if (num == 3) {
			System.out.println("放棄");
		} else {
			System.out.println("無効");
		}
	}

}
