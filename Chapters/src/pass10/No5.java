package pass10;

public class No5 {

	public static void main(String[] args) {
		String[] name = { "田中", "前田", "鈴木", "中村", "田辺", "浦川", "島田", "岩田" };
		int[] drinking = { 7, 0, 3, 3, 2, 0, 0, 6 };
		int[] smoking = { 60, 10, 0, 20, 10, 0, 30, 0 };
		String[] status = new String[name.length];
		for (int i = 0; i < name.length; i++) {
			int d = drinking[i];
			int s = smoking[i];
			String st = status[i];
			if (d > 3 || s > 20) {
				st = "要検査";
			} else if (d > 0 && s > 0) {
				st = "要指導";
			} else if (d == 0 ^ s == 0) {
				st = "注意";
			} else {
				st = "安全";
			}
			System.out.println(name[i] + "(" + d + " , " + s + ")" + " " + st);
		}
	}

}