package l02;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		int p;
		Scanner scan = new Scanner(System.in);
		p = scan.nextInt();
		scan.close();

		int q[] = new int[p - 1];

		for (int n = 2; n < p; n++) {
			q[n - 2] = p % n;
		}
		for (int m = 0; m < p - 1; m++) {
			if (q[m] == 0) {
				System.out.println("p is NOT a member of prime numbers");
			}

			else {
				System.out.println("p is a member of prime numbers");
			}

		}

	}
}
