package mathlib;

public class NewtonsMethod extends NonLinearEquation {

	protected static void newton() {
		for (iteration = 0; iteration <= maxIteration; iteration++) {
			x = x - f(x) / df(x);
			if (Math.abs(f(x)) < epsilon) {
				break;
			}
		}
	}

	public double solve() {
		newton();
		return x;
	}

}
