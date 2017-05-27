package sample10;

public class Maximum {

	public static void main(String[] args) {
		double[] array = { 1.2, 3.5, -9, 6.4, 5.0 };
		double max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		System.out.println("最大値は" + max);
	}

}
