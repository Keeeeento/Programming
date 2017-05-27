package sample03;
//作成日 2016.5.6

public class Variable1 {

	public static void main(String[] args) {

		int x;     // int型の変数 x を宣言
		x = 10;    // x に 10 を代入

		// int x = 10; で,宣言と同時に代入可能（宣言時の初期化）

		x = 20;    // x に 20 を上書き代入
		x = x + 1; // x に 1 を足して x に代入

		System.out.println(x);

	}

}
