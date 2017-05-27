package sample10;

import lib.Input;

public class Vote2 {
	public static void main(String[] args) {
		int sansei = 0;
		int hantai = 0;
		int date;
		while ((date = Input.getInt("投票")) != 0) {
			if (date == 1) {
				sansei++;
			} else {
				hantai++;
			}
		}
		System.out.println("賛成数は" + sansei);
		System.out.println("反対数は" + hantai);

	}
}
