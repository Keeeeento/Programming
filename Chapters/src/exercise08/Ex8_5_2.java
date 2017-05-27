package exercise08;

public class Ex8_5_2 {

	public static void main(String[] args) {
		int a = 5;
		int b = 0;
		boolean a_1 = !(a <= b + 5);
		boolean a_2 = !(a == b);
		boolean a_3 = a > 0 && b > 0;
		boolean a_4 = a > 0 || b > 0;
		boolean a_5 = !(a > b);
		boolean a_6 = !(a > b) || b == 0;
		System.out.println(a_1);
		System.out.println(a_2);
		System.out.println(a_3);
		System.out.println(a_4);
		System.out.println(a_5);
		System.out.println(a_6);

	}

}
