package ex14_02_2;

public class Card {
	String suit;
	int number;

	public Card(String suit, int number) {
		this.suit = suit;
		this.number = number;
	}

	public Card(String suit) { // number は常に1とする
		this(suit, 1);
	}

	public Card(int number) { // suit は常にスペードとする
		this("スペード", number);
	}

	public Card(){

	}

	String face() { // カードを表す文字列を返す
		return suit + "/" + number;
	}

}
