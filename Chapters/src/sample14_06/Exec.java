package sample14_06;

import sample14_05.Dice;

public class Exec {
	public static void main(String arg[]) {
		Dice dice = new Dice(); // diceオブジェクトを作成
		/*
		 * dice.color="黒"; System.out.println("diceの色="+dice.color); //
		 * diceの色を表示
		 */

		String color = dice.getColor();
		System.out.println("diceの色 = " + color); // diceの色を表示

		dice.setColor("黒"); // diceの色を黒にセット

		color = dice.getColor();
		System.out.println("diceの色 = " + color); // diceの色を表示

		// System.out.println(dice.getColor());

		


	}

}
