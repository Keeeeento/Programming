package mathlib;

public class ConvergenceDeterminationCondition {
	protected double epsilon;
	protected int max_iteration;
	protected double norm_number;
	protected boolean is_absolute; // 絶対誤差か

	public ConvergenceDeterminationCondition() {
		this.epsilon = 1e-14;
		this.max_iteration = (int) 1e+04;
		this.norm_number = 0;
		this.is_absolute = true;
	}

	public ConvergenceDeterminationCondition(double epsilon, int max_iteration, double norm, boolean is_absolute) {
		this.epsilon = epsilon;
		this.max_iteration = max_iteration;
		this.norm_number = norm;
		this.is_absolute = is_absolute;
	}

}
