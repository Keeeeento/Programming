package l02;

public class Nagasa5 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		int x[] = { 1, 2, 3, 4, 5 };
		int y[] = new int[5];
		System.out.println("x={1 2 3 4 5 }");
		System.out.print("y={");
		for (int n = 0; n < 5; n++) {
			y[n] = x[4 - n];
			System.out.print(y[n] + " ");
		}
		System.out.print("}");


	}

}

