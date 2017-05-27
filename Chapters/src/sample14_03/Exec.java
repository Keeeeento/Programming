package sample14_03;

public class Exec {
	public static void main(String[] args) {

		Dice dice1 = new Dice(6); // 目数を6に指定してオブジェクトを作成
		Dice dice2 = new Dice(); // 目数を指定しない→規定値で1になる

		System.out.println("dice1 = " + dice1.val); // dice1の目数を表示
		System.out.println("dice2 = " + dice2.val); // dice1の目数を表示

	}
}
