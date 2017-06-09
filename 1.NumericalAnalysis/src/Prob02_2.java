package problems;

public class Prob02_2 {

	public static void main(String[] args) {
		// 近い値同士の減算を行うときに、桁落ちが発生してしまう。
		// f = 0.4996003610813205
		// g = 0.4999999999999995
		// 絶対誤差 : 3.996389186790017E-4
		// 相対誤差 : 7.992778373580042E-4

		double x = Math.pow(10, -7);

		double fx = (1 - Math.cos(x)) / (x * x);
		double gx = (Math.sin(x) * Math.sin(x)) / (x * x * (1 + Math.cos(x)));
		double error = Math.abs(fx - gx);

		System.out.println("f = " + fx);
		System.out.println("g = " + gx);
		System.out.println("絶対誤差 : " + error);
		System.out.println("相対誤差 : " + error / gx);

	}
}
