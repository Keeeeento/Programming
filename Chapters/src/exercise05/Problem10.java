package exercise05;

public class Problem10 {

	public static void main(String[] args) {
		int r = 10;
		double v = 4 * Math.PI * Math.pow(r, 3) / 3;
		System.out.println("半径10の球の体積は" + v);

		double v_2 = 4.0 / 3.0 * Math.PI * Math.pow(r, 3);
		//double型の4/3を打たないと計算結果がint型になってしまう
		System.out.println("半径10の球の体積は" + v_2);
	}

}
