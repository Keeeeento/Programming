package sample15_04;

public class Exec {

	public static void main(String[] args) {

		int[] number;
		number = new int[] { 1, 2, 3, 4, 5 };

		int[] number2;
		number2 = number;
		System.out.println("number");
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + " ");
		}

		System.out.println("\nnumber2");
		for (int i = 0; i < number2.length; i++) {
			System.out.print(number2[i] + " ");
		}
	}

}
