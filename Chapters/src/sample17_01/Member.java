package sample17_01;

public class Member {
	private int id;
	private String name;

	public Member(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static void main(String[] args) {
		Member member = new Member(118, "田中宏");
		System.out.println(member.getId() + "/" + member.getName());
	}
}
