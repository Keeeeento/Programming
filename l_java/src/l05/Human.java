package l05;

class Human {
	int age;
	String name;
	String sex;
	Day birthday;

	public String toString() {
		return this.name + "(" + this.age + "歳・" + this.sex + "・" + this.birthday + ")";
		// 表示の仕方
	}

	Human(int toshi, String namae, String seibetsu, Day day) {
		this.age = toshi;
		this.name = namae;
		this.sex = seibetsu;
		this.birthday = day;
		// 書き方
	}
}