package pass10;

import lib.Input;

public class No2 {
	public static void main(String[] args) {
		double dis = Input.getDouble("距離[km]を入力してください");
		int charge;
		if (dis < 50) {
			charge = 300;
		} else if (dis < 100) {
			charge = 500;
		} else if (dis < 500) {
			charge = 700;
		} else {
			charge = 1000;
		}
		System.out.println(dis + "[km]での料金は" + charge + "円です.");
	}
}
