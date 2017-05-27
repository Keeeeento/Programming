package exercise06;

public class Exercise6_1_2 {

	public static void main(String[] args) {
		double[] data = { 1.1, 2.2, 3.3 };
		double d1, d2, d3;
		d1 = data[0] + data[1];
		d2 = data[2] / data[0];
		d3 = (data[0] + data[1] + data[2]) / data.length;
		// d3 = (data[0] + data[1] + data[2]) / 3;
		System.out.println("d1=" + d1);
		System.out.println("d2=" + d2);
		System.out.println("d3=" + d3);
		// System.out.println(data.length);

	}

}
