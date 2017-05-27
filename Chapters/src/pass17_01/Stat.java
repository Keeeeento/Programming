package pass17_01;

public class Stat extends BasicStat {
	public Stat(double[] data) {
		super(data);
	}

	public double sum() { // データの合計を計算して返す
		double sum = 0.0;
		for (double d : getData()) {
			sum += d;
		}
		return sum;
	}

	public double average() { // データの平均を計算して返す
		return sum() / size();
	}

}
