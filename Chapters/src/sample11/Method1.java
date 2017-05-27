package sample11;

public class Method1 {

	public static void main(String[] args) {
		System.out.println("start");
		display();
		System.out.println("end");
	}

	public static void display() {
		System.out.println("こんにちは！");
		return;
	}
	// Methodは上に書いても同じことが実行される．

}
