package sample06;

import lib.Input;

public class InputExample {

	public static void main(String[] args) {
		double x = Input.getDouble("1辺の長さ"); // double型の数値を入力してxに代入
		double s = Math.pow(x, 2); // xを2乗した値をsに代入
		System.out.println("一辺" + x + "の正方形の面積は" + s + "\n");

		String name = Input.getString("お名前");
		System.out.println("あなたのお名前は" + name + "さんですね");

	}

}
