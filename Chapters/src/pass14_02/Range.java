package pass14_02;

public class Range {
	private double min; // 最小値
	private double max; // 最大値

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	// 問2
	public Range(double min, double max) {
		this.min = min;
		this.max = max;
	}

	// 問3
	public boolean isOk(double a) {
		if (min <= a && a < max) {
			return true;
		} else {
			return false;
		}
	}

	// 問4
	public String toString() {
		return "min : " + min + " - max : " + max;
	}
}
