package sample15_03;

import lib.Input;

public class Exec {

	public static void main(String[] args) {
		double[] data = new double[5];

		for (int i = 0; i < data.length; i++) {
			data[i] = Input.getDouble("値");
		}

		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}

}
