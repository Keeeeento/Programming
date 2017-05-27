package exercise07;

public class Exercise7_1 {

	public static void main(String[] args) {
		double[] x = { 167.5, 180.3, 177.6, 166.7, 182.5, 175.4 };
		double sum = 0;
		for (int i = 0; i < x.length; i++) {
			sum = sum + x[i];
		}
		double average = sum / x.length;
		System.out.println("合計は" + sum);
		System.out.println("平均は" + average);
	}

}
