package problems;

public class Prob02_1 {

	public static void main(String[] args) {
		// 左辺 = 0.8
		// 右辺 = 0.7999999999999999
		// false

		double a, b, c;
		a = 0.1;
		b = 0.3;
		c = 0.4;

		double leftSide = (a + b) + c;
		double rightSide = a + (b + c);

		System.out.println("左辺 = " + leftSide);
		System.out.println("右辺 = " + rightSide);
		System.out.println("Boolean 右辺=左辺? = " + (leftSide == rightSide));

	}
}
