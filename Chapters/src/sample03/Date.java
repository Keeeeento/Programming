package sample03;
//作成日 2016.5.6

public class Date {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		System.out.println(127);        // 何も指定しないとint型整数
		System.out.println(127L);       // 末尾にLをつけるとlong型整数
		System.out.println(0X7F);       // int型16進数


		//整数リテラル
		System.out.println(127);        // 10進数 (int型) … これが標準
		System.out.println(127L);       // 10進数 (long型)… 末尾に L または l をつける
		System.out.println(0x7f);       // 16進数 (int型) … 先頭に 0x または 0X をつける
		System.out.println(0177);       //  8進数 (int型) … 先頭に 0 をつける
		System.out.println(0b0111_1111);//  2進数 (int型) … 先頭に 0B または 0b をつける

		 //すべて10進数で127を表している


		//浮動小数点リテラル
		System.out.println(12.34);      //10進数 (double型)…これが標準
		System.out.println(12.34f);     //10進数 (float型) …末尾に f または F をつける
		System.out.println(1234e-2);    //10進数 (double型)…e または E で指数を表す

		 //すべて10進数で12.34を表している
		 //1234e-2 = 1234 * 10^(-2)

		//文字リテラル, 文字列リテラル
		System.out.println('あ');       //一文字 (char型)  …一重引用符で囲む
		System.out.println("あいう");   //文字列 (String型)…二重引用符で囲む


	}

}
