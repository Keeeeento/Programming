package mathlib;

public abstract class NonLinearEquation extends NonLinearCondition {

	public static abstract double f(double x);

	public abstract double df(double x);

	public abstract int getIteration();

	public abstract double solve(double x);

}
