package sample13_01;

public class Denpyo {
	String date; // 日付
	String item; // 項目
	int price; // 単価
	int number; // 個数

	public void disp() {
		System.out.print(date);
		System.out.print(" / " + item);
		System.out.print(" / " + price);
		System.out.print(" / " + number);
	}

}
