package mathlib;

public class DefaultCondition {

	/**
	 * 行列及び未知数ベクトルの次元数．<br>
	 * 行列，ベクトルの生成前に宣言が必要．
	 */
	protected static int n;
	/**
	 * マシンイプシロン．<br>
	 * 2e-16以上程度．
	 */
	protected static double epsilon;
	/**
	 * 反復回数<br>
	 * getIterationで反復回数を取得．
	 * for文の際に0が代入されている．
	 * また，収束しないときは0．
	 */
	protected static int iteration;
	/**
	 * 最大反復回数<br>
	 * <pre>
	 * {@code
	 * if(iteration >= maxIteration){
	 *    iteration = 0;
	 * }
	 * </pre>
	 */
	protected static int maxIteration;
	/**
	 * 収束判定条件などのノルム数<br>
	 * 任意の実数．
	 */
	protected static double normNumber;
	/**
	 * 収束判定条件が絶対誤差かどうか<br>
	 */
	protected static boolean isAbsolute; // 絶対誤差か

}
