package exercise06;

import lib.Input;

public class Exercise05_03 {

	public static void main(String[] args) {
		double x = Input.getDouble("xの値");
		double y = Input.getDouble("yの値");
		double answer = Math.pow(x, 3) / Math.pow(y, 3);
		//System.out.println("Math.pow(x, 3) ÷ Math.pow(y, 3) = " + answer);
		System.out.println("x^3 ÷ y^3 = " + answer);

	}

}
