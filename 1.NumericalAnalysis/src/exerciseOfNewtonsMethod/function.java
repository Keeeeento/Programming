package exerciseOfNewtonsMethod;

public class function { // 微分したものを返せるかなと作ってみただけ

	public double dXToTheN(double x, double n) { // 整式の微分 xのn乗
		return n * Math.pow(x, n - 1);
	}

	public double dE(double x, double n) { // 指数関数 eのnx乗 の微分
		return n * Math.pow(Math.E, n * x);
	}

	public double dESin(double x, double n, double m) { // eのnx乗×sin(mx) の微分
		return dE(x, n) * Math.sin(m * x) + Math.pow(Math.E, n * x) * dSin(x, m);
	}

	public double dSin(double x, double n) { // 正弦関数 sin(nx) の微分
		return n * Math.cos(n * x);
	}

	public double dCos(double x, double n) { // 余弦関数 cos(nx) の微分
		return -n * Math.sin(n * x);
	}

}
