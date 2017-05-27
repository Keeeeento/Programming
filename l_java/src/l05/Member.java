package l05;

class Member {
	String name;
	String pos;

	public void sayHello() {
		System.out.print("Hello!");
		return;
	}

	Member(String str, String position) {
		this.name = str;
		this.pos = position;
	}

	Member(String str) {
		this.name = str;
		this.pos = "平部員";
	}
}