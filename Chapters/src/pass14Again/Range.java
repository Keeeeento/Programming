package pass14Again;

public class Range {

	private double min;
	private double max;

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

	public Range(double min, double max) {
		this.min = min;
		this.max = max;
	}

	public boolean isOk(double a) {
		if (a >= min && a <= max) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return "min:" + min + " - max:" + max;
	}

}
