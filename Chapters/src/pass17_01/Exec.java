package pass17_01;

public class Exec {
	public static void main(String[] args) {

		double[] data = { 65.1, 60.3, 75.5, 70.0, 67.3 };
		Stat s = new Stat(data);

		System.out.println("最小値 = " + s.min() + "\t 最大値 = " + s.max());
		System.out.println("合計 = "+s.sum() +"\t 平均 = "+s.average());
	}

}
