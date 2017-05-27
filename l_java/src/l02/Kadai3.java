package l02;

import java.util.Scanner;

public class Kadai3 {
	public static void main(String[] args) {
		int a;// a は初項
		Scanner scan = new Scanner(System.in);
		a = scan.nextInt();
		scan.close();

		while (a != 1) {

			if (a % 2 == 0) {
				a = a / 2;
			} else {
				a = 3 * a + 1;
			}
			System.out.println(a);
		}
	}
}

