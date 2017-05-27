package sample17_01;

public class Student extends Member {
	private String studentId;

	public Student(int id, String name, String studentId) {
		super(id, name);
		this.studentId = studentId;
	}

	public double discount() {
		return 0.2;
	}

	public String getStudentId() {
		return studentId;
	}
}
