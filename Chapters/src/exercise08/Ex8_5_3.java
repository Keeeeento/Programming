package exercise08;

import lib.Input;

public class Ex8_5_3 {

	public static void main(String[] args) {
		int n = Input.getInt("今年は西暦…年");
		boolean b = (n % 4 == 0 || n % 100 != 0) || (n % 400 == 0);
		System.out.println("西暦" + n + "年は閏年であるという命題は" + b + ".");

	}

}
