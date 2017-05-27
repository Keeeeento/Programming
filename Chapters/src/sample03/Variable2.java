package sample03;
//作成日 2016.5.6
public class Variable2 {

	public static void main(String[] args) {

	int a = 10;    // int型の整数aの宣言と同時に10を代入 (宣言時の初期化)


	int b = a+5, c;// int型の整数bの宣言と同時に,式a+5を代入 かつint型の整数cを宣言 (b=15,cは空)

	c = a + b;     // c に a+b (の結果)を代入


	System.out.println(c);
	}

}
