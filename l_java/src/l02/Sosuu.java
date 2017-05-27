package l02;

import java.util.Scanner;

public class Sosuu {

	public static void main(String[] args) {
		int p;
		Scanner scan = new Scanner(System.in);
		p = scan.nextInt();
		scan.close();
		int count = 0;

		for (int n = 2; n < p; n++) {

			if (p % n == 0) {
				count++;
			}
		}

		if (count == 0) {
			System.out.print(p+"は素数.");
		} else {
			System.out.print(p+"は素数でない.");
		}

	}

}
