package sample15_01;

public class Exec {

	public static void main(String[] args) {
		Dice dice1 = new Dice();
		Dice dice2 = dice1;

		dice1.play();

		System.out.println("dice1.getVal() = " + dice1.getVal());
		System.out.println("dice2.getVal() = " + dice2.getVal());
	}

}
