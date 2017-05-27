package sample06;

public class StringExample2 {

	public static void main(String[] args) {
		String ss = "abAB日本語ａｂＡＢ"; // 対象とする文字列

		int len = ss.length(); // 長さ
		int pos = ss.indexOf('日'); // 日の出現位置
		char ch = ss.charAt(5); // 先頭から4盤目の文字
		String str = ss.toLowerCase(); // 小文字への変換

		System.out.println("対象とする文字列は“" + ss + "”");
		System.out.println("長さは" + len);
		System.out.println("\'日\'は" + pos + "番目に現れる");
		System.out.println("5番目の文字は\'" + ch + "\'");
		System.out.println(ss + "→" + str);

	}
}
