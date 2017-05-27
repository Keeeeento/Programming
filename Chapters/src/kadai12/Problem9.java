package kadai12;

import lib.Input;

public class Problem9 {

	public static void main(String[] args) {
		double x = Input.getDouble("演習課題1の点数");
		double y = Input.getDouble("演習課題2の点数");
		double z = Input.getDouble("到達度評価試験の点数");

		double ave = (x + y + z) / 3;
		System.out.println("平均点は" + ave);

		char seiseki;
		if (ave >= 90) {
			seiseki = 'S';

		} else if (ave >= 80) {
			seiseki = 'A';
		} else if (ave >= 70) {
			seiseki = 'B';
		} else if (ave >= 60) {
			seiseki = 'C';
		} else {
			seiseki = 'D';
		}
		System.out.println("あなたの評価は" + seiseki);
	}

}
