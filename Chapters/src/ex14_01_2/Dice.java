package ex14_01_2;

public class Dice {

	int val; // 目数を表すフィールド変数

	// コンストラクタ
	public Dice(int val) {
		this.val = val;
	}

	public void play() {
		val = (int) (Math.random() * 6) + 1; // 1~6 のいずれかを val に代入
	} // 目数を変更するインスタンスメソッド

}
