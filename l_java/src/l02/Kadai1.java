package l02;

import java.util.Scanner;

public class Kadai1 {

	public static void main(String[] args) {
		int a, b, c;
		Scanner scan = new Scanner(System.in);
		a = scan.nextInt();
		b = scan.nextInt();
		c = scan.nextInt();
		scan.close();

		if (c > a + b) {
			System.out.println("三角形は生成可能です");
		} else {
			System.out.println("三角形は生成不可能です");
		}

	}
}
