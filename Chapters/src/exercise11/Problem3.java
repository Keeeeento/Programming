package exercise11;

import lib.Input;

public class Problem3 {

	public static void greet(String name, int num) {
		switch (num) {
		case 1:
			System.out.println("こんにちは" + name + "くん");
			break;
		case 2:
			System.out.println("こんにちは" + name + "さん");
			break;
		default:
			System.out.println("エラー");
		}
		return;

	}

	public static void greet2(String name, int num) {
		if (num == 1) {
			System.out.println("こんにちは" + name + "くん");
		} else if (num == 2) {
			System.out.println("こんにちは" + name + "さん");
		} else {
			System.out.println("エラー");
		}
		return;
	}

	public static void main(String[] args) {
		String name = Input.getString("名前を入力");
		int num = Input.getInt("男->1,女->2");
		greet(name, num);

	}

}
