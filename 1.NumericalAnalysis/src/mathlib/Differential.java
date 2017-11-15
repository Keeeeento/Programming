package mathlib;

public class Differential {

	String[] types;
	double[] values;

	public static double evaluate(String type, double value) {
		switch (type) {
		case "": // x
			return value;
		case "k": // x^k
			int k = Integer.parseInt(type);
			return Math.pow(k, value);
		case "sin":
			return Math.sin(value);
		case "cos":
			return Math.cos(value);
		case "exp":
			return Math.exp(value);
		case "log":
			return Math.log(value);
		case "sqrt":
			return Math.sqrt(value);
		default: // otherwise : undefined function names
			return 0;
		}
	}

	public static double f(String[] types, double[] values) {
		int n = types.length;
		double f = 0.0;
		//		if (types.length != values.length) {
		//			try {
		//			} catch (ArrayIndexOutOfBoundsException e) {
		//				System.out.println("配列の長さが違います");
		//			}
		//		}
		for (int i = 0; i < n; i++) {
			f += evaluate(types[i], values[i]);
		}
		return f;
	}

	public double d(String type, double value) {
		switch (type) {
		case "": // x
			return value;
		case "k":
			int k = Integer.parseInt(type);
			return k * Math.pow(k - 1, value);
		case "sin":
			return Math.sin(value);
		case "cos":
			return Math.cos(value);
		case "exp":
			return Math.exp(value);
		case "log":
			return Math.log(value);
		case "sqrt":
			return Math.sqrt(value);
		default: // otherwise : undefined function names
			return 0;
		}
	}

	public double d(double ) {

	}

	public static void main(String[] args) {
		double[] f = {};
	}
}
