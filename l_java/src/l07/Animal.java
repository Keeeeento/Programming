package l07;

public abstract class Animal {
	String name;
	int age;

	public abstract void naku(String str);
}

class Cat extends Animal {
	String name;
	int age;

	public Cat(String name) {
		this.name = name;
	}

	public void naku(String str) {
		System.out.println("meow");
	}

	public void marukunaru(String str) {

		System.out.println(this.name + "のまるくなる！");
		System.out.println(this.name + "のぼうぎょがあがった▽");
	}

}

class Dog extends Animal {
	String name;
	int age;

	public void naku(String str) {
		System.out.println("bow-wow");

	}

}
