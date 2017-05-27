package sample18_01;

import sample17_01.Member;
import sample17_01.Student;

public class Exec {
	public static void main(String[] args) {

		Member member = new Student(118, "田中宏", "A711");
		System.out.println(member.getId() + "/" + member.getName());

//		System.out.println(member.getStudentId());

	}
}
