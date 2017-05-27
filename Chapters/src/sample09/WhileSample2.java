package sample09;

import lib.Input;

public class WhileSample2 {

	public static void main(String[] args) {
		int value, total = 0;
		while ((value = Input.getInt("金額")) != 0) {
			total += value;
		}
		System.out.println("合計=" + total);
	}

}
