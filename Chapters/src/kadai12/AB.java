package kadai12;

public class AB {

	public static void main(String[] args) {
		int a = 3;
		int b = 5;
		boolean x1 = a <= b - 2;
		System.out.println(x1);
		boolean x3 = a % 2 == b % 2;
		System.out.println(x3);
		boolean x2 = a + 1 != b - 1;
		System.out.println(x2);
		boolean x4 = a < 3 || !(b == 0);
		System.out.println(x4);
		boolean x5=a!=0||b%4==2&&a*2<b;
		System.out.println(x5);
	}

}
