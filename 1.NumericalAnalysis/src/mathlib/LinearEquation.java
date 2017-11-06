package mathlib;

public class LinearEquation {

	protected double epsilon = 1e-14;
	protected int max_iteration = 10000;

	public double getEpsilon() {
		return epsilon;
	}

	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}

	public int getMax_iteration() {
		return max_iteration;
	}

	public void setMax_iteration(int max_iteration) {
		this.max_iteration = max_iteration;
	}
}
