package pass10;

import lib.Input;

public class No3 {

	public static void main(String[] args) {
		int month;
		String season;
		while ((month = Input.getInt("月を入力してください")) != 0) {
			switch (month) {
			case 12:
			case 1:
			case 2:
				season = "冬";
				break;
			case 3:
			case 4:
			case 5:
				season = "春";
				break;
			case 6:
			case 7:
			case 8:
				season = "夏";
				break;
			case 9:
			case 10:
			case 11:
				season = "秋";
				break;
			default:
				season = "?";
			}
			System.out.println(month + "月は" + season + "です.");
		}
	}

}
