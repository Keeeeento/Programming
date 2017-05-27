package sample16_01;

public class Dice {

	private int val; // 目数
	private String color; // サイコロの色

	public Dice(int val, String color) { // 目数と色を指定するコンストラクタ
		this.val = val; // 引数のvalを目数にセット
		this.color = color; // 引数のcolorを色にセット
	}

	public Dice() {
		this(1, "白");
	}

	public void play() {
		val = (int) (Math.random() * 6) + 1;
	}

	public int getVal() {
		return val;
	}

	public String getColor() {
		return color;
	}

	public static void main(String args[]) {
		Dice dice = new Dice();
		dice.play();
		System.out.println("目数 = " + dice.getVal() + "/ 色 = " + dice.getColor());
	}
}
