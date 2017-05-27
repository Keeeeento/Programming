package sample15_05;

public class Dice {
	private int val; // 目数を表すフィールド変数
	private String color; // サイコロの目を表すフィールド変数

	public Dice(int val, String color) { // 目数と色を指定するコンストラクタ
		this.val = val; // 引数のvalを目数にセット
		this.color = color; // 引数のcolorを色にセット
	}

	public Dice() { // 指定のないコンストラクタ
		this(1, "白"); // 目数は1,色は白にする
	}

	public void play() { // 目数を変更するインスタンスメソッド
		val = (int) (Math.random() * 6) + 1;
	}

	public int getVal() { // valのゲッター
		return val;
	}

	public void setVal(int val) { // valのセッター
		this.val = val;

	}

	public String getColor() { // colorのゲッター
		return color;
	}

	public void setColor(String color) { // colorのセッター
		this.color = color;
	}
}
