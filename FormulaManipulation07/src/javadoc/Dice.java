package javadoc;

/**
 * Diceクラス
 *
 * @author Kento Nakamura
 * @version 1.0
 */
public class Dice {

	/**
	 * 目数
	 */
	private int val;

	/**
	 * コンストラクタ
	 *
	 * @param val
	 *            目数
	 */
	public Dice(int val) {
		this.val = val;
	}

	/**
	 * サイコロを振る
	 */
	public void play() {
		val = (int) (Math.random() * 6 + 1);
	}

	/**
	 * 目数の取得
	 *
	 * @return 目数
	 */
	public int getVal() {
		return val;
	}

	/**
	 * 目数の設定
	 *
	 * @param val
	 *            目数
	 */
	public void setVal(int val) {
		this.val = val;
	}
}
