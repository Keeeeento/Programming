package sample08;

import lib.Input;

public class Logic {

	public static void main(String[] args) {
		int x = Input.getInt("xの値");
		int y = Input.getInt("yの値");

		boolean b_1 = x > 0 && x < 20;
		boolean b_2 = x <= 0 || x >= 20;
		boolean b_3 = !(x > 0 && x < 20);
		boolean b_4 = (x == 0) ^ (y == 0);

		System.out.println("x > 0 && x < 20      =" + b_1);
		System.out.println("x <= 0 || x >= 20    =" + b_2);
		System.out.println("!(x > 0 && x < 20)   =" + b_3);
		System.out.println("(x == 0) ^ (y == 0)  =" + b_4);

	}

}
