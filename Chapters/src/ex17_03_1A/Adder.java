package ex17_03_1A;

public class Adder {

	int number;

	protected int add(int n) {
		number += n;
		return number;
	}

	int getNumber() {
		return number;
	}

}
