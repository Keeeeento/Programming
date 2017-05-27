package l05;

public class Main3 {
	public static void main(String[] args) {
		/*
		 * Human h1 = new Human(21, "石井翔", "男", new Day(1994, 9, 22)); Human h2
		 * = new Human(21, "星野雄哉", "男", new Day(1994, 9, 21));
		 * System.out.println(h1.name); System.out.println(h2.name); h1.name =
		 * "王一道"; System.out.println(h1.name);
		 */

		Human h1 = new Human(21, "星野雄哉", "男", new Day(1994, 9, 21));
		Human h2 = new Human(h1.age, h1.name, h1.sex, new Day(h1.birthday.year, h1.birthday.month, h1.birthday.day));
		//h1.sex = "女";
		System.out.println(h1.toString());
		System.out.println(h2.toString());
	}
}