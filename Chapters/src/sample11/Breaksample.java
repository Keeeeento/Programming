package sample11;

import lib.Input;

public class Breaksample {

	public static void main(String[] args) {

		int data, total = 0;
		while ((data = Input.getInt("正の値を入力")) != 0) {
			if (data < 0) {
				System.out.println("不正なデータ:" + data);
				break;
			}
			total += data;

		}
		System.out.println("合計=" + total);
	}

}
