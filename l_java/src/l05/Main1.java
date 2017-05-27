package l05;

public class Main1 {
	public static void main(String[] args) {
		/*
		 * Day d1 = new Day(1994, 9, 22); System.out.println(d1.toString());
		 *
		 * Human h1 = new Human(21, "石井翔", "男", d1);
		 * System.out.println(h1.toString());
		 */

		Human h1 = new Human(21, "星野雄哉", "男", new Day(1994, 9, 21));
		Human h2 = h1;
		// h1.sex = "女";
		System.out.println(h1.toString());
		System.out.println(h2.toString());
		// Human h1 の中身を変えると Human h2 の中身も変わる（参照渡し）
	}
}