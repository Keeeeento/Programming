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
			System.out.printf("近似解 = %.7e, 残差 = %.3e, 絶対誤差 = %.2e, 反復回数 = %d\n", x, residual, relativeError, count);

		} while (Math.abs(residual) >= eps && (count <= maxCountNum));

	}

	public static double f(double x) {
		return Math.pow(x, 3) + Math.pow(x, 2) - 5 * x + 3;
	}

	public static double df(double x) {
		return 3 * x * x + 2 * x - 5;

	}

	// 【解答の概略】
	// (1) 初期値 x 0 = −30 のとき，近似解は −3.0000000000000004 ，反復回数は 11 回．
	// 初期値 x 0 = 30 のとき，近似解は 1.0000002878165282 ，反復回数は 29 回．
	// (2) 真の解は α = −3, 1 （重根）．
	// (3) 初期値 x 0 = −30 のとき，
	// |e 7 | = 1.29e − 01
	// |e 8 | = 7.64e − 03
	// |e 9 | = 2.90e − 05
	// |e 10 | = 4.21e − 10
	// |e 11 | = 4.44e − 16
	// 初期値 x 0 = 30 のとき，
	// |e 25 | = 4.61e − 06
	// |e 26 | = 2.30e − 06
	// |e 27 | = 1.15e − 06
	// |e 28 | = 5.76e − 07
	// |e 29 | = 2.88e − 07
	// (4) α = −3 に対して， p = 2 ， C k =
	// ?
	// 2
	// 3x k + 5
	// ? ．
	// α = 1 に対して， p = 1 ， C k =
	// ?
	// 2x k + 2
	// 3x k + 5
	// ? ．
	// (5) 考察の例：
	// (2), (4) より，理論的には α = −3 に 2 次収束し， α = 1 （重根）に 1 次収束する．実際に，
	// (1) と (3) の結果から， x 0 = −30 の場合には −3 に収束し，解の近傍において誤差の指数
	// 部がおよそ 2 倍ずつ減少（ 2 次収束）している様子が分かる．同様に， x 0 = 30 の場合に
	// は 1 に収束し，誤差がおよそ 1/2 倍ずつ減少（ 1 次収束）している． lim k→∞ x k = 1 とす
	// ると， lim k→∞ C k = 1/2 であるから，理論的な収束率と実際の誤差の減少率が一致してい
	// ることが確認できる．
	// 注）上記は考察の一例です．各自より詳細に考察してみて下さい．例えば， 1 次収束と 2
	// 次収束の場合について，誤差の履歴をグラフにすると，それぞれどのような振る舞いを
	// するでしょうか．また，許容誤差が ε = 10 −12 であるのに， x 0 = 30 の場合に近似解の有
	// 効桁数が 7 桁程度しかないのはなぜでしょうか．

}