package sample10;

import lib.Input;

public class Grade {

	public static void main(String[] args) {
		int score = Input.getInt("得点");
		String grade;
		if (score >= 90) {
			grade = "S";
		} else if (score >= 80) {
			grade = "A";
		} else if (score >= 70) {
			grade = "B";
		} else if (score >= 60) {
			grade = "C";
		} else if (score >= 0) {
			grade = "D";
		} else {
			grade = "-";
		}
		System.out.println("成績は" + grade + "です.");
	}

}
