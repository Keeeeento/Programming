package l05;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Member[] list = new Member[100];
		int iterator = 0;
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("どうする？\n1.部員追加\n2.部員表示\n3.終了");
			int a = scan.nextInt();
			if (a == 1) {
				System.out.println("名前を入力してください");
				String namae = scan.next();
				System.out.println("役職はある？\n1.ある\n2.ない");
				int b = scan.nextInt();
				if (b == 1) {
					System.out.println("役職名を入力してください");
					String s = scan.next();
					list[iterator] = new Member(namae, s);
				} else {
					list[iterator] = new Member(namae);
				}
				iterator++;
			} else if (a == 2) {
				for (int i = 0; i < iterator; i++) {
					System.out.println(list[i].pos + "の" + list[i].name);
				}
			} else if (a == 3) {
				System.out.println("さようなら");
				scan.close();
				break;
			} else {
				System.out.println("最初からやり直してください");
			}
		}
	}
}