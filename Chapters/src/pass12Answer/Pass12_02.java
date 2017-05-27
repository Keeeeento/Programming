package pass12Answer;

import lib.Input;

public class Pass12_02 {

	public static void main(String[] args) {
		String s = Input.getString("テストする文字列");
		String s2 = isEmpty(s) ? "nullまたは空" : "nullでも空でもない";
		System.out.println(s2);
	}

	public static boolean isEmpty(String s) {
		return s == null || s.length() == 0;

	}
}
