package sample14_04;

public class Dice {
	int val;
	String color;

	// 1つ目のコンストラクタ（目数と色を指定：一番引数が多い）
	public Dice(int val, String color) {
		this.val = val; // 引数のvalを目数にセット
		this.color = color; // 引数のcolorを色にセット
	}

	// 2つ目のコンストラクタ（色だけを指定）
	public Dice(String color) {
		this(1, color); // 目数は1にする
	}

	// 3つ目のコンストラクタ(指定なし)
	public Dice() {
		this(1, "白"); // 目数は1、色は白にする
	}

	// 目数を変更するインスタンスメソッド
	public void play() {
		val = (int) (Math.random() * 6) + 1;
	}

}
