package sample14_01;

public class Exec {

	public static void main(String[] args) {
		Dice dice = new Dice(1); // Dice オブジェクトを作り、val の初期値として 1 を設定

		// dice.val=1; // dice のフィールド変数 val に 1 をセット
		System.out.println("目数 = " + dice.val); // 表示
	}

}
