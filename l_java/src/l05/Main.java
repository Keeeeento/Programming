package l05;

public class Main {

	public static void main(String[] args) {
		Day d = new Day(2016, 5, 21);
		System.out.println(d);

		Day d_2 = new Day(1995, 6, 12);
		Human h = new Human(20, "鈴木花子", "女", d_2);
		System.out.println(h.toString()); // toStringはなくてもJavaが勝手に処理

	}

}
