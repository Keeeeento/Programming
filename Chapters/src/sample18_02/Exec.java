package sample18_02;

import sample17_01.Member;
import sample17_01.Student;

public class Exec {
	public static void main(String[] args) {

		Object obj = new Member(118, "田中宏");

		System.out.println(obj instanceof Object); // Object型かそのサブクラス型
		System.out.println(obj instanceof Member); // Member型かそのサブクラス型
		System.out.println(obj instanceof Student); // Student型かそのサブクラス型

	}
}
