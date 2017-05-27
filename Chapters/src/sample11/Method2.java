package sample11;
import lib.Input;
public class Method2 {

	public static void main(String[] args) {

		System.out.println("*** BMIを計算 ***");

		double height = Input.getDouble("身長[m]を入力");
		double weight = Input.getDouble("体重[kg]を入力");

		dispBmi(height,weight);

		System.out.println("*** END ***");

	}

	public static void dispBmi(double height, double weight) {
		double bmi = weight / Math.pow(height, 2);
		System.out.printf("BMIは%.2fです\n", bmi);
		return;
	}

}
