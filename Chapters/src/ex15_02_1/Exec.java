package ex15_02_1;

import sample15_01.Dice;

public class Exec {

	public static void main(String[] args) {
		Dice dice = new Dice(1, "白"), dice2;
//		dice = dice2; // dice2が初期化されていない
		System.out.println(dice.getVal());
	}

}
