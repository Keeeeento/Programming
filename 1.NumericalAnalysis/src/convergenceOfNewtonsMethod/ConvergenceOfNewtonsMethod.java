package convergenceOfNewtonsMethod;

import lib.Input;

public class ConvergenceOfNewtonsMethod {

	public static void main(String[] args) {

		double x0 = Input.getDouble("初期値x0 = "); // 初期値
		if (Math.abs(x0) != 30) {
			System.out.println("初期値が規格と違います");
		}
		double x = x0; // 近似解

		int maxCountNum = 50;// 最大反復回数
		double eps = 10E-12; // 許容誤差（マシンイプシロン）
		int count = 0; // 反復回数

		double residual = 1; // 残差
		double relativeError = 0; // 絶対誤差

		double alpha; // 真の解
		if (x0 == -30) {
			alpha = -3;
		} else if (x0 == 30) {
			alpha = 1;
		} else {
			alpha = 0; // 初期値が規格外の値
		}
		do {
			x0 = x;
			x += -f(x) / df(x);
			relativeError = Math.abs(x - alpha);
			residual = f(x);
			count++;

			if (count == maxCountNum) {
				System.out.println("最大反復回数に達しました");
				break;
			}
			System.out.printf("近似解 = %.20f, 残差 = %.20f, 絶対誤差 = %.20f, 反復回数 = %d\n", x, residual, relativeError, count);

		} while (Math.abs(residual) >= eps && (count <= maxCountNum));

	}

	public static double f(double x) {
		return Math.pow(x, 3) + Math.pow(x, 2) - 5 * x + 3;
	}

	public static double df(double x) {
		return 3 * x * x + 2 * x - 5;

	}

}