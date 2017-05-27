package sample13_01;

public class Exec {
	public static void main(String arg[]) {
		Dice dice = new Dice(); // Dice オブジェクトを作る

		dice.val = 1; // dice のフィールド変数 val に 1 をセット
		System.out.println("サイコロの目数 = " + dice.val); // 表示

		dice.play(); // dice の play() メソッドを実行(dice の目数をランダムに変更)
		System.out.println("変更後のサイコロの目数 = " + dice.val); // 表示

		System.out.println();

		Card card = new Card();
		card.suit = "スペード";
		card.number = 1;
		System.out.println("トランプの種類 = " + card.suit);
		System.out.println("トランプの札番号 = " + card.number);

		System.out.println();

		card.disp();
	}

}
