package sample13_01;

public class Dice {
	int val; // 目数を表すフィールド変数

	public void play() { // 目数を変更するインスタンスメソッド
		val = (int) (Math.random() * 6) + 1;
	}
}
