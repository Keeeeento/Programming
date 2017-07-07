package minitest;

public class FloatNumbers {
	/*
	 * IEEE754 が定める倍精度浮動小数点数は，符号部 1bit ，指数部 11 bit ，仮数部 52bit で
	 * 表現される．与えられた実数が倍精度浮動小数点数で厳密に表せない場合，上記の bit 数で値 を近似するしかない．このときに生じる誤差を 丸め誤差
	 * という．
	 */

	/*
	 * 値が非常に近い 2 つの浮動小数点数同士の減算を行うと，有効桁数が大幅に減ってしまうこと がある．この現象を 桁落ち という．
	 */

	/*
	 * 絶対値の大きさが著しく異なる 2 つの浮動小数点数を足すとき，絶対値の小さい方の値が計算 結果に反映されないことがある．この現象を 情報落ち
	 * という．
	 */

	/*
	 * |x| が極めて小さい場合 (x ̸= 0) ， √ 1+x− √ 1−x x を精度良く計算できる方法を考えよ . その理由を 説明せよ .
	 * |x| が極めて小さいとき， √ 1 + x ≈ √ 1 − x なので , 減算によって情報落ちが発生し , x を割る 際に大きい誤差が生じる
	 * . それを防ぐために , 2 √ 1+x+ √ 1−x と変形して計算するとよい
	 */
}