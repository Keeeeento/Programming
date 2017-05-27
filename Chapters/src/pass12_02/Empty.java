package pass12_02;

import lib.Input;

public class Empty {

	public static void main(String[] args) {
		String s = Input.getString("テストする文字列");
		isEmpty(s);
		
	}

	public static boolean isEmpty(String s) {
		if (s == "") {
			return true;
		} else {
			return false;
		}
	}

}
