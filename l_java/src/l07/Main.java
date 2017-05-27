package l07;

public class Main {

	public static void main(String[] args) {
		Animal chobi = new Cat("チョビ");
		chobi.naku("鳴け");
		((Cat)chobi).marukunaru("丸くなる");

		Animal pochi = new Dog();
		pochi.naku("鳴くな");
	}

}
