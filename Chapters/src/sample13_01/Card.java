package sample13_01;

public class Card {
	String suit; // 種類を表すフィールド変数
	int number; // 数を表すフィールド変数

	public void disp() {
		System.out.println("種類 = " + suit);
		System.out.println("番号 = " + number);
	}

	// public void main(String arg[]){
	// Card card = new Card();
	// card.suit = "スペード";
	// card.number = 1;
	// disp();
	// }

}
