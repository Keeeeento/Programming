package pass14Again;

public class Exec {

	public static void main(String[] args) {

		Range r = new Range(50.0, 250.0);
		double[] data = { 150.5, 75.1, 35.3, 281.2, 210.3 };

		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i] + ":" + r.isOk(data[i]));
			;
		}

	}

}
