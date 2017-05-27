package l01;

public class FizzBuzz {

	public static void main(String[] args) {

		for (int i = 1; i <= 100; i++) { // int型のiを1から100まで定義して、1足していく(++は+1の意味)

			// if (i % 3 == 0 && i % 5 == 0) { // iを3で割ったあまりが0 かつ iを5で割ったあまりが0
			if (i % 15 == 0) { // iを15で割ったあまりが0
				System.out.println("FizzBuzz"); // FizzBuzzと表示する
			} else if (i % 3 == 0) { // iを3で割ったあまりが0
				System.out.println("Fizz"); // Fizzと表示する
			} else if (i % 5 == 0) { // iを5で割ったあまりが0
				System.out.println("Buzz"); // Buzzと表示する
			} else {
				System.out.println(i); // iと表示する
			}

		}

	}
}
