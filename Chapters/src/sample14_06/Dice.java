package sample14_06;

public class Dice {
	private int val; // 目数を表すフィールド変数
	private int color; // サイコロの目を表すフィールド変数

	public Dice(int val, int color) {
		this.val = val;
		this.color = color;
	}

	public Dice(int val, String color) { // 目数と色を指定するコンストラクタ
		this.val = val; // 引数のvalを目数にセット
		if (color.equals("白"))
			this.color = 1;
		else
			this.color = 2;
		// 白でなければ黒と判断する
	}

	public Dice() { // 指定のないコンストラクタ
		this(1, 1); // 目数は1,色は白にする
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

	private String[] str = { "白", "黒", "イエロー", "シアン", "マゼンダ", "レッド", "グリーン" };

	public String getColor() { // colorのゲッター
		return str[color - 1];
	}

	public int getColorCode() {
		return color;
	}

	public void setColor(String color) { // colorのセッター
		for (int i = 0; i < str.length; i++) {
			if (color == str[i]) {
				this.color = i + 1;
				break;
			}
		}

	}// ストリング型のcolorが引数としてあたえられたときに、その色に対応する整数をフィールド変数colorに代入するにはどうしたらよいか。

	public void setColorCode(int color) {
		this.color = color;
	}
}
