package sample11;

import lib.Input;

public class ContinueSample {

	public static void main(String[] args) {
		int data, total = 0;
		while ((data = Input.getInt("正の値を入力")) != 0) {
			if (data < 0) {
				System.out.println("不正なデータ:" + data);
				continue;
			}
			total += data;

		}
		System.out.println("合計=" + total);

	}

}
