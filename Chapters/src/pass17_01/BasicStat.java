package pass17_01;

import java.util.Arrays;

public class BasicStat {

	private double[] data; // 処理すべきデータ

	public BasicStat(double[] data) { // 配列データを受け取るコンストラクタ
		this.data = data;
		Arrays.sort(data); // 配列を昇順にソートする
	}

	public double min() { // 最小値を返す
		return data[0];
	}

	public double max() { // 最大値を返す
		return data[data.length-1];
	}

	public int size() { // データの個数を返す
		return data.length;
	}

	protected double[] getData() { // 配列データを返す(非公開内部処理用)
		return data;
	}

}
