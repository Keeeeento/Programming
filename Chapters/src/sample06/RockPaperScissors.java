package sample06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class RockPaperScissors {

	public static void main(String[] args) throws IOException {
		System.out.println("数字を入れてね");
		System.out.println("0 :グー\n1 :パー\n2 :チョキ");
		System.out.print("入力＞");
		int i;

		Random rnd = new Random();
		int r = rnd.nextInt(3);

		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		String str = br.readLine();
		i = Integer.parseInt(str);

		System.out.println("相手 :" + r);

		if (i == 0) {
			if (r == 0) {
				System.out.println("あいこ");
			} else if (r == 1) {
				System.out.println("あなたの負け");
			} else {
				System.out.println("あなたの勝ち");
			}
		} else if (i == 1) {
			if (r == 0) {
				System.out.println("あなたの勝ち");
			} else if (r == 1) {
				System.out.println("あいこ");
			} else {
				System.out.println("あなたの負け");
			}

		} else if (i == 2) {
			if (r == 0) {
				System.out.println("あなたの負け");
			} else if (r == 1) {
				System.out.println("あなたの勝ち");
			} else {
				System.out.println("あいこ");
			}

		}
	}
}