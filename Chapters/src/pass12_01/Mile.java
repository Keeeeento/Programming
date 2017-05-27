package pass12_01;

import lib.Input;

public class Mile {

	public static void main(String[] args) {

		double mile = Input.getDouble("mile");
		mileToKm(mile);
	}

	public static void mileToKm(double mile) {
		double km = mile * 1.609344;
		System.out.println(mile + "マイル = " + km + "キロ");
	}
}
