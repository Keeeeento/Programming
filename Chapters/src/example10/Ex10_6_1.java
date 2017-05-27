package example10;

import lib.Input;

public class Ex10_6_1 {

	public static void main(String[] args) {
		int total = 0, count = 0, date;
		while ((date = Input.getInt()) != 0) {
			if (date < 100)
				total += date;
			else
				total += 100;
			count++; // if文の外にあるので、関係なく毎回++している.
		}
		System.out.println(total + "/" + count);
	}

}
