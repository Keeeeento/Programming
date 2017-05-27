package sample13_02;

public class Dice {
	int val; // 目数を表すフィールド変数

	public void play() {
		; // 目数を変更するインスタンスメソッド（中身は後で作成）
		val = (int) (Math.random() * 6) + 1;
	}
}
